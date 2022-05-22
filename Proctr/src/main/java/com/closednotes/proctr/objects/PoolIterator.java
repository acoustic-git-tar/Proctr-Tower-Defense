package com.closednotes.proctr.objects;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for the Pool class. Allows
 * for-each loops to be used with pools.
 *
 * (Don't worry about how to use this class,
 * you'll probably never need to instantiate it)
 *
 * @param <T> type of object in pool being iterated over
 */
public class PoolIterator<T extends GameObjectWrapper> implements Iterator<T> {

    private Pool<T> pool;
    private int index;

    /**
     * Constructor
     *
     * @param pool pool being iterated over
     */
    public PoolIterator(Pool<T> pool) {
        this.pool = pool;
        index = 0;

    } // Constructor

    /**
     * Checks if the pool can still be iterated over
     *
     * @return true if index has not reached the end of the pool
     */
    public boolean hasNext() {
        return index < this.pool.toArray().length;
    }

    /**
     * Iterates over the pool and returns the next element
     *
     * @return the next element in the pool
     * @throws NoSuchElementException if there is no element to iterate over
     */
    public T next() {
        if (this.hasNext()) {
            return this.pool.toArray()[index++];
        }
        throw new NoSuchElementException("The end of the pool has been reached.");

    } // next

} // PoolIterator
