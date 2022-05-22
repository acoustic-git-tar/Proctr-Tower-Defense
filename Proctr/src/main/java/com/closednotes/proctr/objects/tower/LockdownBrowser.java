package com.closednotes.proctr.objects.tower;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;
import com.closednotes.proctr.objects.tower.Tower;

public class LockdownBrowser extends Tower {

    public LockdownBrowser(Difficulty difficulty) {
        animation = TDApplication.class.getClassLoader()
                .getResourceAsStream("Lockdown_Projectile.png");
        damage = 5;
        range = 300;
        dps = 10;
        description = "Lockdown Browser is a browser-wide virus hijacking tool that "
                + "broadly limits the content students can use, but the students "
                + "don't mind the application as much. Has high range and low damage.";
        // Easy difficulty: 500 money
        // Medium difficulty: 400 money
        // Hard difficulty: 300 money
        switch (difficulty) {
        case CLOSED_NOTES:
            purchaseCost = 50;
            sellCost = 40;
            break;
        case CHEAT_SHEET:
            purchaseCost = 75;
            sellCost = 60;
            break;
        case OPEN_NOTES:
            purchaseCost = 100;
            sellCost = 50;
            break;
        default:
            purchaseCost = 70;
            sellCost = 65;
            break;
        }
    }
}
