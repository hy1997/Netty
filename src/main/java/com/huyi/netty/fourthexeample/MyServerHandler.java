package com.huyi.netty.fourthexeample;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event=  (IdleStateEvent)evt;

            String evenType=null;
            switch (event.state()){
                case ALL_IDLE:
                    evenType="读写空闲";
                    break;
                case WRITER_IDLE:
                    evenType="写空闲";
                    break;
                case READER_IDLE:
                    evenType="读空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件： " + evenType);
        }

    }
}
