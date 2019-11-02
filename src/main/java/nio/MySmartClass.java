package nio;

public class MySmartClass implements AutoCloseable {
  @Override
  public void close() {
    System.out.println("< closed for me by java >");
  }
}
