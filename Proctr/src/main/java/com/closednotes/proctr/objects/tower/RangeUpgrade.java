package com.closednotes.proctr.objects.tower;

public class RangeUpgrade extends Upgrade {

    private int rangeBoost;

    public RangeUpgrade(Tower tower) {
        super(tower);
        this.rangeBoost = 20;

    } // Constructor

    @Override
    public int getRange() {
        return rangeBoost + tower.getRange();

    } // getRange

    @Override
    public int getAttackRange() {
        return rangeBoost + tower.getAttackRange();

    } // getRange

} // RangeUpgrade
