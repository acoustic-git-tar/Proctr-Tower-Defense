package com.closednotes.proctr.objects;

import javafx.scene.layout.AnchorPane;

import java.util.Iterator;

/**
 * Pool class for game objects. Allows for the storage of a constant set of
 * togglable game objects before rounds, eliminating the need to instantiate
 * new objects throughout the rounds.
 *
 * @param <T> type of game object in the pool (must be stored in GameObjectWrapper or child class)
 */
public class Pool<T extends GameObjectWrapper> implements Iterable<T> {

    private int size;
    private T[] objects;

    private AnchorPane anchor;

    /**
     * Constructor (empty pool)
     *
     * @param anchor scene pool is attached to
     * @param size number of elements in the pool
     */
    public Pool(AnchorPane anchor, int size) {
        this.size = size;
        this.anchor = anchor;
        this.objects = (T[]) new GameObjectWrapper[this.size];
    } // Constructor

    /**
     * Constructor (populated pool)
     *
     * @param anchor scene pool is attached to
     * @param size number of elements in the pool
     * @param objects list of objects to populate pool with
     */
    public Pool(AnchorPane anchor, int size, T[] objects) {
        this.size = size;
        this.anchor = anchor;
        this.populate(objects);

    } // Constructor

    /**
     * Sets the game objects that are contained in this pool
     *
     * @param objects list of objects to populate pool with
     */
    public void populate(T[] objects) {

        if (objects == null) {
            this.objects = (T[]) new GameObjectWrapper[this.size];

        } else if (this.size >= objects.length) {

            this.objects = (T[]) new GameObjectWrapper[this.size];

            for (int i = 0; i < objects.length; i++) {
                this.objects[i] = objects[i];
                this.objects[i].setScene(this.anchor);

            } // for

        } else {
            throw new IllegalArgumentException("Pool size must equal"
                    + " or exceed number of elements.");
        } // if

    } // populate

    /**
     * Activates the game object at a specified index in the pool
     *
     * @param index index of game object to be activated
     */
    public void activate(int index) {
        this.objects[index].activate();
    }

    /**
     * Deactivates the game object at a specified index in the pool
     *
     * @param index index of game object to be activated
     */
    public void deactivate(int index) {
        this.objects[index].deactivate();
    }

    /**
     * Gets the game object at a specified index in the pool
     * (returns a GameObjectWrapper or child class)
     *
     * @param index index of game object to be activated
     * @return game object at index
     */
    public T get(int index) {
        return this.objects[index];
    }

    /**
     * Size method
     *
     * @return size of pool
     */
    public int size() {
        return this.size;
    }

    /**
     * ToArray method
     *
     * @return array representation of Pool object
     */
    public T[] toArray() {
        return objects;
    }

    /**
     * Iterator method. Allows for for-each loops to be used with pools
     *
     * @return new iterator for this Pool object
     */
    public Iterator<T> iterator() {
        return new PoolIterator<>(this);
    }

    /**
     * ToString method
     *
     * @return string representation of a Pool object
     */
    public String toString() {

        String output = "GAMEOBJECT POOL:\n";

        for (T obj : objects) {
            output += obj + ": ";
            if (obj != null) {
                output += (obj.isActive()) ? "ACTIVE\n" : "INACTIVE\n";
            }

        } // for

        return output;

    } // toString

} // Pool
