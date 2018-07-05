package io.binary;

import io.extra.ByteArrayToString;
import java.io.*;

public class ReadBytes {
    public static void main(String[] args) throws IOException {
        File file = new File("./data", "file.bin");
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
        // read one byte
        int read = is.read();
        System.out.println(read);
        // read 10 bytes
        byte[] a = new byte[10];
        int amount = is.read(a);
        System.out.printf("amount is:%d\n", amount);
        System.out.println(new ByteArrayToString(a));
    }
}
