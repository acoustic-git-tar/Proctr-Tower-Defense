package com.closednotes.proctr.objects;

import com.closednotes.proctr.GameController;
import com.closednotes.proctr.TDApplication;
import com.closednotes.proctr.objects.enemy.EnemyWrapper;
import com.closednotes.proctr.objects.tower.TowerPicture;
import javafx.animation.AnimationTimer;

/**
 * Contains an update method that occurs on
 * every frame of gameplay
 */
public class UpdateTimer extends AnimationTimer {

    private int i;
    private int frame;
    private Pool<EnemyWrapper> enemies;

    private boolean running;

    /**
     * UpdateTimer constructor
     *
     * @param enemies current enemy pool
     */
    public UpdateTimer(Pool<EnemyWrapper> enemies) {

        super();

        this.i = 0;
        this.frame = 0;
        this.enemies = enemies;
        this.running = true;

    } // UpdateTimer

    /**
     * Update method. Occurs every frame
     *
     * @param l time in milliseconds (not used)
     */
    @Override
    public void handle(long l) {

        if (frame % 60 == 0 && i < enemies.size()) {
            enemies.activate(i++);

        } // if

        for (EnemyWrapper ew : enemies) {

            if (ew.isActive()) {

                boolean moved = ew.getGameObject().moveTowardsTarget();

                if (!moved) {

                    ew.getGameObject()
                            .attackMonument(TDApplication.getPlayer());

                    GameController.updateGPA();
                    ew.deactivate();

                } // if

            } // if
        } // for

        for (TowerPicture t: TDApplication.getPlayer().getTowerList()) {
            for (EnemyWrapper ew : enemies) {
                if (ew.isActive()) {
                    double dist = Vector2.getDistance(
                            new Vector2(ew.getGameObject().getX(), ew.getGameObject().getY()),
                            new Vector2(t.getX(), t.getY()));
                    if (dist < t.getTower().getRange()) {
                        t.attackEnemy(ew);
                    }
                }
            }
        }


        boolean allEnemiesDestroyed = true;

        for (EnemyWrapper ew : enemies) {

            if (ew.isActive()) {
                allEnemiesDestroyed = false;

            } // if

        } // for

        if (allEnemiesDestroyed) {
            running = false;

        } // if


        frame++;

    } // handle

    public boolean isRunning() {
        return this.running;

    } // isRunning

} // UpdateTimer
