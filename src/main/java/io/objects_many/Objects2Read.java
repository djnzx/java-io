package io.objects_many;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Objects2Read {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    File file = new File("objects2.bin");
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);

    boolean readed1 = ois.readBoolean(); // Boolean
    int readed2 = ois.readInt(); // Int
    Object readed3 = ois.readObject(); // Object
    String readed3s = (String)readed3;
    String readed4s = (String)ois.readObject();

    ois.close();
    fis.close();


    System.out.println(readed1);
    System.out.println(readed2);
    System.out.println(readed3s);
    System.out.println(readed4s);
  }
}
