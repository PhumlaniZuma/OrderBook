
public class Main
{
  public static void main(String[] args)
  {
    OrderBook orderBook = new OrderBook();

    orderBook.MatchingEngine(12,20,Side.BUY);
    orderBook.MatchingEngine(12,10,Side.BUY);

    orderBook.MatchingEngine(7,50,Side.SELL);
    orderBook.MatchingEngine(7,50,Side.SELL);

    orderBook.MatchingEngine(11,40,Side.BUY);
    orderBook.MatchingEngine(11,50,Side.BUY);

    orderBook.MatchingEngine(8,30,Side.SELL);
    orderBook.MatchingEngine(8,20,Side.SELL);


    orderBook.MatchingEngine(10,5,Side.BUY);
    orderBook.MatchingEngine(10,100,Side.BUY);

    orderBook.MatchingEngine(9,40,Side.SELL);
    orderBook.MatchingEngine(9,20,Side.SELL);

    orderBook.MatchingEngine(9,5,Side.BUY);


    orderBook.MatchingEngine(10,20,Side.SELL);
    orderBook.printOrder(9);
  }
}
