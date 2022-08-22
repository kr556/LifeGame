package ui_Frame;

public class sleepStop extends Thread {
    sleepStop (long l) {
        try {
            sleep(l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
