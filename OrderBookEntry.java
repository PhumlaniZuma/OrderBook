public class OrderBookEntry
{
  private int id;
  private int price;
  private int quantity;
  private Side side;

  public OrderBookEntry(int price, int quantity, Side side)
  {
    this.id = OrderGenerator.getInstance().getCode() ;
    this.price = price;
    this.quantity = quantity;
    this.side = side;
  }
  public OrderBookEntry()
  {

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
