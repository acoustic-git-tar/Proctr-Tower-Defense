package com.closednotes.proctr.objects.tower;

public class DamageUpgrade extends Upgrade {

    private int damageBoost;

    public DamageUpgrade(Tower tower) {
        super(tower);
        this.damageBoost = 10;

    } // Constructor

    @Override
    public int getDamage() {
        return damageBoost + tower.getDamage();
    } // getDamage

    @Override
    public int getDPS() {
        return tower.getDPS();
    } // getDPS

} // DamageUpgrade
