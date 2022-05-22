package com.closednotes.proctr;

import com.closednotes.proctr.objects.*;
import com.closednotes.proctr.objects.enemy.EnemyWrapper;
import com.closednotes.proctr.objects.map.LevelFactory;
import com.closednotes.proctr.objects.tower.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class GameController {

    private boolean shopOpened = false;
    private Shop shop = new Shop(Difficulty.CLOSED_NOTES);
    private static Stage tempStage;
    private static String temp;
    private static BufferedImage gameScreen;
    private static boolean gameOver = false;
    private static boolean roundInProgress = false;
    private static Pool<EnemyWrapper> enemyPool;
    private static final DecimalFormat DF = new DecimalFormat("#.##");

    private static int level = 1;

    private static double gpaDiff = 0.0;
    public static int moneyEarned = 0;

    @FXML private Label money = new Label("0.0");
    @FXML private Label gpa = new Label("0.0");
    @FXML
    protected void openShopMenu(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            tempStage = (Stage) node.getScene().getWindow();
            Stage shopStage = new Stage();
            shopStage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader(GameController.class.getResource("shop-view.fxml"));
            shopStage.setTitle("Proctr");
            shopStage.setScene(new Scene(loader.load(), 512, 512));
            shopStage.setOnCloseRequest(close -> {
                money.setText(TDApplication.getPlayer().getMoney() + "");
            });
            shopStage.setOnHidden(close -> {
                money.setText(TDApplication.getPlayer().getMoney() + "");
                if (temp != null) {
                    addToweronMap(temp);
                }
            });
            shopStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onQuitButtonClick(ActionEvent event) {
        ((Stage) ((((Button) event.getSource()).getScene()).getWindow())).close();
    }

    public void addToweronMap(String towerClass) {
        TowerPicture towerPicture = new TowerPicture(0, 0, null);
        Scene sc = tempStage.getScene();
        AnchorPane anchor = (AnchorPane) sc.lookup("#anchor");
        Tower tower = null;
        switch (towerClass) {
        case ("Buzzcard"):
            InputStream buzzStream = TDApplication.class.getClassLoader()
                    .getResourceAsStream("Buzzcard_Tower.png");
            Image buzzImage = new Image(buzzStream);
            towerPicture.setImage(buzzImage);
            tower = new Buzzcard(TDApplication.getPlayer().getDifficulty());
            break;
        case ("LockdownBrowser"):
            InputStream lockStream = TDApplication.class.getClassLoader()
                    .getResourceAsStream("Lockdown_Browser_Tower.png");
            Image lockImage = new Image(lockStream);
            towerPicture.setImage(lockImage);
            tower = new LockdownBrowser(TDApplication.getPlayer().getDifficulty());
            break;
        case ("TA"):
            InputStream taStream = TDApplication.class.getClassLoader()
                    .getResourceAsStream("TA_Tower.png");
            Image taImage = new Image(taStream);
            towerPicture.setImage(taImage);
            tower = new TA(TDApplication.getPlayer().getDifficulty());
            break;
        default:
            tower = null;
        }
        //BufferedImage gameScreen = null;
        try {
            gameScreen = ImageIO.read(TDApplication.class.getResource("/gameMap.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        towerPicture.setFitHeight(50);
        towerPicture.setFitWidth(50);
        towerPicture.setPosition(towerPicture.getX(), towerPicture.getY());
        towerPicture.setOnMouseDragged(e -> {
            towerPicture.setX(e.getSceneX() - 25);
            towerPicture.setY(e.getSceneY() - 25);
        });
        towerPicture.setOnMouseReleased(e -> {
            if (!checkForValidLocation(gameScreen, towerPicture.getX(), towerPicture.getY())) {
                towerPicture.setX(towerPicture.getXPos());
                towerPicture.setY(towerPicture.getYPos());
            } else {
                towerPicture.setPosition(towerPicture.getX(), towerPicture.getY());
            }
        });
        towerPicture.setTowerClass(towerClass);
        towerPicture.setTower(tower);
        towerPicture.setOnMouseClicked( e -> {
            if (TDApplication.getPlayer().getMoney() >= 20) {
                TDApplication.getPlayer().earnMoney(-20);
                Label money = (Label) tempStage.getScene().lookup("#money");
                money.setText(TDApplication.getPlayer().getMoney() + "");
                towerPicture.upgradeTower(new DamageUpgrade(towerPicture.getTower()));
            }
        });
        temp = null;
        anchor.getChildren().add(towerPicture);
        TDApplication.getPlayer().addToTowerList(towerPicture);
    }

    public static void setTemp(Tower tower) {
        temp = tower.getClass().toString().substring(43);
    }

    public boolean checkForValidLocation(BufferedImage gameScreen,
                                         double xLocation, double yLocation) {
        int halfX = (int) (xLocation / 2);
        int halfY = (int) (yLocation / 2);
        boolean isValid = true;
        for (int i = halfX; i < halfX + 25; i++) {
            for (int j = halfY; j < halfY + 25; j++) {
                if (i < gameScreen.getWidth() && j < gameScreen.getHeight() && i > 0 && j > 0) {
                    Color c = new Color(gameScreen.getRGB(i, j));
                    if (c.getRed() == 33 && c.getGreen() == 75 && c.getBlue() == 133) {
                        isValid = false;
                    }
                } else {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    public void beginLevel(ActionEvent event) throws InterruptedException {

        if (!roundInProgress) {
            roundInProgress = true;

            Scene sc = tempStage.getScene();
            AnchorPane anchor = (AnchorPane) sc.lookup("#anchor");

            Pair<Boolean, Pool<EnemyWrapper>> levelData = LevelFactory.createLevelData(anchor, level, 1);
            enemyPool = levelData.getValue();
            UpdateTimer update = new UpdateTimer(enemyPool);
            update.start();

            Utility.runNow(() -> {

                boolean looping = true;

                while (looping) {

                    System.out.print(""); // The loop doesn't run without this (not sure why)

                    if (!update.isRunning()) {
                        looping = false;

                    } // if

                } // while

                Platform.runLater(() -> {

                    update.stop();

                    if (levelData.getKey()) {

                        roundInProgress = false;

                        if (TDApplication.getPlayer().getGpa() < 4.00) {
                            // End game here (Win!)
                            gameOver = true;
                            ButtonType quit = new ButtonType("Quit", ButtonBar.ButtonData.NO);
                            ButtonType restart = new ButtonType("Restart", ButtonBar.ButtonData.YES);
                            Alert a = new Alert(Alert.AlertType.NONE,
                                    "Good job my litttle pogchamp, you won \n"
                                            + "LOST HEALTH: " + DF.format(gpaDiff) + "\n"
                                            + "MONEY EARNED:  " + moneyEarned + "\n"
                                            + "LEVELS SURVIVED: " + level, quit, restart);
                            a.setTitle("Winning Screen");
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    a.showAndWait().ifPresent(response -> {
                                        if (response.getButtonData() == ButtonBar.ButtonData.YES) {

                                            for (EnemyWrapper e : enemyPool) {
                                                e.deactivate();

                                            } // for

                                            roundInProgress = false;
                                            gameOver = false;
                                            level = 1;
                                            tempStage.hide();
                                            Platform.runLater(() -> {
                                                new TDApplication().start(new Stage());
                                            });
                                        }
                                        if (response.getButtonData() == ButtonBar.ButtonData.NO) {
                                            System.exit(0);
                                        }
                                    });
                                }
                            });
                        }

                    } else {

                        level++;

                        Button startButton = (Button) sc.lookup("#startButton");
                        startButton.setText("Start Round " + level);

                        roundInProgress = false;

                    } // if


                });

            });

        } // if

    } // beginLevel

    public static void setStage(Stage stage) {
        tempStage = stage;
    }

    public static void updateGPA() {
        Label gpa = (Label) tempStage.getScene().lookup("#gpa");
        gpa.setText(DF.format(TDApplication.getPlayer().getGpa()));
        gpaDiff = TDApplication.getPlayer().getGpa() - new Player("", TDApplication.getPlayer().getDifficulty()).getGpa();
        continueGame();
    }

    public static void updateMoney() {
        Label money = (Label) tempStage.getScene().lookup("#money");
        money.setText(TDApplication.getPlayer().getMoney() + "");
        continueGame();
    }

    public static boolean continueGame() {
        if (TDApplication.getPlayer().getGpa() > 4.0 & !gameOver) {
            gameOver = true;
            ButtonType quit = new ButtonType("Quit", ButtonBar.ButtonData.NO);
            ButtonType restart = new ButtonType("Restart", ButtonBar.ButtonData.YES);
            Alert a = new Alert(Alert.AlertType.WARNING,
                    "Oh no! You lost \n"
                            + "LOST HEALTH: " + DF.format(gpaDiff) + "\n"
                            + "MONEY EARNED:  " + moneyEarned + "\n"
                            + "LEVELS SURVIVED: " + level, quit, restart);
            a.setTitle("Losing Screen");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    a.showAndWait().ifPresent(response -> {
                        if (response.getButtonData() == ButtonBar.ButtonData.YES) {

                            for (EnemyWrapper e : enemyPool) {
                                e.deactivate();

                            } // for

                            roundInProgress = false;
                            gameOver = false;
                            level = 1;
                            tempStage.hide();
                            Platform.runLater(() -> {
                                new TDApplication().start(new Stage());
                            });
                        }
                        if (response.getButtonData() == ButtonBar.ButtonData.NO) {
                            System.exit(0);
                        }
                    });
                }
            });
            return false;
        }
        return true;
    }

}
