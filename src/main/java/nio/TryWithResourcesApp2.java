package nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
public class TryWithResourcesApp2 {
  public static void main(String[] args) throws IOException {

    try (
        MySmartClass resource = new MySmartClass()
    ) {
      System.out.println("... working...");
    }
    // br will be closed automatically
    // you don't need to call br.close()
    // because of 'java.lang.AutoCloseable' implemented by BufferedReader

  }
}
