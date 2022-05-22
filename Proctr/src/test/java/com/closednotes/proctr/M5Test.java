package com.closednotes.proctr;

import com.closednotes.proctr.objects.*;
import com.closednotes.proctr.objects.enemy.*;
import com.closednotes.proctr.objects.enemy.variants.*;
import com.closednotes.proctr.objects.map.PathFactory;
import com.closednotes.proctr.objects.tower.TA;
import com.closednotes.proctr.objects.tower.Tower;
import com.closednotes.proctr.objects.tower.TowerFactory;
import javafx.application.Platform;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class M5Test {
    
    /**
     * @author Ethan Tong
     * 
     * Tests the movement speeds of all enemy types. The weakest enemy, the
     * spiral notebook, has the fastest movement speed while the stronget enemy, 
     * the Chegg boss, has the slowest movement speed. Movement speed should 
     * decrease with enemy strength in this order: SpiralNotebook, Textbook, 
     * GroupMe, KhanAcademy, StackOverflow, YouTube, Chegg.
     */
    @Test
    public void testMoveSpeed() {

        TDApplication app = new TDApplication();
        Player player = new Player("Player", Difficulty.CLOSED_NOTES);
        app.setPlayer(player);

        SpiralNotebook sn = new SpiralNotebook(PathFactory.createPath(1));
        Textbook tb = new Textbook(PathFactory.createPath(1));
        GroupMe gm = new GroupMe(PathFactory.createPath(1));
        KhanAcademy ka = new KhanAcademy(PathFactory.createPath(1));
        StackOverflow so = new StackOverflow(PathFactory.createPath(1));
        YouTube yt = new YouTube(PathFactory.createPath(1));
        Chegg c = new Chegg(PathFactory.createPath(1));

        assertTrue(sn.getMoveSpeed() > tb.getMoveSpeed());
        assertTrue(tb.getMoveSpeed() > gm.getMoveSpeed());
        assertTrue(gm.getMoveSpeed() > ka.getMoveSpeed());
        assertTrue(ka.getMoveSpeed() > so.getMoveSpeed());
        assertTrue(so.getMoveSpeed() > yt.getMoveSpeed());
        assertTrue(yt.getMoveSpeed() > c.getMoveSpeed());

    } // testMoveSpeed

    /**
     * @author Ethan Tong
     * 
     * Tests if all enemies lose health when they take damage. Uses a TA tower
     * as the tower to attack enemies. Each enemy's health before and after
     * getting attack is compared such that health before should be greater 
     * than health after.
     */
    @Test
    public void testLoseHealth() {

        TDApplication app = new TDApplication();
        Player player = new Player("PLayer", Difficulty.CLOSED_NOTES);
        app.setPlayer(player);

        SpiralNotebook sn = new SpiralNotebook(PathFactory.createPath(1));
        Textbook tb = new Textbook(PathFactory.createPath(1));
        GroupMe gm = new GroupMe(PathFactory.createPath(1));
        KhanAcademy ka = new KhanAcademy(PathFactory.createPath(1));
        StackOverflow so = new StackOverflow(PathFactory.createPath(1));
        YouTube yt = new YouTube(PathFactory.createPath(1));
        Chegg c = new Chegg(PathFactory.createPath(1));
        Enemy[] enemies = {sn, tb, gm, ka, so, yt, c};

        TA ta = new TA(TDApplication.getPlayer().getDifficulty());

        int snHealth = sn.getHealth();
        int tbHealth = tb.getHealth();
        int gmHealth = gm.getHealth();
        int kaHealth = ka.getHealth();
        int soHealth = so.getHealth();
        int ytHealth = yt.getHealth();
        int cHealth = c.getHealth();

        for (int i = 0; i < enemies.length; i++) {
            enemies[i].loseHealth(ta.getDamage());
        } // for

        int snNewHealth = sn.getHealth();
        int tbNewHealth = tb.getHealth();
        int gmNewHealth = gm.getHealth();
        int kaNewHealth = ka.getHealth();
        int soNewHealth = so.getHealth();
        int ytNewHealth = yt.getHealth();
        int cNewHealth = c.getHealth();

        assertTrue(snHealth > snNewHealth);
        assertTrue(tbHealth > tbNewHealth);
        assertTrue(gmHealth > gmNewHealth);
        assertTrue(kaHealth > kaNewHealth);
        assertTrue(soHealth > soNewHealth);
        assertTrue(ytHealth > ytNewHealth);
        assertTrue(cHealth > cNewHealth);

    } // testLoseHealth

    /**
     * @author Kewal Kalsi
     *
     * Simulates an enemy dying and tests to see if the player money health properly increases
     */
    @Test
    public void testPlayerMoneyIncrease() {
        Player player = new Player("Player", Difficulty.CLOSED_NOTES);
        TDApplication app = new TDApplication();
        app.setPlayer(player);
        SpiralNotebook enemy = new SpiralNotebook(PathFactory.createPath(1));
        enemy.loseHealth(enemy.getHealth() + 1);
        int originalMoney = player.getMoney();
        player.earnMoney(5);
        assertEquals(originalMoney + 5, player.getMoney());
    } // testEnemyMoveDuration

    /**
     * @author Kewal Kalsi
     *
     * Deactivates an enemy to determine if it has properly been deactivated
     */
    @Test
    public void testEnemyDeactivate() {
        Platform.startup(() -> {
            Player player = new Player("Player", Difficulty.CLOSED_NOTES);
            TDApplication app = new TDApplication();
            app.setPlayer(player);

            SpiralNotebook enemy = new SpiralNotebook(PathFactory.createPath(1));
            EnemyWrapper ew = new EnemyWrapper(enemy);
            ew.activate();
            assertTrue(ew.isActive());
            ew.deactivate();
            assertFalse(ew.isActive());
            // This block will be executed on JavaFX Thread
        });

    } // testEnemyMoveDuration


    /**
     * Tests the new factory pattern for creating towers. New factory created towers
     * should have their own object class, instead of being the same.
     *
     * @author Max Ho
     */
    @Test
    public void testTowerFactory() {
        TDApplication temp = new TDApplication();
        Player player = new Player("Joe Biden", Difficulty.CLOSED_NOTES);
        temp.setPlayer(player);
        Tower ta = TowerFactory.createTower("TA");
        Tower bc = TowerFactory.createTower("BC");
        Tower ld = TowerFactory.createTower("LD");
        assertEquals("class com.closednotes.proctr.objects.tower.TA", ta.getClass().toString());
        assertEquals("class com.closednotes.proctr.objects.tower.Buzzcard", bc.getClass().toString());
        assertEquals("class com.closednotes.proctr.objects.tower.LockdownBrowser",
                ld.getClass().toString());

    } // testTowerFactory

    /**
     * Tests if enemies damage the monument once the enemy reaches the monument.
     * Checks if the monument loses (gains from our implementation) health.
     * 
     * @author Max Ho
     */
    @Test
    public void testEnemyDamage() {
        TDApplication temp = new TDApplication();
        Player player = new Player("Joe Biden", Difficulty.CLOSED_NOTES);
        Vector2[] enemyPath = PathFactory.createPath(1);
        double beforeDamage = player.getGpa();
        temp.setPlayer(player);
        Enemy chegg = EnemyFactory.createEnemy('C', enemyPath).getGameObject();
        chegg.attackMonument(player);
        double afterDamage = player.getGpa();
        assertTrue(beforeDamage < afterDamage);
        chegg.attackMonument(player);
        double afterDamageAgain = player.getGpa();
        assertTrue(afterDamage < afterDamageAgain);
        assertTrue(beforeDamage < afterDamageAgain);



    } // testEnemyDamage


    /**
     * Tests if the enemy factory produces the correct results.
     *
     * @author Luke Walter
     */
    @Test
    public void testEnemyFactory() {

        TDApplication temp = new TDApplication();
        Player player = new Player("Joe Biden", Difficulty.CLOSED_NOTES);
        temp.setPlayer(player);

        Vector2[] examplePath = PathFactory.createPath(1);

        EnemyWrapper spiralNotebook = EnemyFactory.createEnemy('N', examplePath);
        EnemyWrapper textbook = EnemyFactory.createEnemy('T', examplePath);
        EnemyWrapper groupMe = EnemyFactory.createEnemy('G', examplePath);
        EnemyWrapper khanAcademy = EnemyFactory.createEnemy('K', examplePath);
        EnemyWrapper stackOverflow = EnemyFactory.createEnemy('S', examplePath);
        EnemyWrapper youtube = EnemyFactory.createEnemy('Y', examplePath);
        EnemyWrapper chegg = EnemyFactory.createEnemy('C', examplePath);

        assertEquals(spiralNotebook.toString(), "Enemy SpiralNotebook");
        assertEquals(textbook.toString(), "Enemy Textbook");
        assertEquals(groupMe.toString(), "Enemy GroupMe");
        assertEquals(khanAcademy.toString(), "Enemy KhanAcademy");
        assertEquals(stackOverflow.toString(), "Enemy StackOverflow");
        assertEquals(youtube.toString(), "Enemy YouTube");
        assertEquals(chegg.toString(), "Enemy Chegg");


        EnemyWrapper[] enemies = EnemyFactory.createAllEnemies("NTGKSYC", examplePath);

        assertEquals(enemies[0].toString(), "Enemy SpiralNotebook");
        assertEquals(enemies[1].toString(), "Enemy Textbook");
        assertEquals(enemies[2].toString(), "Enemy GroupMe");
        assertEquals(enemies[3].toString(), "Enemy KhanAcademy");
        assertEquals(enemies[4].toString(), "Enemy StackOverflow");
        assertEquals(enemies[5].toString(), "Enemy YouTube");
        assertEquals(enemies[6].toString(), "Enemy Chegg");

    } // testEnemyFactory

    /**
     * Tests if the path factory produces the correct results.
     *
     * @author Luke Walter
     */
    @Test
    public void testPathFactory() {

        Vector2[] testNodes = {
            new Vector2(512, 576),
            new Vector2(512, 475),
            new Vector2(1000, 475),
            new Vector2(1000, 350),
            new Vector2(25, 350),
            new Vector2(25, 225),
            new Vector2(1000, 225),
            new Vector2(1000, 25),
            new Vector2(576, 25)
        };

        Vector2[] pathNodes = PathFactory.createPath(1);

        assertEquals(testNodes.length, pathNodes.length);

        for (int i = 0; i < testNodes.length; i++) {
            assertEquals(testNodes[i], pathNodes[i]);

        } // for

    } // testPathFactory
  
} // M5Test
