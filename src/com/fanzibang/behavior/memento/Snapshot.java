package com.fanzibang.behavior.memento;

public class Snapshot {

    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
