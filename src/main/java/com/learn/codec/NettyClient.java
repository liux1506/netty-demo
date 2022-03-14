package com.learn.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * @Classname NettyClient
 * @Description
 * @Date 2022/3/3 20:15
 * @Author by liuxing
 */
public class NettyClient {

    public static void main(String[] args) {

        // 事件循环组
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建启动对象
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                .channel(NioSocketChannel.class) //NioSocketChannel
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception { // channel 初始化
                        ChannelPipeline pipeline = ch.pipeline(); // pipeline
                        pipeline.addLast(new NettyClientHandler()); // 自定义handler
                    }
                });

            System.out.println("client start");
            // 连接
            ChannelFuture cf = bootstrap.connect("localhost", 9000).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
