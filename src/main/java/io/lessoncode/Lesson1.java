package io.lessoncode;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Lesson1 {
    public static void main11(String[] args) {
        //File f = new File("/home/DI/arykhalskiy/IdeaProjects/fs6a/src/main/java/io/test.txt");
        File f = new File("./src/main/java/io/test.txt");
        //File f = new File("test.txt");
        //f.delete();

        File absoluteFile = f.getAbsoluteFile();
        System.out.println(absoluteFile);
        System.out.println(f.exists());

        //InputStream is;
        //OutputStream os;
        //is.read();
        //os.write();
    }

    public static void main12(String[] args) throws FileNotFoundException {
        // general
        DataOutput out;
        DataInput in;

        // generic read/write
        // how to read via stream
        FileInputStream fis = new FileInputStream("1.txt");
        // how to write via stream
        FileOutputStream fos = new FileOutputStream("1.txt");

        // specific data readWrite
        // read
        DataInputStream dis = new DataInputStream(fis);
        // write
        DataOutputStream dos = new DataOutputStream(fos);

        // if we want to bufferize
        BufferedInputStream bis = new BufferedInputStream(fis); // dis
        BufferedOutputStream bos = new BufferedOutputStream(fos); // dos

        // rewind feature
        PushbackInputStream pbis = new PushbackInputStream(fis);
        //pbis.unread();

        // unzip on the fly
        FileInputStream fileStreamZipped = new FileInputStream("1.zip");
        ZipInputStream zipins = new ZipInputStream(fileStreamZipped);
        DataInputStream dis_unzipped = new DataInputStream(zipins);

        // zip on the fly
        FileOutputStream fos2 = new FileOutputStream("out.zip");
        ZipOutputStream zipous = new ZipOutputStream(fos2);
        DataOutputStream dos2 = new DataOutputStream(zipous);

    }

    public static void main88(String[] args) throws FileNotFoundException {
        // how to read via stream
        FileInputStream fis = new FileInputStream("1.txt");
        // how to write via stream
        FileOutputStream fos = new FileOutputStream("1.txt");
        // specific data readWrite
        // read
        DataInputStream dis = new DataInputStream(fis);
        // write
        DataOutputStream dos = new DataOutputStream(fos);


        BufferedInputStream bis;
        BufferedOutputStream bos;
        // sample

        FileInputStream fis1 = new FileInputStream("1.txt");
        BufferedInputStream bis1 = new BufferedInputStream(fis1,10000);
        DataInputStream dis1 = new DataInputStream(fis1);
        DataInputStream dis2 = new DataInputStream(bis1);

        DataInputStream dis3 = new DataInputStream(new BufferedInputStream(new FileInputStream("1.txt"), 1000));
        DataOutputStream dos3 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("2.txt"), 2000));
    }

    public static void main666(String[] args) {
        //String s="привет";
        String s="пр";
        System.out.println(s.length());
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int aChar = chars[i];
            System.out.printf(aChar+" ");
        }
        for (int i = 0; i < chars.length; i++) {
            int aChar = chars[i];
            System.out.printf(Integer.toBinaryString(aChar)+" ");
        }
        System.out.println((int)s.charAt(0));
    }

    public static void main13(String[] args) throws FileNotFoundException {
        FileReader r = new FileReader("1.txt");


    }

    public static void main14(String[] args) throws FileNotFoundException {
        File file = new File("./src/main/java/io/1.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.print(13);
        pw.close();
    }

    public static void main15(String[] args) throws FileNotFoundException {
        File file = new File("11");
        BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(file));
        Scanner in = new Scanner(new File("./src/main/java/io/1.txt"));
    }

    public static void main16(String[] args) throws FileNotFoundException {
        // if we are dealing with TEXT only
        PrintWriter pw = new PrintWriter(new File("file_toWrite.txt"));
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("file_toWrite.txt")));
        //pw.write
        // how to read the file
    }

    public static void main17(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("1.txt")));
        //String line = br.readLine();
        String line;
        while ((line = br.readLine())==null){
            line.charAt(0);
        }
    }

    public static void main18(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(new File("1.txt")));
        Stream<String> lines = br.lines();
        //lines.forEach();
    }

    public static void main19(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("file.txt")));
        bw.write("hello");
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/io","file.txt");
        byte[] bytes = Files.readAllBytes(path);
        Charset cs = StandardCharsets.UTF_8;
        String s = new String(bytes, cs);
        List<String> sl = Files.readAllLines(path, cs);
        // large file (lazy load)
        Stream<String> lines = Files.lines(path, cs);
    }

    // https://software.intel.com/sites/default/files/Figure8.jpg
    // http://i.voenmeh.ru/kafi5/Kam.loc/inform/UTF-8.htm

    public static void main1(String[] args) throws IOException, ClassNotFoundException {

        /* randomAccess
            rws flushes the contents of the file and the modification date of the file.
            rwd flushes the contents of the file, but the modification date might not change until the file is closed.
            rw only flushes when you tell it to and doesn't change the modifcation date until you close the file.
            BTW rwd is much slower for writes than rw, and rws is slower again.
         */

        RandomAccessFile raf = new RandomAccessFile(new File("1.bin"), "r");
        long position = raf.getFilePointer();
        raf.seek(position);

        // Objects
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file"));
        oos.writeObject(new String(""));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file"));
        Object o = ois.readObject();

        // magic with bytes.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(55);
        baos.write(77);
        baos.write(77);
        baos.write(77);
        baos.write(77);
        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        int read = bais.read();
    }

    public static void main2(String[] args) {
        // paths
        Path absolute = Paths.get("/home", "alex");
        Path relative = Paths.get("dev", "student","dima");
        relative.toAbsolutePath();
        File file = relative.toFile();
    }

    public static void main3(String[] args) throws IOException {
        InputStream is = Files.newInputStream(Paths.get("1.txt"));
        BufferedReader br = Files.newBufferedReader(Paths.get("1.txt"));
        OutputStream os = Files.newOutputStream(Paths.get("1.txt"));
        BufferedWriter bw = Files.newBufferedWriter(Paths.get("1.txt"));
    }

    public static void main4(String[] args) throws IOException {
        File f = new File("1.txt");
        boolean deleted = f.delete();

        File f2 = new File("1.txt");
        boolean successful = f2.createNewFile();

        Files.delete(Paths.get("1.txt"));
        Files.deleteIfExists(Paths.get("1.txt"));

        Path f3 = Files.createFile(Paths.get("1.txt"));
        Path f4 = Files.createTempFile("aa", "bb");
    }

    public static void main5(String[] args) throws IOException {
        Path dir1 = Files.createDirectory(Paths.get("aa"));
        Path dir2 = Files.createTempDirectory(Paths.get("aa"), "_tt");
    }

    public static void main6(String[] args) throws IOException {
        Path src = Paths.get("from.txt");
        Path dst = Paths.get("to.txt");
        FileInputStream in = new FileInputStream("from.txt");
        FileOutputStream os = new FileOutputStream("to.txt");

        Files.copy(src, dst);
        Files.copy(in, dst);
        Files.copy(src, os);

        Files.move(src, dst);
    }

    public static void main7(String[] args) throws IOException {
        DirectoryStream<Path> dirs0 = Files.newDirectoryStream(Paths.get(""));
        dirs0.forEach(System.out::println);
        System.out.println("-----");
        DirectoryStream<Path> dirs1 = Files.newDirectoryStream(Paths.get("."));
        dirs1.forEach(System.out::println);
        System.out.println("-----");
        DirectoryStream<Path> dirs2 = Files.newDirectoryStream(Paths.get("").toAbsolutePath(), "*");
        dirs2.forEach(System.out::println);
    }

    public static void main8(String[] args) throws IOException {
        // filter with specific
        Stream<Path> walk = Files.walk(Paths.get(""));
        walk.forEach(new Consumer<Path>() {
            @Override
            public void accept(Path path) {

            }
        });
    }

    public static void main9(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("src/main/java/core.iter/"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main99(String[] args) throws IOException {
        // how to read the stings
        FileInputStream fis = new FileInputStream("1.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line=br.readLine())!=null) {
            System.out.println(line);
        }
    }

}
