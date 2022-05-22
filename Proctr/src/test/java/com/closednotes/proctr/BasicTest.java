package com.closednotes.proctr;

import com.closednotes.proctr.objects.*;
import com.closednotes.proctr.objects.tower.Buzzcard;
import com.closednotes.proctr.objects.tower.LockdownBrowser;
import com.closednotes.proctr.objects.tower.TA;
import com.closednotes.proctr.objects.tower.Tower;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class BasicTest {

    /**
     * @author Ethan Tong
     * 
     * Tests the purchase costs of the Lockdown Brower tower across all difficulties.
     * Purchase cost is lowest on Closed Notes and highest on Open Notes.
     */
    @Test
    public void testLockdownBrowserPurchaseCost() {

        LockdownBrowser easyLDB = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        LockdownBrowser mediumLDB = new LockdownBrowser(Difficulty.CHEAT_SHEET);
        LockdownBrowser hardLDB = new LockdownBrowser(Difficulty.OPEN_NOTES);

        assertTrue(easyLDB.getPurchaseCost() < mediumLDB.getPurchaseCost());
        assertTrue(mediumLDB.getPurchaseCost() < hardLDB.getPurchaseCost());
        assertTrue(easyLDB.getPurchaseCost() < hardLDB.getPurchaseCost());

        assertEquals(50, easyLDB.getPurchaseCost());
        assertEquals(75, mediumLDB.getPurchaseCost());
        assertEquals(100, hardLDB.getPurchaseCost());

    } // testLockdownBrowserPurchaseCost

    /**
     * @author Ethan Tong
     * 
     * Tests the purchase costs of the Buzzcard tower across all difficulties.
     * Purchase cost is lowest on Closed Notes and highest on Open Notes.
     */
    @Test
    public void testBuzzcardPurchaseCost() {

        Buzzcard easyB = new Buzzcard(Difficulty.CLOSED_NOTES);
        Buzzcard mediumB = new Buzzcard(Difficulty.CHEAT_SHEET);
        Buzzcard hardB = new Buzzcard(Difficulty.OPEN_NOTES);

        assertTrue(easyB.getPurchaseCost() < mediumB.getPurchaseCost());
        assertTrue(mediumB.getPurchaseCost() < hardB.getPurchaseCost());
        assertTrue(easyB.getPurchaseCost() < hardB.getPurchaseCost());

        assertEquals(60, easyB.getPurchaseCost());
        assertEquals(80, mediumB.getPurchaseCost());
        assertEquals(120, hardB.getPurchaseCost());

    } // testBuzzcardPurchaseCost

    /**
     * @author Ethan Tong
     * 
     * Tests the purchase costs of the TA tower across all difficulties.
     * Purchase cost is lowest on Closed Notes and highest on Open Notes.
     */
    @Test
    public void testTAPurchaseCost() {

        TA easyTA = new TA(Difficulty.CLOSED_NOTES);
        TA mediumTA = new TA(Difficulty.CHEAT_SHEET);
        TA hardTA = new TA(Difficulty.OPEN_NOTES);

        assertTrue(easyTA.getPurchaseCost() < mediumTA.getPurchaseCost());
        assertTrue(mediumTA.getPurchaseCost() < hardTA.getPurchaseCost());
        assertTrue(easyTA.getPurchaseCost() < hardTA.getPurchaseCost());

        assertEquals(100, easyTA.getPurchaseCost());
        assertEquals(120, mediumTA.getPurchaseCost());
        assertEquals(150, hardTA.getPurchaseCost());

    } // testTAPurchaseCost

    /**
     * @author Luke Walter
     * 
     * Tests the sell costs of the Lockdown Browser tower across all difficulties.
     */
    @Test
    public void testLockdownBrowserSellCost() {

        LockdownBrowser easyLB = new LockdownBrowser(Difficulty.CLOSED_NOTES);
        LockdownBrowser mediumLB = new LockdownBrowser(Difficulty.CHEAT_SHEET);
        LockdownBrowser hardLB = new LockdownBrowser(Difficulty.OPEN_NOTES);

        assertTrue(easyLB.getSellCost() < easyLB.getPurchaseCost());
        assertTrue(mediumLB.getSellCost() < mediumLB.getPurchaseCost());
        assertTrue(hardLB.getSellCost() < hardLB.getPurchaseCost());

        assertTrue(easyLB.getSellCost() < mediumLB.getSellCost());
        assertTrue(mediumLB.getSellCost() > hardLB.getSellCost());
        assertTrue(easyLB.getSellCost() < hardLB.getSellCost());

        assertEquals(40, easyLB.getSellCost());
        assertEquals(60, mediumLB.getSellCost());
        assertEquals(50, hardLB.getSellCost());

    } // testLockdownBrowserSellCost

    /**
     * @author Luke Walter
     * 
     * Tests the sell costs of the Buzzcard tower across all difficulties.
     */
    @Test
    public void testBuzzcardSellCost() {

        Buzzcard easyB = new Buzzcard(Difficulty.CLOSED_NOTES);
        Buzzcard mediumB = new Buzzcard(Difficulty.CHEAT_SHEET);
        Buzzcard hardB = new Buzzcard(Difficulty.OPEN_NOTES);

        assertTrue(easyB.getSellCost() < easyB.getPurchaseCost());
        assertTrue(mediumB.getSellCost() < mediumB.getPurchaseCost());
        assertTrue(hardB.getSellCost() < hardB.getPurchaseCost());

        assertTrue(easyB.getSellCost() < mediumB.getSellCost());
        assertTrue(mediumB.getSellCost() < hardB.getSellCost());
        assertTrue(easyB.getSellCost() < hardB.getSellCost());

        assertEquals(50, easyB.getSellCost());
        assertEquals(60, mediumB.getSellCost());
        assertEquals(80, hardB.getSellCost());

    } // testLockdownBrowserSellCost

    /**
     * @author Luke Walter
     * 
     * Tests the sell costs of the TA tower across all difficulties.
     */
    @Test
    public void testTASellCost() {

        TA easyTA = new TA(Difficulty.CLOSED_NOTES);
        TA mediumTA = new TA(Difficulty.CHEAT_SHEET);
        TA hardTA = new TA(Difficulty.OPEN_NOTES);

        assertTrue(easyTA.getSellCost() < easyTA.getPurchaseCost());
        assertTrue(mediumTA.getSellCost() < mediumTA.getPurchaseCost());
        assertTrue(hardTA.getSellCost() < hardTA.getPurchaseCost());

        assertTrue(easyTA.getSellCost() < mediumTA.getSellCost());
        assertTrue(mediumTA.getSellCost() > hardTA.getSellCost());
        assertTrue(easyTA.getSellCost() > hardTA.getSellCost());

        assertEquals(90, easyTA.getSellCost());
        assertEquals(100, mediumTA.getSellCost());
        assertEquals(75, hardTA.getSellCost());

    } // testLockdownBrowserSellCost

    /**
     * @author Kewal Kalsi
     */
    @Test
    public void testPlayerStartingMoney() {
        Player easyDifficultyPlayer = new Player("Easy", Difficulty.CLOSED_NOTES);
        Player normalDifficultyPlayer = new Player("Normal", Difficulty.CHEAT_SHEET);
        Player hardDifficultyPlayer = new Player("Hard", Difficulty.OPEN_NOTES);

        int easyMoney = easyDifficultyPlayer.getMoney();
        int normalMoney = normalDifficultyPlayer.getMoney();
        int hardMoney = hardDifficultyPlayer.getMoney();

        assertThat(easyMoney,  not(anyOf(equalTo(normalMoney), equalTo(hardMoney))));
        assertThat(normalMoney,  not(anyOf(equalTo(easyMoney), equalTo(hardMoney))));
        assertThat(hardMoney,  not(anyOf(equalTo(easyMoney), equalTo(normalMoney))));
    } // testPlayerStartingMoney

    /**
     * @author Max Ho
     *
     * Tests what happens if you buy towers with low/no money.
     * Should return a null tower in the purchase method
     * when you are buying with low money.
     */
    @Test
    public void testOutOfMoney() {
        Player player = new Player("Joe Biden", Difficulty.OPEN_NOTES);
        assertEquals("Joe Biden", player.getName());
        assertEquals(300, player.getMoney());
        assertEquals(Difficulty.OPEN_NOTES, player.getDifficulty());
        Tower tower1 = player.purchaseTower(new Buzzcard(player.getDifficulty()));
        assertEquals(180, player.getMoney());
        Tower tower2 = player.purchaseTower(new TA(player.getDifficulty()));
        assertEquals(30, player.getMoney());
        try {
            Tower tower3 = player.purchaseTower(new LockdownBrowser(player.getDifficulty()));
        } catch (IllegalArgumentException e) {
            assertEquals("Insufficient funds!", e.getMessage());
        }

    }

    /**
     * @author Max Ho
     *
     * Testing if earning money at the end of a round
     * after buying towers displays the correct amount of money.
     */
    @Test
    public void testEarnMoney() {
        Player player = new Player("Joe Biden", Difficulty.OPEN_NOTES);
        for (int i = 0; i < 3; i++) {
            player.purchaseTower(new LockdownBrowser(Difficulty.OPEN_NOTES));
        }
        int money = player.getMoney();
        player.earnMoney(69);
        assertEquals(money + 69, player.getMoney());
    }
    /**
     * @author Kewal Kalsi
     */
    @Test
    public void testPlayerStartingHealth() {
        Player easyDifficultyPlayer = new Player("Easy", Difficulty.CLOSED_NOTES);
        Player normalDifficultyPlayer = new Player("Normal", Difficulty.CHEAT_SHEET);
        Player hardDifficultyPlayer = new Player("Hard", Difficulty.OPEN_NOTES);

        double easyHealth = easyDifficultyPlayer.getGpa();
        double normalHealth = normalDifficultyPlayer.getGpa();
        double hardHealth = hardDifficultyPlayer.getGpa();

        assertThat(easyHealth,  not(anyOf(equalTo(normalHealth), equalTo(hardHealth))));
        assertThat(normalHealth,  not(anyOf(equalTo(easyHealth), equalTo(hardHealth))));
        assertThat(hardHealth,  not(anyOf(equalTo(easyHealth), equalTo(normalHealth))));
    } // Kewal Kalsi

} // HelloWorldTest