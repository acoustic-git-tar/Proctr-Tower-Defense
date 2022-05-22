package com.closednotes.proctr.objects;

/**
 * Two-dimensional vector. Useful for
 * representing coordinates and vectors
 */
public class Vector2 {

    private double x;
    private double y;

    /**
     * Vector2 constructor
     *
     * @param x x value of vector
     * @param y y value of vector
     */
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;

    } // Constructor

    /**
     * Finds the distance between two points
     * using the distance formula
     *
     * @param a a point
     * @param b another point
     * @return the distance between a and b
     */
    public static double getDistance(Vector2 a, Vector2 b) {
        double xDiff = Math.abs(a.x - b.x);
        double yDiff = Math.abs(a.y - b.y);
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));

    } // getDistance

    /**
     * Takes in a single vector and creates a new vector
     * at the same angle with a magnitude of 1 (normalized)
     *
     * @param v vector to be normalized
     * @return normalized representation of original vector
     */
    public static Vector2 normalize(Vector2 v) {
        double magnitude = Vector2.getDistance(new Vector2(0, 0), v);
        return new Vector2(v.x / magnitude, v.y / magnitude);

    } // normalize

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * equals method
     *
     * @param o object being compared to this Vector2
     * @return true if objects have equal value, false otherwise
     */
    @Override
    public boolean equals(Object o) {

        String v2 = this.getClass().getSimpleName();

        if (o.getClass().getSimpleName().equals(v2)) {
            Vector2 other = (Vector2) o;
            return this.x == other.x && this.y == other.y;

        } else {
            return false;

        } // if

    }  // equals

    /**
     * toString method
     *
     * @return string representation of a vector
     */
    @Override
    public String toString() {
        return "x: " + this.x + ", y: " + this.y;

    } // toString

} // Vector2
