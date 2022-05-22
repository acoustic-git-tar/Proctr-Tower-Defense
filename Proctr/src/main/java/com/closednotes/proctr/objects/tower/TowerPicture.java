package com.closednotes.proctr.objects.tower;

import com.closednotes.proctr.GameController;
import com.closednotes.proctr.TDApplication;
import com.closednotes.proctr.objects.enemy.EnemyWrapper;
import com.closednotes.proctr.objects.tower.Tower;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.InputStream;

import static java.lang.Math.toDegrees;

public class TowerPicture extends ImageView {

    private double xPosition;
    private double yPosition;
    private Tower tower;
    private String towerClass;

    public TowerPicture(double xPosition, double yPosition, Tower tower) {
        super();
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.tower = tower;
    }

    public double getXPos() {
        return xPosition;
    } //getX

    public double getYPos() {
        return yPosition;
    } // getY

    public void setPosition(double x, double y) {
        xPosition = x;
        yPosition = y;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public Tower getTower() {
        return tower;
    }

    private InputStream determineAnimation(EnemyWrapper enemy) {
        InputStream animation = null;
        switch (towerClass) {
        case("TA"):
            animation = TDApplication.class.getClassLoader()
                    .getResourceAsStream("TA_Projectile.png");
            break;
        case("Buzzcard"):
            animation = TDApplication.class.getClassLoader()
                    .getResourceAsStream("Buzzcard_Swipe.png");
            break;
        case("LockdownBrowser"):
            animation = TDApplication.class.getClassLoader()
                    .getResourceAsStream("Lockdown_Projectile.png");
            break;
        default:
            break;
        }
        return animation;
    }

    public void upgradeTower(Upgrade upgrade) {
        tower = upgrade;
        if (towerClass.equals("Buzzcard")) {
            if (tower.getLevel() == 3) {
                this.setImage(new Image(TDApplication.class.getClassLoader().getResourceAsStream("Buzzcard_Tower_Upgrade_1.png")));
            } else if (tower.getLevel() == 4) {
                this.setImage(new Image(TDApplication.class.getClassLoader().getResourceAsStream("Buzzcard_Tower_Upgrade_2.png")));
            }
        } else if (towerClass.equals("TA")) {
            if (tower.getLevel() == 3) {
                this.setImage(new Image(TDApplication.class.getClassLoader().getResourceAsStream("TA_Tower_Upgrade_1.png")));
            } else if (tower.getLevel() == 4) {
                this.setImage(new Image(TDApplication.class.getClassLoader().getResourceAsStream("TA_Tower_Upgrade_2.png")));
            }
        } else if (towerClass.equals("LockdownBrowser")) {
            if (tower.getLevel() == 3) {
                this.setImage(new Image(TDApplication.class.getClassLoader().getResourceAsStream("Lockdown_Browser_Tower_Upgrade_1.png")));
            } else if (tower.getLevel() == 4) {
                this.setImage(new Image(TDApplication.class.getClassLoader().getResourceAsStream("Lockdown_Browser_Tower_Upgrade_2.png")));
            }
        }
    }

    private void createTransition(InputStream is, EnemyWrapper enemy) {
        final ImageView image = new ImageView(new Image(is, 10, 20, true, true));
        double prevX = this.getX() + this.getFitWidth() / 2;
        double prevY =this.getY() + this.getFitHeight() / 2;
        double afterX = enemy.getGameObject().getX() + enemy.getGameObject().getFitWidth() / 2;
        double afterY = enemy.getGameObject().getY() + enemy.getGameObject().getFitHeight() / 2;
        double rotation = toDegrees(Math.atan((afterY-prevY)/(afterX-prevX))) + 90;
        image.setRotate(rotation);
        TranslateTransition t = new TranslateTransition(Duration.seconds(0.5), image);
        t.setFromX(prevX);
        t.setFromY(prevY);
        t.setToX(afterX);
        t.setToY(afterY);
        t.setInterpolator(Interpolator.LINEAR);
        enemy.getAnchor().getChildren().add(image);
        t.setOnFinished((finish) -> enemy.getAnchor().getChildren().remove(image));
        t.playFromStart();
    }

    public void attackEnemy(EnemyWrapper enemy) {
        if (this.getTower().getCounter() < this.getTower().getDPS()) {
            this.getTower().incrementCounter();
            return;
        }
        this.getTower().setCounter(0);
      
        InputStream animation = determineAnimation(enemy);

        createTransition(animation, enemy);
        enemy.getGameObject().loseHealth(this.getTower().getDamage());
        if (enemy.getGameObject().getHealth() < 0) {
            enemy.deactivate();
            TDApplication.getPlayer().earnMoney(5);
            GameController.moneyEarned+=5;
            GameController.updateMoney();
        }
    }

    public void setTowerClass(String string) {
        towerClass = string;
    }
}   
