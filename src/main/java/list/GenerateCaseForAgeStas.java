package list;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class GenerateCaseForAgeStas {

    public static void main(String[] args) throws IOException {
        final String fileName = "C:\\Users\\lijia\\IdeaProjects\\ml-algorithms\\resource\\age.txt";
        final Random random = new Random();
        BufferedWriter objWriter = null;
        objWriter = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(fileName))));
        for (int i = 0; i < 1400000000; i++) {
            int age = Math.abs(random.nextInt()) % 180;
            objWriter.write(age + "\r\n");
        }
        objWriter.flush();
        objWriter.close();
    }
}
