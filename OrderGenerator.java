public class OrderGenerator
{
  private int code = 0;
  private static OrderGenerator orderGenerator;

  public static synchronized void createInstance()
  {
    if(orderGenerator == null)
    {
      orderGenerator = new OrderGenerator();
    }
  }

  public static OrderGenerator getInstance()
  {
    if (orderGenerator == null)
    {
      createInstance();
    }
    return orderGenerator;
  }

  public int getCode()
  {
    return code++;
  }
}
