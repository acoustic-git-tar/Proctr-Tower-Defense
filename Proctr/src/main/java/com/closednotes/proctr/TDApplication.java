package com.closednotes.proctr;

import com.closednotes.proctr.objects.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;

import java.io.IOException;
import java.io.InputStream;

public class TDApplication extends Application {

    private int width = 1024;
    private int height = 576;
    private static Player player;
    public static Player getPlayer() {
        return player;
    }
    public static void setPlayer(Player players) {
        player = players;
    }

    @Override
    public void start(Stage stage) {

        displayStartScreen(stage);
        stage.setResizable(false);
        stage.setTitle("Proctr");
        stage.getIcons().add(new Image(getClass()
                .getClassLoader().getResourceAsStream("gameicon.png")));
        stage.show();

    } // start

    public void displayStartScreen(Stage stage) {

        Button startButton = new Button("Start");
        Button quitButton = new Button("Quit");

        InputStream is = getClass().getClassLoader().getResourceAsStream("title.png");
        Image backgroundImage = new Image(is);
        BackgroundImage bImage = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO,
                        BackgroundSize.AUTO, true, true, true, false));
        Background ground = new Background(bImage);

        VBox vbox = new VBox(10.0, startButton, quitButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(ground);
        Scene startScreen = new Scene(vbox, width, height);

        startButton.setOnAction(event -> displayConfigScreen(stage));
        quitButton.setOnAction(event -> stage.close());

        stage.setTitle("Proctr");
        stage.setScene(startScreen);

    } // displayStartScreen

    public void displayConfigScreen(Stage stage) {
        TextField nameInput = new TextField("Player");
        Button nameButton = new Button("Reset");
        Label errorName = new Label();
        errorName.setTextFill(Color.RED);
        HBox nameBox = new HBox(10.0, errorName, nameInput, nameButton);
        nameBox.setAlignment(Pos.TOP_CENTER);

        nameButton.setOnAction(event -> {
            errorName.setText("");
            nameInput.setText("Player");
        }); // setOnAction

        final ToggleGroup diffGroup = new ToggleGroup();

        Label diffLabel = new Label("Choose a difficulty:");
        RadioButton easyButton = new RadioButton("Closed Notes");
        easyButton.setSelected(true);
        easyButton.setToggleGroup(diffGroup);
        RadioButton mediumButton = new RadioButton("Cheat Sheet");
        mediumButton.setToggleGroup(diffGroup);
        RadioButton hardButton = new RadioButton("Open Notes");
        hardButton.setToggleGroup(diffGroup);

        VBox configVBox = new VBox(10.0, easyButton, mediumButton, hardButton);
        configVBox.setAlignment(Pos.CENTER);

        Button backButton = new Button("Back");
        Button confirmButton = new Button("Confirm");
        HBox backAndConfirm = new HBox(100.0, backButton, confirmButton);
        backAndConfirm.setAlignment(Pos.BOTTOM_CENTER);

        backButton.setOnAction(event -> displayStartScreen(stage));


        VBox boxes = new VBox(50.0, nameBox, configVBox, backAndConfirm);
        boxes.setAlignment(Pos.CENTER);

        Scene configScreen = new Scene(boxes, width, height);
        confirmButton.setOnAction(event -> {
            if (nameInput.getCharacters().toString().trim().equals("")) {
                errorName.setText("Invalid name!");
            } else {
                String selected = ((RadioButton) diffGroup.getSelectedToggle()).getText();
                Difficulty diff = Difficulty.CLOSED_NOTES;
                switch (selected) {
                case "Closed Notes":
                    diff = Difficulty.CLOSED_NOTES;
                    break;
                case "Cheat Sheet":
                    diff = Difficulty.CHEAT_SHEET;
                    break;
                case "Open Notes":
                    diff = Difficulty.OPEN_NOTES;
                    break;
                default:
                    diff = Difficulty.CHEAT_SHEET;
                } // switch
                player = new Player(nameInput.getText(), diff);
                setPlayer(player);
                displayConfirmScreen(stage, configScreen);
                errorName.setText("");
            } // if
        }); // setOnAction
        stage.setScene(configScreen);

    } // displayConfigScreen

    public void displayConfirmScreen(Stage stage, Scene prev) {

        String playerDifficulty = "";
        switch (player.getDifficulty()) {
        case CLOSED_NOTES:
            playerDifficulty = "Closed Notes";
            break;
        case CHEAT_SHEET:
            playerDifficulty = "Cheat Sheet";
            break;
        case OPEN_NOTES:
            playerDifficulty = "Open Notes";
            break;
        default:
            playerDifficulty = "Cheat Sheet";
        } // switch

        Label playerName = new Label("Name: " + player.getName());
        Label check = new Label("Is this correct? Go back if you need to make changes.\n");
        check.setPadding(new Insets(0, 0, 20, 0));
        check.setTextFill(Color.RED);
        Label playerDiffLabel = new Label("Difficulty: " + playerDifficulty);
        playerDiffLabel.setPadding(new Insets(0, 0, 20, 0));

        Button backButton = new Button("Back");
        Button startButton = new Button("Start");
        HBox backAndStart = new HBox(100.0, backButton, startButton);
        backAndStart.setAlignment(Pos.CENTER);

        backButton.setOnAction(event -> stage.setScene(prev));
        startButton.setOnAction(event -> displayGameScreen(stage));
        VBox order = new VBox(check, playerName, playerDiffLabel, backAndStart);
        order.setAlignment(Pos.CENTER);
        Scene confirmScreen = new Scene(order, width, height);
        stage.setScene(confirmScreen);
    } // displayConfirmScreen

    public void displayGameScreen(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(GameController.class.getResource("game-view.fxml"));
            stage.setTitle("Proctr");
            Scene gameScene = new Scene(loader.load(), width, height);
            Label money = (Label) gameScene.lookup("#money");
            money.setText(player.getMoney() + "");
            Label gpa = (Label) gameScene.lookup("#gpa");
            gpa.setText(player.getGpa() + "");
            stage.setScene(gameScene);
            GameController.setStage(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // displayGameScreen

    public static void main(String[] args) {
        launch();
    } // main

} // TDApplication