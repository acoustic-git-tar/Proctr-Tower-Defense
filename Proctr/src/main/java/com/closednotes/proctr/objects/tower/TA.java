package com.closednotes.proctr.objects.tower;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.TDApplication;
import com.closednotes.proctr.objects.tower.Tower;

public class TA extends Tower {
    public TA(Difficulty difficulty) {
        animation = TDApplication.class.getClassLoader()
                .getResourceAsStream("TA_Projectile.png");
        damage = 10;
        range = 300;
        dps = 60;
        description = "TAs are an invaluable tool for helping the student's success"
                + "in the course. However, they are Russian spies who want to sabotage the "
                + "successes of the students! With both online and in person office hours "
                + "available, TAs are a jack-of-all-trades in misinformation "
                + "and adaptability. Has medium damage and medium range.";
        // Easy difficulty: 500 money
        // Medium difficulty: 400 money
        // Hard difficulty: 300 money
        switch (difficulty) {
        case CLOSED_NOTES:
            purchaseCost = 100;
            sellCost = 90;
            break;
        case CHEAT_SHEET:
            purchaseCost = 120;
            sellCost = 100;
            break;
        case OPEN_NOTES:
            purchaseCost = 150;
            sellCost = 75;
            break;
        default:
            purchaseCost = 125;
            sellCost = 95;
            break;
        }

    }

}
