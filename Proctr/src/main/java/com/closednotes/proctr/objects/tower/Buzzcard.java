package com.closednotes.proctr.objects.tower;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;
import com.closednotes.proctr.objects.tower.Tower;

public class Buzzcard extends Tower {
    public Buzzcard(Difficulty difficulty) {
        animation = TDApplication.class.getClassLoader()
                .getResourceAsStream("Buzzcard_Swipe.png");
        damage = 40;
        range = 160;
        dps = 120;
        description = "The Buzzcard is an identification tool as well as "
                + "a lethal melee weapon. It cuts through paper and other classroom tools "
                + "with ease, but can only be used at arm's reach. Has low range and high damage.";
        // Easy difficulty: 500 money
        // Medium difficulty: 400 money
        // Hard difficulty: 300 money
        switch (difficulty) {
        case CLOSED_NOTES:
            purchaseCost = 60;
            sellCost = 50;
            break;
        case CHEAT_SHEET:
            purchaseCost = 80;
            sellCost = 60;
            break;
        case OPEN_NOTES:
            purchaseCost = 120;
            sellCost = 80;
            break;
        default:
            purchaseCost = 100;
            sellCost = 70;
            break;
        }
    }
}
