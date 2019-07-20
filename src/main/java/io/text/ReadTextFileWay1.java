package io.text;

import java.io.*;

public class ReadTextFileWay1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./data", "names.txt");
        FileReader fr = new FileReader(file);
        BufferedReader r = new BufferedReader(fr);

        String line;
        while ((line=r.readLine())!=null) {
            System.out.println(line);
        }
    }
}
