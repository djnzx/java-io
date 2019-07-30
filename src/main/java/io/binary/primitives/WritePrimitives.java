package io.binary.primitives;

import java.io.*;

public class WritePrimitives {
    public static void main(String[] args) throws IOException {
        File file = new File("./data", "file3.bin");
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        boolean b1=true;
        oos.writeBoolean(b1);
        int s1=2;
        oos.writeShort(s1); // -32768..32767
        int i1=3;
        oos.writeInt(i1); //  -2_147_483_648..2_147_483_647
        long l1=9223372036854775807L;
        oos.writeLong(l1); //  -2^63 to 2^63-1.
        char c='П';
        oos.writeChar(c);
        float f1=1.5f;
        oos.writeFloat(f1);
        double d1=2.5;
        oos.writeDouble(d1);

        // write object
        oos.writeObject(new Person("Alex"));

        oos.close();
    }
}
