package com.biosh.owner.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * @description
 * @date 2019/6/22
 */
public class WebControllerTest {

    @Test
    public void fileTest() throws IOException {

        Path path = Paths.get("c:/Users/konglingbiao/workspace/emc/testFile");
        // 判断是否有testFile
        boolean existTestFile = Files.exists(path);

        if (existTestFile) {
            // 有testFile，读取文件的内容
//            InputStream inputStream = new FileInputStream(path.toString());
////            StringBuilder stringBuilder = new StringBuilder();
////            StringBuilder stringBuilder1 = new StringBuilder();
////            int num;
////            while ((num = inputStream.read()) != -1) {
////                stringBuilder.append(num);
////                stringBuilder1.append((char) num);
////            }
////            System.out.println(stringBuilder.toString());
////            System.out.println(stringBuilder1.toString());
////            inputStream.close();
            BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
            reader.close();
        } else {
            // 没有testFile, 新建文件，写入指定内容
            Files.createFile(path.toAbsolutePath());
            FileWriter fileWriter = new FileWriter(path.toString());
            fileWriter.write("hello world!");
            fileWriter.flush();
            System.out.println("输出指定内容-> hello world！");
            fileWriter.close();
        }

    }

    @Test
    public void IoTest() {

        double a = Math.ceil(Math.random() * 6);
        double b = Math.ceil(Math.random() * 6);
        double c = Math.ceil(Math.random() * 6);
        System.out.println(a+b+c);
    }

}
