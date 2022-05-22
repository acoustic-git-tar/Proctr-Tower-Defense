package com.closednotes.proctr.objects.enemy;

import com.closednotes.proctr.objects.GameObjectWrapper;
import com.closednotes.proctr.objects.enemy.Enemy;
import javafx.application.Platform;

/**
 * Extension of the GameObjectWrapper class.
 * Can be instantiated with an enemy to allow
 * for the creation of enemy pools.
 */
public class EnemyWrapper extends GameObjectWrapper<Enemy> {

    /**
     * Constructor
     *
     * @param e enemy object
     */
    public EnemyWrapper(Enemy e) {

        this.gameObject = e;
        this.anchor = null;

        this.active = false;

        // Will be called when enemy is activated
        this.onActivate = () -> {

            Enemy enemy = this.getGameObject();
            enemy.getTracker().reset();
            enemy.setTarget(enemy.getTracker().next());
            enemy.adjustTarget();
            enemy.goTo(enemy.getTarget());
            enemy.setDistance(0);
            //            enemy.move();

            Platform.runLater(() -> this.addToScene());

        };

        // Will be called when enemy is deactivated
        this.onDeactivate = () -> {
            Platform.runLater(() -> this.removeFromScene());

        };

    } // Constructor

    public String toString() {
        return gameObject.toString();
    }

} // EnemyWrapper