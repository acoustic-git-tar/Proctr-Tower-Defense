package com.closednotes.proctr;

import org.junit.Test;

public class M4Test {
    
    /**
     * @author Ethan Tong
     * 
     * Tests the damage amounts of the Spiral Notebook enemy across all
     * difficulties. Damage is lowest on Closed Notes and highest on Open
     * Notes.
     */
    @Test
    public void testSpiralNotebookDamage() {

        /*
        SpiralNotebook easySN = new SpiralNotebook(50, 50,
            Difficulty.CLOSED_NOTES, null);
        SpiralNotebook mediumSN = new SpiralNotebook(50, 50,
            Difficulty.CHEAT_SHEET, null);
        SpiralNotebook hardSN = new SpiralNotebook(50, 50,
            Difficulty.OPEN_NOTES, null);

        assertTrue(easySN.getMonumentDamage() < mediumSN.getMonumentDamage());
        assertTrue(mediumSN.getMonumentDamage() < hardSN.getMonumentDamage());
        assertTrue(easySN.getMonumentDamage() < hardSN.getMonumentDamage());

        assertEquals(0.1, easySN.getMonumentDamage(), 1.0);
        assertEquals(0.12, mediumSN.getMonumentDamage(), 1.0);
        assertEquals(0.14, hardSN.getMonumentDamage(), 1.0);
        */

    } // testSpiralNotebookDamage

    /**
     * @author Ethan Tong
     * 
     * Tests the damage amounts of the Textbook enemy across all difficulties.
     * Damage is lowest on Closed Notes and highest on Open Notes.
     */
    @Test
    public void testTextbookDamage() {

        /*
        Textbook easyT = new Textbook(50, 50, Difficulty.CLOSED_NOTES, null);
        Textbook mediumT = new Textbook(50, 50, Difficulty.CHEAT_SHEET, null);
        Textbook hardT = new Textbook(50, 50, Difficulty.OPEN_NOTES, null);

        assertTrue(easyT.getMonumentDamage() < mediumT.getMonumentDamage());
        assertTrue(mediumT.getMonumentDamage() < hardT.getMonumentDamage());
        assertTrue(easyT.getMonumentDamage() < hardT.getMonumentDamage());

        assertEquals(0.15, easyT.getMonumentDamage(), 1.0);
        assertEquals(0.18, mediumT.getMonumentDamage(), 1.0);
        assertEquals(0.21, hardT.getMonumentDamage(), 1.0);
        */

    } // testTextbookDamage

    /**
     * @author Luke Walter
     *
     * Tests the damage amounts of GroupMe enemies on each difficulty level.
     * Damage is lowest on Closed Notes and highest on Open Notes.
     */
    @Test
    public void testGroupMeDamage() {

        /*
        Enemy easyGM = new GroupMe(50, 50, Difficulty.CLOSED_NOTES, null);
        Enemy mediumGM = new GroupMe(50, 50, Difficulty.CHEAT_SHEET, null);
        Enemy hardGM = new GroupMe(50, 50, Difficulty.OPEN_NOTES, null);

        assertTrue(easyGM.getMonumentDamage() < mediumGM.getMonumentDamage());
        assertTrue(mediumGM.getMonumentDamage() < hardGM.getMonumentDamage());
        assertTrue(easyGM.getMonumentDamage() < hardGM.getMonumentDamage());

        assertEquals(0.2, easyGM.getMonumentDamage(), 0.0000001);
        assertEquals(0.24, mediumGM.getMonumentDamage(), 0.0000001);
        assertEquals(0.28, hardGM.getMonumentDamage(), 0.0000001);
        */

    } // testGroupMeDamage


    /**
     * @author Max Ho
     *
     * Tests health values of the spiral notebook enemies in different difficulties.
     * Checks if easy < medium < hard for health,
     * and if health values are not equal.
     */
    @Test
    public void testSpiralNotebookHealth() {

        /*
        SpiralNotebook easyNotebook = new SpiralNotebook(50, 50, Difficulty.CLOSED_NOTES, null);
        SpiralNotebook mediumNotebook = new SpiralNotebook(50, 50, Difficulty.CHEAT_SHEET, null);
        SpiralNotebook hardNotebook = new SpiralNotebook(50, 50, Difficulty.OPEN_NOTES, null);

        assertTrue(easyNotebook.getHealth() < mediumNotebook.getHealth());
        assertTrue(mediumNotebook.getHealth() < hardNotebook.getHealth());
        assertTrue(easyNotebook.getHealth() < hardNotebook.getHealth());

        assertNotEquals(easyNotebook.getHealth(), mediumNotebook.getHealth());
        assertNotEquals(easyNotebook.getHealth(), hardNotebook.getHealth());
        assertNotEquals(mediumNotebook.getHealth(), hardNotebook.getHealth());
        */

    } // testSpiralNotebookHealth


    /**
     * @author Max Ho
     *
     * Tests health values of the textbook enemies in different difficulties.
     * Checks if easy < medium < hard for health,
     * and if health values are not equal.
     */
    @Test
    public void testTextbookHealth() {

        /*
        Textbook easyTB = new Textbook(50, 50, Difficulty.CLOSED_NOTES, null);
        Textbook mediumTB = new Textbook(50, 50, Difficulty.CHEAT_SHEET, null);
        Textbook hardTB = new Textbook(50, 50, Difficulty.OPEN_NOTES, null);

        assertTrue(easyTB.getHealth() < mediumTB.getHealth());
        assertTrue(mediumTB.getHealth() < hardTB.getHealth());
        assertTrue(easyTB.getHealth() < hardTB.getHealth());

        assertNotEquals(easyTB.getHealth(), mediumTB.getHealth());
        assertNotEquals(easyTB.getHealth(), hardTB.getHealth());
        assertNotEquals(mediumTB.getHealth(), hardTB.getHealth());
        */

    } // testTextbookHealth

    /**
     * @author Luke Walter
     *
     * Tests the health of GroupMe enemies on each difficulty level.
     * Health is lowest on Closed Notes and highest on Open Notes.
     */
    @Test
    public void testGroupMeHealth() {

        /*
        Enemy easyGM = new GroupMe(50, 50, Difficulty.CLOSED_NOTES, null);
        Enemy mediumGM = new GroupMe(50, 50, Difficulty.CHEAT_SHEET, null);
        Enemy hardGM = new GroupMe(50, 50, Difficulty.OPEN_NOTES, null);

        assertTrue(easyGM.getHealth() < mediumGM.getHealth());
        assertTrue(mediumGM.getHealth() < hardGM.getHealth());
        assertTrue(easyGM.getHealth() < hardGM.getHealth());

        assertEquals(30, easyGM.getHealth());
        assertEquals(45, mediumGM.getHealth());
        assertEquals(60, hardGM.getHealth());
        */

    } // testGroupMeHealth

    /**
     * @author Kewal Kalsi
     *
     * Tests if all move durations for all three enemies are different.
     */
    @Deprecated
    public void testEnemyMoveDuration() {
    //        Enemy groupMe = new GroupMe(50, 50, Difficulty.CLOSED_NOTES, null);
    //        Enemy spiral = new SpiralNotebook(50, 50, Difficulty.CLOSED_NOTES, null);
    //        Enemy textbook = new Textbook(50, 50, Difficulty.CLOSED_NOTES, null);

    //        int gmDuration = groupMe.getMoveDuration();
    //        int spiralDuration = spiral.getMoveDuration();
    //        int textbookDuration = textbook.getMoveDuration();

    //        assertThat(gmDuration,  not(
        //        anyOf(equalTo(spiralDuration), equalTo(textbookDuration))));
    //        assertThat(spiralDuration,  not(
        //        anyOf(equalTo(gmDuration), equalTo(textbookDuration))));
    //    assertThat(textbookDuration,  not(anyOf(equalTo(gmDuration), equalTo(spiralDuration))));
    } // testEnemyMoveDuration

    /**
     * @author Kewal Kalsi
     *
     * Tests if the game properly continues while the game is active
     * and throws the proper error once the game is finished.
     */
    @Test (expected = ExceptionInInitializerError.class)
    public void testGameOver() {

        /*
        TDApplication app = new TDApplication();
        Player gamePlayer = new Player("Test_Player", Difficulty.CLOSED_NOTES);
        app.setPlayer(gamePlayer);
        Enemy sampleEnemy = new GroupMe(50, 50, gamePlayer.getDifficulty(), null);

        while (gamePlayer.getGpa() < 4.0) {
            assertTrue(GameController.continueGame());
            sampleEnemy.attackMonument(gamePlayer);
        }
        GameController.continueGame();
        */
        
    } // testGameOver

} // M4Test
