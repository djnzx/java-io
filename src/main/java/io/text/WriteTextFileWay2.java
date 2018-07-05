package io.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteTextFileWay2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./data", "names3.txt");
        ArrayList<String> content = new ArrayList<>();
        content.add("Hello");
        content.add("World");
        Files.write(path, content);
    }
}
