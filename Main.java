import java.util.Date;

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
    orderBook.printOrder(9,Side.SELL);
    System.out.println("");


    long startTime = System.currentTimeMillis();

    orderBook.MatchingEngine(9,20,Side.SELL);

    long endTime = System.currentTimeMillis();

    System.out.println("code to add a new order took " + (endTime - startTime) + " milliseconds");

     startTime = System.currentTimeMillis();

    orderBook.delete(12);

    endTime = System.currentTimeMillis();

    System.out.println("code to delete id 12 took " + (endTime - startTime) + " milliseconds");


    OrderBook orderBook2 = new OrderBook();

    startTime = System.currentTimeMillis();
    for (int i = 1000 ; i > 0; i--)
    {
      orderBook2.MatchingEngine(new Double(Math.random()).intValue(), i, Side.BUY);
    }
    endTime = System.currentTimeMillis();

    System.out.println("code to add 1000 orders took " + (endTime - startTime) + " milliseconds");
    System.out.println("");
    orderBook.checkAll();
  }
}
