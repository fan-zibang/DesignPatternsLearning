package com.fanzibang.behavior.chainOfResponsibility.v1;

public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler handler) {
        this.successor = successor;
    }

    public abstract boolean doHandle();
}
