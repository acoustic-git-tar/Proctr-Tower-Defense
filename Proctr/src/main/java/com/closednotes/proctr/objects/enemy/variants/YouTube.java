package com.closednotes.proctr.objects.enemy.variants;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.scene.image.Image;

public class YouTube extends Enemy {

    private Difficulty diff;
    private final int width = 60;
    private final int height = 60;
    
    public YouTube(Vector2[] enemyPath) {

        id = "YouTube";
        diff = TDApplication.getPlayer().getDifficulty();
        this.setImage(new Image(getClass()
                .getClassLoader().getResourceAsStream("youtubeBoss.png")));
        this.setFitHeight(height);
        this.setFitWidth(width);

        if (diff == Difficulty.CLOSED_NOTES) {
            monumentDamage = 0.80;
            health = 300;
        } else if (diff == Difficulty.CHEAT_SHEET) {
            monumentDamage = 1.00;
            health = 400;
        } else {
            monumentDamage = 1.20;
            health = 500;
        } // if
        totalHealth = health;
        this.updatePosition();
        this.distance = 0;

        this.enemyPath = enemyPath;
        this.tracker = new EnemyPathIterator(this.enemyPath);
        this.target = null;
        this.moveVector = null;
        this.moveSpeed = 1.0;

    } // YouTube

} // Enemy
