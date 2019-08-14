package com.example.xhandler;


public class XLooper {

    static final ThreadLocal<XLooper> sThreadLocal = new InheritableThreadLocal<>();

    XMessageQueue messageQueue;

    private XLooper() {
        messageQueue = new XMessageQueue();
    }

    public static void prepare() {

        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new XLooper());
    }

    public static XLooper myLooper() {
        return sThreadLocal.get();
    }

    //从ThreadLocalMap中获取唯一对象Looper
    public static void loop() {
        XLooper xLooper = myLooper();
        XMessageQueue messageQueue = xLooper.messageQueue;
        while (true) {
            XMessage message = messageQueue.next();
            if (message != null) {
                message.target.dispatchMessage(message);
            }
        }
    }
}
