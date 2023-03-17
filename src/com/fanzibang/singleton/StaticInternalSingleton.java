package com.fanzibang.singleton;

public class StaticInternalSingleton {

    private static class SingletonHolder {
            private static final StaticInternalSingleton instance = new StaticInternalSingleton();
    }

    public static StaticInternalSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
