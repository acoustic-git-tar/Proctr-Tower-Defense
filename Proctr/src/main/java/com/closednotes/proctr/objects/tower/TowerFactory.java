package com.closednotes.proctr.objects.tower;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;

public abstract class TowerFactory {
    private static Difficulty diff = TDApplication.getPlayer().getDifficulty();

    public static Tower createTower(String towerType) {
        Tower tower;
        switch (towerType) {
        case "TA":
            tower = new TA(diff);
            break;
        case "BC":
            tower = new Buzzcard(diff);
            break;
        case "LD":
            tower = new LockdownBrowser(diff);
            break;
        default:
            tower = null;
            break;
        }
        return tower;
    }
}
