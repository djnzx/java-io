package io.objects_one;

import java.io.*;
import java.util.ArrayList;

public class Objects2Read {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    File file = new File("objects.bin");
      FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
          Object readed = ois.readObject();
          ArrayList<String> data = (ArrayList<String>) readed;
          System.out.println(data);
        ois.close();
      fis.close();
  }
}
