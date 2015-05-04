import java.util.List;
import java.util.ArrayList;
public class AuctionItem {
    private List<String> bidders;
    private int          currentBid;
    private int          currentBidder;

    public AuctionItem(int startBid) {
        currentBid = startBid;
        bidders    = new ArrayList<String>();
    }
    public int getCurrentBid() {
        return currentBid;
    }
    public String getCurrentBidder() {
        return bidders.get(currentBidder);
    }
    public void acceptBid(String name, int bid) {
        if(bid > currentBid) {
            currentBid    = bid;
            currentBidder = bidders.indexOf(name);
            if(currentBidder == -1) {
                bidders.add(name);
                currentBidder = bidders.size() - 1;
            }
        }
    }
    public String toString() {
        return "Current Bidder: " + bidders.get(currentBidder) +
                    "Current Bid: " + currentBid;
    }
    public Object saveToMemento() {
        System.out.println("Saving to Memento");
        return new Memento(bidders, currentBid, currentBidder);
    }
    public void restoreFromMemento(Object o) {
        if(o instanceof Memento) {
            Memento mem        = (Memento)o;
            this.bidders       = mem.bidders;
            this.currentBid    = mem.currentBid;
            this.currentBidder = mem.currentBidder;
            System.out.println("Originator: State after restoring from" 
                                + " memento: " + " Current Bid: " + 
                                mem.currentBid + " Current Bidder: " + 
                                mem.currentBidder);
        }
    }
    private static class Memento {
        private List<String> bidders;
        private int          currentBid;
        private int          currentBidder;

        public Memento(List<String> bidders, int currentBid, 
                            int currentBidder) {
            this.bidders       = bidders;
            this.currentBid    = currentBid;
            this.currentBidder = currentBidder;
        }
    }
}
