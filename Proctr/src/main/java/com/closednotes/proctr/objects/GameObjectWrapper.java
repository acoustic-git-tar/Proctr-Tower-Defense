package com.closednotes.proctr.objects;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Wrapper class for game objects. Allows for game objects
 * to be stored in pools.
 *
 * @param <T> Type of object being wrapped (must be ImageView or child of ImageView)
 */
public abstract class GameObjectWrapper<T extends ImageView> {

    protected T gameObject;
    protected AnchorPane anchor;

    protected boolean active;

    protected GameObjectBehavior onActivate;
    protected GameObjectBehavior onDeactivate;

    /**
     * Getter
     *
     * @return game object
     */
    public T getGameObject() {
        return gameObject;
    }

    /**
     * Setter
     *
     * @param obj new game object
     * @return old game object
     */
    public T setGameObject(T obj) {
        T oldObj = this.gameObject;
        this.gameObject = obj;
        return oldObj;

    } // setGameObject

    /**
     * Check to see if game object is active
     *
     * @return active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Activates game object. Secondary effects
     * dependent on definition of game object
     * behavior (defined in subclasses)
     */
    public void activate() {
        this.onActivate.perform();
        active = true;

    } // activate

    /**
     * Deactivates game object. Secondary effects
     * dependent on definition of game object
     * behavior (defined in subclasses)
     */
    public void deactivate() {
        this.onDeactivate.perform();
        active = false;

    } // deactivate

    /**
     * Sets the scene where game object can be
     * added and removed. This method is called
     * by Pool during population.
     *
     * @param anchor scene
     */
    public void setScene(AnchorPane anchor) {
        this.anchor = anchor;
    } // setScene

    /**
     * Adds game object to the selected scene.
     */
    public void addToScene() {
        if (anchor != null) {
            anchor.getChildren().add(this.getGameObject());
        }

    } // addToScene

    /**
     * Removes game object from the selected scene.
     */
    public void removeFromScene() {
        int index = anchor.getChildren().indexOf(this.getGameObject());
        if (anchor != null && index >= 0 && index < anchor.getChildren().size()) {
            anchor.getChildren().remove(index);
        }

    } // addToScene

    public AnchorPane getAnchor() {
        return anchor;
    }

} // GameObjectWrapper
