package com.closednotes.proctr.objects.map;

import com.closednotes.proctr.objects.Vector2;

/**
 * Path factory. Stores constructors with different
 * input conditions for the creation of an enemy path
 * and distinguishes between them through level numbers
 */
public abstract class PathFactory {

    /**
     * Constructs a preset enemy path based
     * on level
     *
     * @param map which enemy path to generate
     * @return new enemy path
     */
    public static Vector2[] createPath(int map) {

        switch (map) {

        case 1:
            Vector2[] pathNodes = {
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
            return pathNodes;

        default:
            throw new IllegalArgumentException("This level does not exist.");


        } // switch

    } // createPath

} // PathFactory
