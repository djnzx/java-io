package nio;

import java.io.*;

/**
 * since Java 7
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
 *
 * The Closeable interface extends the AutoCloseable interface
 *
 * Closeable: public void close() throws IOException;
 * AutoCloseable: void close() throws Exception
 *
 */
public class TryWithResourcesApp {
  public static void main(String[] args) throws IOException {
    String path = "1.txt";

    try (
        BufferedReader br1 = new BufferedReader(new FileReader(path));
        BufferedReader br2 = new BufferedReader(new FileReader(path));
    )
    {
      String readed = br1.readLine();
      System.out.println(readed);
    }
    // br will be closed automatically
    // you don't need to call br.close()
    // because of 'java.lang.AutoCloseable' implemented by BufferedReader

  }
}
