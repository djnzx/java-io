package io.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadTextFileWay4 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./data", "names.txt");
        List<String> lines = Files.readAllLines(path);
        // Use this approach to explicitly set file encoding
        //List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
    }
}
