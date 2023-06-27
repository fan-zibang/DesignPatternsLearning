package com.fanzibang.behavior.memento;

import java.util.Stack;

public class SnapshotHolder {

    private Stack<Snapshot> stack = new Stack<>();

    public Snapshot popSnapshot() {
        return stack.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        stack.push(snapshot);
    }
}
