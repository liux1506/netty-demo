package com.learn.test;

import io.netty.util.internal.StringUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * @Classname Test
 * @Description
 * @Date 2022/3/7 14:32
 * @Author by liuxing
 */
public class Test {

    public static void main(String[] args) throws IOException {
        LineIterator lineIterator = FileUtils
            .lineIterator(new File("D:\\Document\\浮动车数据\\0709.sql"), "UTF-8");
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (lineIterator.hasNext()) {
            String s = lineIterator.nextLine();
            String s1 = s.replaceAll("INSERT INTO \"\"", "INSERT INTO \"ods_ydxt_gps_data_realtime_di\"");
            sb.append(s1 + "\n");
            i++;
            if (i % 100000 == 0) {
                write(sb);
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            write(sb);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>> over i: ");
    }

    private static synchronized void write(StringBuffer sb) throws IOException {
        FileUtils.writeStringToFile(new File("D:\\Document\\浮动车数据\\0709_with_table_name_v3.sql"), sb.toString(), "UTF-8", true);
    }
}
