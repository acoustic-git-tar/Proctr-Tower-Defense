package com.closednotes.proctr.objects.tower;

import com.closednotes.proctr.objects.GameObjectWrapper;
import com.closednotes.proctr.objects.enemy.Enemy;

import java.io.InputStream;

public class Tower extends GameObjectWrapper {
    protected int damage;

    protected int range;
    protected int counter = 0;
    protected int dps;
    protected int attackRange;
    protected int purchaseCost;
    protected int sellCost;
    protected String description;
    private double xPosition;
    private double yPosition;
    protected InputStream animation;
    protected int level = 1;

    public String getDescription() {
        return description;
    } // getDescription

    public int getDamage() {
        return damage;
    } // getDamage

    public int getRange() { return range; } // getRange

    public int getAttackRange() {
        return attackRange;
    } // getAttackRange

    public int getPurchaseCost() {
        return purchaseCost;
    } // getPurchaseCost

    public int getSellCost() {
        return sellCost;
    } // getSellCost

    public int getLevel() {
        return 1;
    } // getLevel

    public int getDPS() { return dps; } // getDPS

    public int getCounter() { return counter; } // getCounter

    public void setCounter(int newValue) { counter = newValue; } // setCounter

    public void incrementCounter() { counter++; } // incrementCounter

    public InputStream getAnimation() {
        return animation;
    }

} // Tower
