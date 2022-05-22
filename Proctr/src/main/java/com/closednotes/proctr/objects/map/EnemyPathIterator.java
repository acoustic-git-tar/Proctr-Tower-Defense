package com.closednotes.proctr.objects.map;

import com.closednotes.proctr.objects.Vector2;

import java.util.Iterator;

/**
 * EnemyPathIterator class. Keeps track of
 * enemies' progress while traversing the
 * EnemyPath and determines which node they
 * should target at any given point
 */
public class EnemyPathIterator implements Iterator<Vector2> {

    private Vector2[] pathNodes;
    private int target;

    /**
     * EnemyPathIterator constructor
     *
     * @param enemyPath EnemyPath object to iterate through
     */
    public EnemyPathIterator(Vector2[] enemyPath) {

        Vector2[] original = enemyPath;

        this.pathNodes = new Vector2[original.length];
        for (int i = 0; i < pathNodes.length; i++) {
            pathNodes[i] = new Vector2(original[i].getX(), original[i].getY());

        } // for

        this.target = 0;

    } // EnemyPathIterator

    /**
     * Resets the movement target to 0
     */
    public void reset() {
        this.target = 0;
    }

    /**
     * Checks if the path can still be iterated over
     *
     * @return true if target has not reached the end of the pool
     */
    @Override
    public boolean hasNext() {
        return target < this.pathNodes.length;
    }

    /**
     * Iterates over the path nodes and returns the next element
     *
     * @return the next element in the path, null if at the end
     */
    @Override
    public Vector2 next() {
        if (this.hasNext()) {
            return pathNodes[target++];
        }
        return null;

    } // next

} // EnemyPathIterator
