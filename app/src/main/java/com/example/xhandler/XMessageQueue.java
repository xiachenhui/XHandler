package com.example.xhandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class XMessageQueue {
    //阻塞消息队列
    BlockingQueue<XMessage> blockingQueue = new ArrayBlockingQueue<>(50);

    public void enqueueMessage(XMessage message) {
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //获取消息对象
    public XMessage next() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
