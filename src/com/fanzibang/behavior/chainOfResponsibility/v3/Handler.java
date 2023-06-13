package com.fanzibang.behavior.chainOfResponsibility.v3;

public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler handler) {
        this.successor = successor;
    }

    public final void handle() {
        doHandle();
        if (successor != null) {
            successor.handle();
        }
    }

    protected abstract void doHandle();
}
