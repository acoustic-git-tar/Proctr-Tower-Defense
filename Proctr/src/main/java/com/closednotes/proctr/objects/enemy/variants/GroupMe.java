package com.closednotes.proctr.objects.enemy.variants;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.scene.image.Image;

public class GroupMe extends Enemy {

    private Difficulty diff;
    private final int width = 50;
    private final int height = 50;

    public GroupMe(Vector2[] enemyPath) {

        id = "GroupMe";
        diff = TDApplication.getPlayer().getDifficulty();
        this.setImage(new Image(getClass()
                .getClassLoader().getResourceAsStream("groupMeEnemy.png")));
        this.setFitHeight(height);
        this.setFitWidth(width);

        if (diff == Difficulty.CLOSED_NOTES) {
            monumentDamage = 0.2;
            health = 30;
        } else if (diff == Difficulty.CHEAT_SHEET) {
            monumentDamage = 0.24;
            health = 45;
        } else {
            monumentDamage = 0.28;
            health = 60;
        } // if
        totalHealth = health;
        this.updatePosition();
        this.distance = 0;

        this.enemyPath = enemyPath;
        this.tracker = new EnemyPathIterator(this.enemyPath);
        this.target = null;
        this.moveVector = null;
        this.moveSpeed = 3.0;

    } // GroupMe

} // GroupMe
