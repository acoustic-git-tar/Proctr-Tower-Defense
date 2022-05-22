package com.closednotes.proctr.objects.enemy;


import com.closednotes.proctr.objects.*;
import com.closednotes.proctr.objects.enemy.variants.*;

/**
 * Enemy factory. Stores constructors for each type of
 * enemy object and creates them based on input conditions.
 */
public abstract class EnemyFactory {

    /**
     * Constructs an enemy based on char input
     *
     * @param variant determines which type of enemy is created
     * @param enemyPath enemy path generated enemy is assigned to
     * @return new enemy object (ready to be pooled)
     */
    public static EnemyWrapper createEnemy(char variant, Vector2[] enemyPath) {

        switch (variant) {
        case 'G':
            return new EnemyWrapper(new GroupMe(enemyPath));
        case 'T':
            return new EnemyWrapper(new Textbook(enemyPath));
            // Textbook
        case 'N':
            return new EnemyWrapper(new SpiralNotebook(enemyPath));
            // Spiral Notebook
        case 'S':
            return new EnemyWrapper(new StackOverflow(enemyPath));
            // Stack Overflow
        case 'Y':
            return new EnemyWrapper(new YouTube(enemyPath));
            // YouTube
        case 'K':
            return new EnemyWrapper(new KhanAcademy(enemyPath));
            // KhanAcademy
        case 'C':
            return new EnemyWrapper(new Chegg(enemyPath));
            // Chegg
        default:
            throw new IllegalArgumentException("This enemy type does not exist.");
            // default
        } // switch

    } // createEnemy

    /**
     * Constructs a set of enemies based on string input
     *
     * @param enemyTypes determines which types of enemies are created
     * @param enemyPath enemy path generated enemies are assigned to
     * @return set of new enemy objects (ready to be pooled)
     * @throws IllegalArgumentException if string contains invalid characters
     */
    public static EnemyWrapper[] createAllEnemies(String enemyTypes,
                          Vector2[] enemyPath) throws IllegalArgumentException {

        EnemyWrapper[] enemies = new EnemyWrapper[enemyTypes.length()];

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = EnemyFactory.createEnemy(enemyTypes.charAt(i), enemyPath);

        } // for

        return enemies;

    } // createAllEnemies

} // EnemyFactory
