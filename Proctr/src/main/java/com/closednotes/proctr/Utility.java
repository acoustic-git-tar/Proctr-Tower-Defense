package com.closednotes.proctr;

/**
 * Contains miscellaneous functions that
 * can used anywhere in the program
 */
public class Utility {

    /**
     * Starts a new thread for a background function
     *
     * @param r function to be ran in background thread
     */
    public static void runNow(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();

    } // runNow

} // Utility
