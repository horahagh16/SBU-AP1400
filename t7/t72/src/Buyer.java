import ViewModel.Bid;

import java.util.List;

public class Buyer implements Runnable {
    private String name;
    private final List<Bid> bids;
    private final Auctioneer auctioneer;

    public Buyer(String name, List<Bid> bids, Auctioneer auctioneer) {
        this.name = name;
        this.bids = bids;
        this.auctioneer = auctioneer;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        synchronized (auctioneer) {
            try {
                auctioneer.wait(); // wait until auctioneer start auction
            } catch (InterruptedException e) {
                // ignore it
            }
        }

        // TODO
        for (Bid b : bids) {
            NewThread nt = new NewThread(b);
            nt.start();
            auctioneer.checkSug(b.getPrice(), this);
        }
    }
}

class NewThread extends Thread {
    Bid b;

    NewThread(Bid b) {
        this.b = b;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(b.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}