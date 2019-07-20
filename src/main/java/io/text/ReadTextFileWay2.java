package io.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ReadTextFileWay2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./data", "names.txt");

        Stream<String> lines = new BufferedReader(new FileReader(file)).lines();
        lines.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
