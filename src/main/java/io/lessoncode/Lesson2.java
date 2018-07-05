package io.lessoncode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Lesson2 {
    // reading lines from files
    public static void main_1(String[] args) throws IOException {
        try {
            //r = getResource();
            BufferedReader br = new BufferedReader(new FileReader("1.txt")); // FileNotFoundException
            String line;
            while ((line=br.readLine())!=null) { // IOException
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("file not found...");;
        } catch (IOException e) {
            System.out.println("something wrong...");;
        } finally {
            //freeResource(r);
        }

        Scanner in = null;
        try {
            in = new Scanner(new FileReader("2.txt")); // FileNotFoundException
            while (in.hasNext()) {
                String s = in.nextLine();
                //...
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found...");;
        }

        List<String> strings = Files.readAllLines(Paths.get("java", "main", "1.txt"));
    }

    public static void main(String[] args) throws IOException {
        File f = new File("src/main/io", "3.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("Hello");
        //...
        bw.close();
    }
}
