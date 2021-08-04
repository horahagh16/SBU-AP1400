
import ir.javacup.thread.Consumer;
import ir.javacup.thread.Producer;
import ir.javacup.thread.Resource;

import java.util.concurrent.ConcurrentLinkedDeque;

public class test1 {

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