package com.learn.test;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * @Classname Test
 * @Description
 * @Date 2022/3/7 14:32
 * @Author by liuxing
 */
public class Test {

    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File("D:\\Document\\浮动车数据\\testUpload_100G.txt");
        int i = 0;
        while (true){
            stringBuffer.append("制作100G数据为了测试奇文网盘上传是否会丢失分片，制作100G数据为了测试奇文网盘上传是否会丢失分片，制作100G数据为了测试奇文网盘上传是否会丢失分片。制作100G数据为了测试奇文网盘上传是否会丢失分片，制作100G数据为了测试奇文网盘上传是否会丢失分片，制作100G数据为了测试奇文网盘上传是否会丢失分片。");
            stringBuffer.append("\n");
            if (i % 1000000 == 0) {
                FileUtils.writeStringToFile(file, stringBuffer.toString(), "UTF-8", true);
                stringBuffer.setLength(0);
                if (file.length() > 1024L * 1024 * 1024 * 100) {
                    return;
                }
            }
            i++;
        }
    }
}
