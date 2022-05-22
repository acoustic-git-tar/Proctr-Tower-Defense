package com.closednotes.proctr.objects.enemy;

import com.closednotes.proctr.objects.map.EnemyPathIterator;
import com.closednotes.proctr.objects.Player;
import com.closednotes.proctr.objects.Vector2;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

public abstract class Enemy extends ImageView {

    protected String id;

    protected double lastX;
    protected double lastY;
    protected double distance;

    protected double monumentDamage;
    protected int health;
    protected int totalHealth;

    protected Vector2[] enemyPath;
    protected EnemyPathIterator tracker;
    protected Vector2 target;
    protected Vector2 moveVector;
    protected double moveSpeed;

    public void attackMonument(Player player) {
        player.changeGPA(monumentDamage);
    } // attackMonument

    public void loseHealth(int damage) {
        health -= damage;
        ColorAdjust colorAdjust = new ColorAdjust();
        double fraction = ((double) health) / ((double) totalHealth);
        colorAdjust.setContrast(-(1 - fraction));
        setEffect(colorAdjust);
    } // loseHealth

    public double getMonumentDamage() {
        return monumentDamage;
    } // getMonumentDamage

    public int getHealth() {
        return health;
    } // getHealth

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    // Call this method every frame an enemy is active
    public void updateDistance() {

        double traversed = Vector2.getDistance(
            new Vector2(this.lastX, this.lastY),
            new Vector2(this.getX(), this.getY())
        );

        if (traversed == 0) {
            return;

        } // if

        distance += traversed;
        updatePosition();

    } // updateDistance

    protected void updatePosition() {
        this.lastX = this.getX();
        this.lastY = this.getY();

    } // updatePosition

    public void goTo(Vector2 destination) {
        this.setX(destination.getX());
        this.setY(destination.getY());
        updateDistance();

    } // goTo

    public boolean moveTowardsTarget() {

        if (this.target == null) {
            return false;
        }

        if (this.getX() == this.target.getX() && this.getY() == this.target.getY()) {

            this.target = this.tracker.next();
            if (this.target == null) {
                return false;
            }

            this.adjustTarget();

            double moveX = this.target.getX() - this.getX();
            double moveY = this.target.getY() - this.getY();
            this.moveVector = Vector2.normalize(new Vector2(moveX, moveY));
            moveVector.setX(moveVector.getX() * moveSpeed);
            moveVector.setY(moveVector.getY() * moveSpeed);

        } else {

            this.setX(this.getX() + moveVector.getX());
            this.setY(this.getY() + moveVector.getY());

            if ((this.moveVector.getX() > 0 && this.getX() > this.target.getX())
                || (this.moveVector.getX() < 0 && this.getX() < this.target.getX())) {
                this.setX(this.target.getX());

            } // if

            if ((this.moveVector.getY() > 0 && this.getY() > this.target.getY())
                || (this.moveVector.getY() < 0 && this.getY() < this.target.getY())) {
                this.setY(this.target.getY());

            } // if

            updateDistance();

        } // if

        return true;

    } // moveTowardsTarget

    public Vector2[] getEnemyPath() {
        return this.enemyPath;
    }

    public EnemyPathIterator getTracker() {
        return this.tracker;
    }

    public Vector2 getTarget() {
        return this.target;
    }
    public void setTarget(Vector2 target) {
        this.target = target;
    }

    public void adjustTarget() {
        this.target.setX(this.target.getX() - this.getFitWidth() / 2);
        this.target.setY(this.target.getY() - this.getFitWidth() / 2);
    } // adjustTarget

    public Vector2 getMoveVector() {
        return this.moveVector;
    }
    public void setMoveVector(Vector2 moveVector) {
        this.moveVector = moveVector;
    }

    public double getMoveSpeed() {
        return this.moveSpeed;
    }
    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    @Override
    public String toString() {
        return "Enemy " + id;
    }

} // Enemy
