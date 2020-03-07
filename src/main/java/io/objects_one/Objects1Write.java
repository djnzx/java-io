package io.objects_one;

import java.io.*;
import java.util.ArrayList;

public class Objects1Write {
  public static void main(String[] args) throws IOException {
    File file = new File("objects.bin");
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    ArrayList<String> al = new ArrayList<>();
    al.add("Jim");
    al.add("John");
    al.add("Jeremy");
    oos.writeObject(al);

    oos.close();
    fos.close();
  }
}
