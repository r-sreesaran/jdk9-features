package org.wildcraft.spinwaithint;

public class EventHandler {
    volatile boolean eventNotificationReceived;

    //For Low Level Stuff, we write program as below
    //x86 machines will see the spin loop and are able to optimize it
    void waitForEventAndHandleIt() {
        while (!eventNotificationReceived) {
            Thread.onSpinWait();
        }
        readAndProcessEvent();
    }

    void readAndProcessEvent() {
        /* ... */
    }

}