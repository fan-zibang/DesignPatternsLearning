package com.fanzibang.behavior.memento;

public class InputText {

    private StringBuilder text = new StringBuilder();

    public void append(String input) {
        text.append(input);
    }

    public String getText() {
        return text.toString();
    }

    public Snapshot createSnapshot() {
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}
