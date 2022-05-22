package com.closednotes.proctr.objects.enemy.variants;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.scene.image.Image;

public class Textbook extends Enemy {

    private Difficulty diff;
    private final int width = 50;
    private final int height = 50;

    public Textbook(Vector2[] enemyPath) {

        id = "Textbook";
        diff = TDApplication.getPlayer().getDifficulty();
        this.setImage(new Image(getClass()
                .getClassLoader().getResourceAsStream("textbookEnemy.png")));
        this.setFitHeight(height);
        this.setFitWidth(width);

        if (diff == Difficulty.CLOSED_NOTES) {
            monumentDamage = 0.15;
            health = 20;
        } else if (diff == Difficulty.CHEAT_SHEET) {
            monumentDamage = 0.18;
            health = 30;
        } else {
            monumentDamage = 0.21;
            health = 40;
        } // if
        totalHealth = health;
        this.updatePosition();
        this.distance = 0;

        this.enemyPath = enemyPath;
        this.tracker = new EnemyPathIterator(this.enemyPath);
        this.target = null;
        this.moveVector = null;
        this.moveSpeed = 5.0;

    } // Textbook

} // Textbook
