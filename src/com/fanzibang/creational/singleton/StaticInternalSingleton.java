package com.fanzibang.creational.singleton;

public class StaticInternalSingleton {

    private static class SingletonHolder {
            private static final StaticInternalSingleton instance = new StaticInternalSingleton();
    }

    public static StaticInternalSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
