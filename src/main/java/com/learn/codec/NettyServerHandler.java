package com.learn.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @Classname NettyServerHandler
 * @Description 自定义Handler需要继承netty规定的HandlerAdapter
 * @Date 2022/3/3 19:14
 * @Author by liuxing
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送的数据
     * @param ctx 上下文，含channel和pipeline
     * @param msg 数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程" + Thread.currentThread().getName());
        System.out.println("服务器读到数据：" + msg.toString());
    }

    /**
     * 读取完毕处理方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        Person person = new Person("service", 25);
        ctx.writeAndFlush(person);
    }

    /**
     * 处理异常方法
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
