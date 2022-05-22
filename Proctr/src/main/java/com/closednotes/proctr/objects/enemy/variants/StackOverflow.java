package com.closednotes.proctr.objects.enemy.variants;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.scene.image.Image;

public class StackOverflow extends Enemy {

    private Difficulty diff;
    private final int width = 60;
    private final int height = 60;
    
    public StackOverflow(Vector2[] enemyPath) {

        id = "StackOverflow";
        diff = TDApplication.getPlayer().getDifficulty();
        this.setImage(new Image(getClass()
                .getClassLoader().getResourceAsStream("stackOverflowBoss.png")));
        this.setFitHeight(height);
        this.setFitWidth(width);

        if (diff == Difficulty.CLOSED_NOTES) {
            monumentDamage = 0.60;
            health = 200;
        } else if (diff == Difficulty.CHEAT_SHEET) {
            monumentDamage = 0.75;
            health = 275;
        } else {
            monumentDamage = 0.90;
            health = 350;
        } // if
        totalHealth = health;
        this.updatePosition();
        this.distance = 0;

        this.enemyPath = enemyPath;
        this.tracker = new EnemyPathIterator(this.enemyPath);
        this.target = null;
        this.moveVector = null;
        this.moveSpeed = 1.25;

    } // StackOverflow

} // StackOverflow
