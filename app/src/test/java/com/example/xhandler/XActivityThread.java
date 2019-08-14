package com.example.xhandler;

import org.junit.Test;

public class XActivityThread {
    @Test
    public void main() {
        System.out.println("aaa");
        //创建全局唯一的主线程Looper对象
        XLooper.prepare();

        //创建Handler
        final XHandler handler = new XHandler() {
            @Override
            public void handleMessage(XMessage message) {
                super.handleMessage(message);
                System.out.println(message.obj.toString());
            }
        };

        //发送消息
        new Thread(new Runnable() {
            @Override
            public void run() {
                XMessage message = new XMessage();
                message.what = 1;
                message.obj = "晚上好";
                handler.sendMessage(message);

            }
        }).start();

        //获取消息
        XLooper.loop();


    }


}
