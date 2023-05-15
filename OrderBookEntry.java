public class OrderBookEntry
{
  private int id;
  private int price;
  private int quantity;
  private Side side;

  public OrderBookEntry(int price, int quantity, Side side)
  {
    //when a new entry of order is added we are creating the id from the OrderGenerator class that will keep count of the previous id and increment this new one by 1,
    //this will help in making sure that the new entry always comes at the bottom off the list, as it has the highest value off keys in the list.
    this.id = OrderGenerator.getInstance().getCode() ;
    this.price = price;
    this.quantity = quantity;
    this.side = side;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getPrice()
  {
    return price;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  public Side getSide()
  {
    return side;
  }

  public void setSide(Side side)
  {
    this.side = side;
  }
}
