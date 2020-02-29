package io.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 6000);
    OutputStream out = socket.getOutputStream();
    byte[] bytes = "HELLO WORLD!".getBytes();
    out.write(bytes);
    out.flush();
    out.close();
    socket.close();
  }
}
