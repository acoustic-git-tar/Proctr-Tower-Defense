package com.closednotes.proctr.objects.enemy.variants;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.scene.image.Image;

public class Chegg extends Enemy {

    private Difficulty diff;
    private final int width = 75;
    private final int height = 75;

    public Chegg(Vector2[] enemyPath) {

        id = "Chegg";
        diff = TDApplication.getPlayer().getDifficulty();
        this.setImage(new Image(getClass()
                .getClassLoader().getResourceAsStream("cheggBoss.png")));
        this.setFitHeight(height * 5);
        this.setFitWidth(width * 5);

        if (diff == Difficulty.CLOSED_NOTES) {
            monumentDamage = 2.00;
            health = 400;
        } else if (diff == Difficulty.CHEAT_SHEET) {
            monumentDamage = 2.50;
            health = 600;
        } else {
            monumentDamage = 3.00;
            health = 800;
        } // if
        totalHealth = health;
        this.updatePosition();
        this.distance = 0;

        this.enemyPath = enemyPath;
        this.tracker = new EnemyPathIterator(this.enemyPath);
        this.target = null;
        this.moveVector = null;
        this.moveSpeed = 0.5;

    } // Chegg

} // Enemy
