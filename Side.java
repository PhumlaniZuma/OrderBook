public enum Side
{
  BUY("buy"),
  SELL("sell");


  private final String side;

  Side(String side)
  {
    this.side = side;
  }

  public boolean is(String side)
  {
    return this.side.equals(side);
  }

  public String getSide()
  {
    return side;
  }
}
