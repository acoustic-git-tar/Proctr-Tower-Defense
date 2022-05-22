package com.closednotes.proctr.objects.map;

import com.closednotes.proctr.objects.Pool;
import com.closednotes.proctr.objects.Vector2;
import com.closednotes.proctr.objects.enemy.EnemyFactory;
import com.closednotes.proctr.objects.enemy.EnemyWrapper;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

public abstract class LevelFactory {

    public static String[] enemySpawnSeeds = {
            "NN",
            "N",
            "CNN"
    };

    public static Pair<Boolean, Pool<EnemyWrapper>> createLevelData(AnchorPane anchor, int level, int pathNo)
                                                                                throws IndexOutOfBoundsException {

        if (level > enemySpawnSeeds.length) throw new IndexOutOfBoundsException();

        Vector2[] enemyPath = PathFactory.createPath(pathNo);
        EnemyWrapper[] enemies = EnemyFactory.createAllEnemies(enemySpawnSeeds[level - 1], enemyPath);
        Pool<EnemyWrapper> enemyPool = new Pool<>(anchor, enemies.length, enemies);

        return new Pair<>(level == enemySpawnSeeds.length, enemyPool);

    } // createLevelData

} // LevelFactory
