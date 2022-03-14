package com.learn.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * netty bytebuf 详解
 */
public class NettyByteBuf {

    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(10);

        // 移动write index 到5
        for (int i = 0; i < 5; i++) {
            buffer.writeByte(i);
        }
        System.out.println(buffer);

        // 读取index的数据（此方法不移动指针）
        for (int i = 0; i < 10; i++) {
            byte aByte = buffer.getByte(i);
            System.out.println("getByte: " + aByte);
        }

        // 读取index的数据， 移动指定到5
        for (int i = 0; i < 5; i++) {
            byte b = buffer.readByte();
            System.out.println("readByte:" + b);
        }
        System.out.println(buffer);

        // 读取index的数据， 移动指定到6， 抛出异常
        byte b = buffer.readByte();

    }
}
