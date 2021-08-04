public class Auctioneer implements Runnable {
    private long startPrice;
    private long interval;
    private Buyer finalBuyer;
    private long finalPrice;
    //
    public boolean check;

    public Auctioneer(long startPrice, long interval) {
        this.startPrice = startPrice;
        this.interval = interval;
        finalPrice = -1;
        finalBuyer = null;
    }

    public Buyer getFinalBuyer() {
        return finalBuyer;
    }

    public long getFinalPrice() {
        return finalPrice;
    }

    @Override
    public void run() {
        synchronized (this) {
            notifyAll(); // notify all buyers to start biding
        }

        // TODO
        while (true) {
            synchronized (this) {
                check = false;
                System.out.println("Auctioneer waiting for a bid");
                try {
                    wait(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!check) {
                    System.out.println("Auctioneer doesn't receive anything anymore");
                    break;
                }

            }
        }

    }

    public synchronized void checkSug(long price, Buyer buyer) {
        if (price > finalPrice && price >= startPrice) {
            notify();
            System.out.println("Auctioneer receives a bid from " + buyer.getName() + " : " + price);

            finalPrice = price;
            finalBuyer = buyer;

        }
        check = true;
    }
}
