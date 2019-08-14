package com.example.xhandler;

public class XHandler {

    private XLooper looper;
    private XMessageQueue messageQuene;

    public XHandler() {
        this.looper = XLooper.myLooper();
        if (looper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        messageQuene = looper.messageQueue;

    }

    public void handleMessage(XMessage message) {

    }

    public void sendMessage(XMessage message) {
        //把消息放入消息队列
        enqueueMessage(message);
    }

    private void enqueueMessage(XMessage message) {
        //赋值当前消息
        message.target = this;

        //把消息传入
        messageQuene.enqueueMessage(message);
    }

    //处理消息
    public void dispatchMessage(XMessage message) {
        handleMessage(message);

    }
}
