package ir.javacup.thread;

public class Resource {

    private int content;
    private boolean available = false;

    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        available = false;
        notify();
        return content;
    }

    public synchronized void set(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        content = value;
        available = true;
        notify();
    }
}

