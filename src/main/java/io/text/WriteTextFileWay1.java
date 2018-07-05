package io.text;

import java.io.*;
import java.util.Arrays;
import java.util.function.Consumer;

public class WriteTextFileWay1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./data", "names2.txt");
        BufferedWriter w = new BufferedWriter(new FileWriter(file));
        //this line if you would like to append the content to end of the file
        //BufferedWriter w = new BufferedWriter(new FileWriter(file, true));
        Arrays.asList("line1","line2","line3","Привет").forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                try {
                    w.write(s);
                    w.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        w.close();
    }
}
