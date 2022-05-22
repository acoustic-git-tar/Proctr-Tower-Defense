package com.closednotes.proctr.objects.enemy.variants;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.scene.image.Image;

public class KhanAcademy extends Enemy {

    private Difficulty diff;
    private final int width = 60;
    private final int height = 60;
    
    public KhanAcademy(Vector2[] enemyPath) {

        id = "KhanAcademy";
        diff = TDApplication.getPlayer().getDifficulty();
        this.setImage(new Image(getClass()
                .getClassLoader().getResourceAsStream("khanAcademyBoss.png")));
        this.setFitHeight(height);
        this.setFitWidth(width);

        if (diff == Difficulty.CLOSED_NOTES) {
            monumentDamage = 0.50;
            health = 100;
        } else if (diff == Difficulty.CHEAT_SHEET) {
            monumentDamage = 0.60;
            health = 150;
        } else {
            monumentDamage = 0.70;
            health = 200;
        } // if
        totalHealth = health;
        this.updatePosition();
        this.distance = 0;

        this.enemyPath = enemyPath;
        this.tracker = new EnemyPathIterator(this.enemyPath);
        this.target = null;
        this.moveVector = null;
        this.moveSpeed = 1.5;

    } // KhanAcademy

} // KhanAcademy
