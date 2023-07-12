package List;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AgeStas {

    public static void main(String[] args) throws IOException {
        String str = null;
        String fileName = "C:\\Users\\lijia\\IdeaProjects\\ml-algorithms\\resource\\age.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(Paths.get(fileName)), StandardCharsets.UTF_8);

        long start = System.currentTimeMillis();
        BufferedReader bufferReader = new BufferedReader(inputStreamReader);
        int total = 0;
        int[] data = new int[200];
        while((str = bufferReader.readLine()) != null){
            int age = Integer.parseInt(str);
            data[age] ++;
            total ++;
        }
        System.out.println("总数据大小: " + total);

        for (int i = 0; i < 200; i++) {
            System.out.println(i + ":" + data[i]);
        }
        System.out.println("计算花费的时间为: " +(System.currentTimeMillis() - start) + "ms");
    }
}
