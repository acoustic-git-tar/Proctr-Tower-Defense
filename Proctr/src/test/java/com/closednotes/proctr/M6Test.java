package com.closednotes.proctr;

import com.closednotes.proctr.objects.Player;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.Enemy;
import com.closednotes.proctr.objects.enemy.EnemyFactory;
import com.closednotes.proctr.objects.enemy.EnemyWrapper;
import com.closednotes.proctr.objects.tower.*;
import org.junit.Test;
import org.w3c.dom.ranges.Range;

import java.util.concurrent.locks.Lock;

import static org.junit.Assert.*;

public class M6Test {

    /**
     * @author Kewal Kalsi
     * 
     * Tests if towers do not have a change in DPS, regardless of upgrade.
     */
    @Test
    public void testNoChangeInDPS() {
        Tower buzzcard = new Buzzcard(Difficulty.CLOSED_NOTES);
        Tower lockdownBrowser = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        Tower ta = new TA(Difficulty.CLOSED_NOTES);

        int oldBuzzcardDPS = buzzcard.getDPS();
        int oldLockdownDPS = lockdownBrowser.getDPS();
        int oldTADPS = ta.getDPS();

        buzzcard = new RangeUpgrade(buzzcard);
        lockdownBrowser = new RangeUpgrade(lockdownBrowser);
        ta = new RangeUpgrade(ta);

        assertEquals(oldBuzzcardDPS, buzzcard.getDPS());
        assertEquals(oldLockdownDPS, lockdownBrowser.getDPS());
        assertEquals(oldTADPS, ta.getDPS());

        buzzcard = new DamageUpgrade(buzzcard);
        lockdownBrowser = new DamageUpgrade(lockdownBrowser);
        ta = new DamageUpgrade(ta);

        assertEquals(oldBuzzcardDPS, buzzcard.getDPS());
        assertEquals(oldLockdownDPS, lockdownBrowser.getDPS());
        assertEquals(oldTADPS, ta.getDPS());
    }


    /**
     * @author Kewal Kalsi
     * 
     * Tests if towers increase in level by 1 with any upgrade.
     */
    @Test
    public void testProperLevelIncrease() {
        Tower buzzcard = new Buzzcard(Difficulty.CLOSED_NOTES);
        Tower lockdownBrowser = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        Tower ta = new TA(Difficulty.CLOSED_NOTES);

        int oldBuzzcardLevel = buzzcard.getLevel();
        int oldLockdownLevel = lockdownBrowser.getLevel();
        int oldTALevel = ta.getLevel();

        buzzcard = new RangeUpgrade(buzzcard);
        lockdownBrowser = new RangeUpgrade(lockdownBrowser);
        ta = new RangeUpgrade(ta);

        assertEquals(oldBuzzcardLevel + 1, buzzcard.getLevel());
        assertEquals(oldLockdownLevel + 1, lockdownBrowser.getLevel());
        assertEquals(oldTALevel + 1, ta.getLevel());

        buzzcard = new DamageUpgrade(buzzcard);
        lockdownBrowser = new DamageUpgrade(lockdownBrowser);
        ta = new DamageUpgrade(ta);

        assertEquals(oldBuzzcardLevel + 2, buzzcard.getLevel());
        assertEquals(oldLockdownLevel + 2, lockdownBrowser.getLevel());
        assertEquals(oldTALevel + 2, ta.getLevel());
    }

    /**
     * @author Luke Walter
     * 
     * Tests if towers gain a range increase when they are given a range
     * upgrade. 
     */
    @Test
    public void testRangeUpgrade() {
        Tower buzzcard = new Buzzcard(Difficulty.CLOSED_NOTES);
        Tower lockdownBrowser = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        Tower ta = new TA(Difficulty.CLOSED_NOTES);

        int oldBuzzcardRange = buzzcard.getRange();
        int oldLockdownRange = lockdownBrowser.getRange();
        int oldTARange = ta.getRange();

        buzzcard = new RangeUpgrade(buzzcard);
        lockdownBrowser = new RangeUpgrade(lockdownBrowser);
        ta = new RangeUpgrade(ta);

        assertTrue(oldBuzzcardRange < buzzcard.getRange());
        assertTrue(oldLockdownRange< lockdownBrowser.getRange());
        assertTrue(oldTARange < ta.getRange());
    }


    /**
     * @author Luke Walter
     * 
     * Tests if towers gain a damage increase when they are given a damage
     * upgrade.
     */
    @Test
    public void testDamageUpgrade() {
        Tower buzzcard = new Buzzcard(Difficulty.CLOSED_NOTES);
        Tower lockdownBrowser = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        Tower ta = new TA(Difficulty.CLOSED_NOTES);

        int oldBuzzcardDamage = buzzcard.getDamage();
        int oldLockdownDamage = lockdownBrowser.getDamage();
        int oldTADamage = ta.getDamage();

        buzzcard = new DamageUpgrade(buzzcard);
        lockdownBrowser = new DamageUpgrade(lockdownBrowser);
        ta = new DamageUpgrade(ta);

        assertTrue(oldBuzzcardDamage < buzzcard.getDamage());
        assertTrue(oldLockdownDamage < lockdownBrowser.getDamage());
        assertTrue(oldTADamage < ta.getDamage());
    }

    /**
     * @author Ethan Tong
     * 
     * Tests if all towers have increased sell costs when their range is 
     * upgraded. Each tower's sell cost before and after getting a range 
     * upgrade is compared such that sell cost before should be less than 
     * the sell cost after.
     */
    @Test
    public void testSellCostUpgradeWithRange() {

        Tower buzzcard = new Buzzcard(Difficulty.CLOSED_NOTES);
        Tower lockdownBrowser = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        Tower ta = new TA(Difficulty.CLOSED_NOTES);

        int oldBuzzcardSellCost = buzzcard.getSellCost();
        int oldLockdownSellCost = buzzcard.getSellCost();
        int oldTASellCost = ta.getSellCost();

        buzzcard = new RangeUpgrade(buzzcard);
        lockdownBrowser = new RangeUpgrade(lockdownBrowser);
        ta = new RangeUpgrade(ta);

        assertTrue(oldBuzzcardSellCost < buzzcard.getSellCost());
        assertTrue(oldLockdownSellCost < lockdownBrowser.getSellCost());
        assertTrue(oldTASellCost < ta.getSellCost());

    } // testSellCostUpgradewithRange

    /**
     * @author Ethan Tong
     * 
     * Tests if all towers have increased sell costs when their damage is 
     * upgraded. Each tower's sell cost before and after getting a damage 
     * upgrade is compared such that sell cost before should be less than 
     * the sell cost after.
     */
    @Test
    public void testSellCostUpgradeWithDamage() {

        Tower buzzcard = new Buzzcard(Difficulty.CLOSED_NOTES);
        Tower lockdownBrowser = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        Tower ta = new TA(Difficulty.CLOSED_NOTES);

        int oldBuzzcardSellCost = buzzcard.getSellCost();
        int oldLockdownSellCost = buzzcard.getSellCost();
        int oldTASellCost = ta.getSellCost();

        buzzcard = new DamageUpgrade(buzzcard);
        lockdownBrowser = new DamageUpgrade(lockdownBrowser);
        ta = new DamageUpgrade(ta);

        assertTrue(oldBuzzcardSellCost < buzzcard.getSellCost());
        assertTrue(oldLockdownSellCost < lockdownBrowser.getSellCost());
        assertTrue(oldTASellCost < ta.getSellCost());

    } // testSellCostUpgradeWithDamage

    /**
     * @author Max Ho
     * 
     * Tests if money is deducted from the player's bank when towers are 
     * upgraded.
     */
    @Test
    public void testUpgradeMoneyCost() {
        Player player = new Player("Aibek Musaev", Difficulty.CLOSED_NOTES);
        TDApplication.setPlayer(player);
        Tower taTower = TowerFactory.createTower("TA");

        int initMoney = player.getMoney();
        try {
            for (int i = 0; i < 5; i++) {
                taTower = new DamageUpgrade(taTower);
                player.earnMoney(-10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(player.getMoney() < initMoney);
    } // testUpgradeMoneyCost


    /**
     * @author Max Ho
     * 
     * Tests if the the final boss is superior to all other enemies by
     * comparing the boss's health with the individual healths of all other 
     * enemies.
     */
    @Test
    public void testBossHealthSuperiority() {
        //GTNSYK
        Vector2[] path = {new Vector2(0, 0)};
        EnemyWrapper groupMe = EnemyFactory.createEnemy('G', path);
        EnemyWrapper textbook = EnemyFactory.createEnemy('G', path);
        EnemyWrapper notebook = EnemyFactory.createEnemy('G', path);
        EnemyWrapper stack = EnemyFactory.createEnemy('G', path);
        EnemyWrapper youtube = EnemyFactory.createEnemy('G', path);
        EnemyWrapper khanacademy = EnemyFactory.createEnemy('G', path);
        EnemyWrapper chegg = EnemyFactory.createEnemy('C', path);

        assertTrue(chegg.getGameObject().getHealth() > groupMe.getGameObject().getHealth());
        assertTrue(chegg.getGameObject().getHealth() > textbook.getGameObject().getHealth());
        assertTrue(chegg.getGameObject().getHealth() > notebook.getGameObject().getHealth());
        assertTrue(chegg.getGameObject().getHealth() > stack.getGameObject().getHealth());
        assertTrue(chegg.getGameObject().getHealth() > youtube.getGameObject().getHealth());
        assertTrue(chegg.getGameObject().getHealth() > khanacademy.getGameObject().getHealth());

    } // testBossHealthSuperiority

} // M6Test
