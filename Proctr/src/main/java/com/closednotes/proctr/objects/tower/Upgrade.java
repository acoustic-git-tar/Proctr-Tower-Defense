package com.closednotes.proctr.objects.tower;

import com.closednotes.proctr.objects.tower.Tower;

public abstract class Upgrade extends Tower {

    protected Tower tower;

    protected Upgrade(Tower tower) {

        this.tower = tower;

        this.animation = tower.getAnimation();
        this.damage = tower.getDamage();
        this.range = tower.getRange();
        this.dps = tower.getDPS();
        this.description = tower.getDescription();
        this.purchaseCost = tower.getPurchaseCost();
        this.sellCost = tower.getSellCost();

    } // Constructor

    @Override
    public int getLevel() {
        return 1 + tower.getLevel();

    } // getLevel

    @Override
    public int getSellCost() {
        return 20 + tower.getSellCost();

    } // getSellCost

    public Tower getTower() {
        return tower;
    }

} // Upgrade
