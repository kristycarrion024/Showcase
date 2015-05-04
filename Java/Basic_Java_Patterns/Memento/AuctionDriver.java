public class AuctionDriver {
    public static void main(String[] args) {
        AuctionItem actionFigure = new AuctionItem(500);
        CareTaker careTaker      = new CareTaker(); 
        actionFigure.acceptBid("Bob", 1000);
        actionFigure.acceptBid("Jane", 1500);
        careTaker.addMemento(actionFigure.saveToMemento());
        actionFigure.acceptBid("Jill", 1750);
        careTaker.addMemento(actionFigure.saveToMemento());
        actionFigure.acceptBid("Bob", 1900);
        actionFigure.acceptBid("Jill", 2100);
        actionFigure.restoreFromMemento(careTaker.getMemento(1));
    }
}
