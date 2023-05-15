import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBook
{
  // A hashmap with the correct Hashing will allow me to achieve O(1) in add deleting and modify
  // because we will be using id's when deleting and modifying it is easy to get the entry with that id in O(1) and change or delete it.
  // when adding we will always add at the back of the list which will be O(1).
  private final Map<Integer, OrderBookEntry> orderList = new HashMap<>();

  //this is a method to view all the entries in the list. with Id's price and quantity
  // since you do want to return every entry in the list it will take O(N)
  public void checkAll()
  {
    for (OrderBookEntry order : orderList.values())
    {
      System.out.print("id=" + order.getId());
      System.out.print(" Price=" + order.getPrice());
      System.out.print(" Quantity=" + order.getQuantity() + " ,");
      System.out.println("");
    }
  }

  //this is a method to view a specific price on what is the buy and sell entries it has.
  // since you do want to return every entry in the list it will take O(log N)
  public void printOrder(int price, Side side)
  {
    for (OrderBookEntry order : orderList.values())
    {
      if (order.getPrice() == price && order.getSide().is(side.getSide()))
      {
        System.out.print("id=" + order.getId());
        System.out.print(" Price=" + order.getPrice());
        System.out.print(" Quantity=" + order.getQuantity() + " ,");
        System.out.print(" Side =" + order.getSide().getSide() + " ,");
        System.out.println("");
      }
    }
  }

  public void MatchingEngine(int price, int quantity, Side side)
  {
    List<Integer> tobeDeleted = new ArrayList<>();
    Map<Integer, Integer> tobeModify = new HashMap<>();
    for (OrderBookEntry order : orderList.values())
    {
      //here in the engine am making sure that when we have the ask and they new entry is a buy we match the two and sell or but that record. which will modify the quantity
      if (order.getPrice() == price && !order.getSide().is(side.getSide()) && quantity > 0)
      {
        // here it will be matching the actual price and quantity, which than we will need to delete the existing entry
        // setting the quantity is a way to show that all quantities off the new entry have been filled and we do not need to add a new record for this entry.
        if (order.getQuantity() == quantity)
        {
          tobeDeleted.add(order.getId());
          quantity = 0;
          break;
        }
        //if the existing record has a high quantity than the new entry we will modify the existing entry and for fill the new entry.
        // again we set the new quantity to zero so that to say all has been for filled for the new entry. no need to create a new entry.
        else if (order.getQuantity() > quantity)
        {
          tobeModify.put(order.getId(), order.getQuantity() - quantity);
          quantity = 0;
          break;
        }
        //in this case the new request has more quantity than the current entry in the list, so we will just minus the
        // quantity that is for filled by this current entry and move in the loop to the next existing entry to for fill the reminder of the quantity.
        else if (order.getQuantity() < quantity)
        {
          quantity = quantity - order.getQuantity();
          tobeDeleted.add(order.getId());
        }
      }
    }
    //if we get to this point and the quantity has not yet been fully for filled we will need to add a new record for future records that will for fill this entry.
    if (quantity != 0)
    {
      add(price, quantity, side);
    }
    // we kept a record off all the entries that needed to be d
    for (int i : tobeDeleted)
    {
      delete(i);
    }
    for (Map.Entry<Integer, Integer> map : tobeModify.entrySet())
    {
      modify(map.getKey(), map.getValue());
    }
  }


  public void add(int price, int quantity, Side side)
  {
    OrderBookEntry newOrder = new OrderBookEntry(price, quantity, side);
    orderList.put(newOrder.getId(), newOrder);
  }

  public void delete(int deleteId)
  {
    orderList.remove(deleteId);
  }

  public void modify(int id, int quantity)
  {
    OrderBookEntry oldEntry = orderList.get(id);
    delete(id);
    if (oldEntry != null)
    {
      OrderBookEntry newEntry = new OrderBookEntry(oldEntry.getPrice(), quantity, oldEntry.getSide());
      orderList.put(newEntry.getId(), newEntry);
    }
  }
}
