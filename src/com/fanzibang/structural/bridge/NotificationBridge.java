package com.fanzibang.structural.bridge;

public abstract class NotificationBridge {

    protected MsgSender msgSender;

    public NotificationBridge(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
