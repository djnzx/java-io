package io.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadTextFileWay3 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./data", "names.txt");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));
    }
}
