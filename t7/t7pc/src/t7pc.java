
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class t7pc {
    static final ConcurrentLinkedDeque<Integer> holder = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) throws InterruptedException {

        Resource reource = new Resource();

        Producer producer = new Producer(reource, holder, 10);

        Consumer consumer = new Consumer(reource, holder, 10);

        consumer.start();
        producer.start();


        consumer.join();
        producer.join();

        System.out.println(holder);

    }
}

class Producer extends Thread {

    private Resource resource;
    private Deque<Integer> holder;
    private int count;

    public Producer(Resource resource, Deque<Integer> holder, int count) {
        this.resource = resource;
        this.holder = holder;
        this.count = count;
    }

    @Override

    public void run() {
        for (int i = 0; i < this.count; i++) {
            resource.set(i);
            holder.add(i);
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer extends Thread {

    private Resource resource;
    private Deque<Integer> holder;
    private int count;

    public Consumer(Resource resource, Deque<Integer> holder, int count) {
        this.resource = resource;
        this.holder = holder;
        this.count = count;
    }

    @Override
    public void run() {
        int value = 0;
        for (int i = 0; i < count; i++) {
            value = resource.get();
            holder.add(value);
        }
    }

}

class Resource {

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

