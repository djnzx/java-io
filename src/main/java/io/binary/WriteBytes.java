package io.binary;

import java.io.*;

public class WriteBytes {
    public static void main(String[] args) throws IOException {
        File file = new File("./data", "file.bin");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream os = new BufferedOutputStream(fos, 65000);
        // write one byte
        os.write(0x05);
        // write 10 bytes
        byte[] a = {0x11,0x22,0x33,0x44,0x55,0x66,0x77,(byte)0x88,(byte)0x99,0x00};
        os.write(a);
        os.close();
    }
}
