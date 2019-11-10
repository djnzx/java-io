package io.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(6000);
    Socket connection = server.accept();
    InputStream in = connection.getInputStream();
    String message = readMessage(in);
    System.out.printf("message:%s\n", message);
    server.close();
  }

  private static String readMessage(InputStream in) throws IOException {
    byte[] buffer = new byte[1024];
    int read = in.read(buffer);
    return new String(buffer, 0, read);
  }
}
