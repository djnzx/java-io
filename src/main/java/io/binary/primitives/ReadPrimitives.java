package io.binary.primitives;

import java.io.*;
import java.util.ArrayList;

public class ReadPrimitives {
    public static void main(String[] args) throws IOException {
        File file = new File("./data", "file2.bin");
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

        boolean b = ois.readBoolean();
        System.out.println(b);

        short s = ois.readShort();
        System.out.println(s);

        int i = ois.readInt();
        System.out.println(i);

        long l = ois.readLong();
        System.out.println(l);

        char c = ois.readChar();
        System.out.println(c);

        float f = ois.readFloat();
        System.out.println(f);

        double d = ois.readDouble();
        System.out.println(d);
    }
}
