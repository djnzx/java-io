package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StructureApp {

  private static List<String> read_CLASSIC(String name) throws IOException {
    File ifile = new File(name);
    BufferedReader br = new BufferedReader(new FileReader(ifile));
    String line;
    ArrayList<String> lines = new ArrayList<>();
    while ((line = br.readLine())!=null) {
      lines.add(line);
    }
    br.close();
    return lines;
  }

  private static List<String> read(String name) throws IOException {
    File ifile = new File(name);
    FileReader fr = new FileReader(ifile);
    BufferedReader br = new BufferedReader(fr);
    List<String> lines = br.lines().collect(Collectors.toList());
    br.close();
    return lines;
  }

  private static List<String> process(List<String> data) {
    return data.stream().sorted().collect(Collectors.toList());
  }

  private static void write(List<String> processed, String name) throws IOException {
    File ofile = new File(name);
    BufferedWriter bw = new BufferedWriter(new FileWriter(ofile));
    for (String line: processed) {
      bw.write(line);
      bw.write("\n");
    }
    bw.close();
  }

  public static void main(String[] args) throws IOException {
    List<String> data = read("myAwesomeData.txt");
    List<String> processed = process(data);
    write(processed, "myBrilliantData.txt");
  }

}
