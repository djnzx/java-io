package io.objects_many;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Objects1Write {
  public static void main(String[] args) throws IOException {
    File file = new File("objects2.bin");
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeBoolean(true);
    oos.writeInt(42);
    oos.writeObject("Hello");
    oos.writeObject("Hello");

    oos.close();
    fos.close();
  }
}
