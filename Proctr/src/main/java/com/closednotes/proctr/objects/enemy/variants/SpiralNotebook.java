package com.closednotes.proctr.objects.enemy.variants;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.scene.image.Image;

public class SpiralNotebook extends Enemy {

    private Difficulty diff;
    private final int width = 50;
    private final int height = 50;

    public SpiralNotebook(Vector2[] enemyPath) {

        id = "SpiralNotebook";
        diff = TDApplication.getPlayer().getDifficulty();
        this.setImage(new Image(getClass()
                .getClassLoader().getResourceAsStream("spiralNotebookEnemy.png")));
        this.setFitHeight(height);
        this.setFitWidth(width);

        if (diff == Difficulty.CLOSED_NOTES) {
            monumentDamage = 0.1;
            health = 10;
        } else if (diff == Difficulty.CHEAT_SHEET) {
            monumentDamage = 0.12;
            health = 15;
        } else {
            monumentDamage = 0.14;
            health = 20;
        } // if

        totalHealth = health;
        this.updatePosition();
        this.distance = 0;

        this.enemyPath = enemyPath;
        this.tracker = new EnemyPathIterator(this.enemyPath);
        this.target = null;
        this.moveVector = null;
        this.moveSpeed = 6.0;

    } // SpiralNotebook

} // SpiralNotebook
