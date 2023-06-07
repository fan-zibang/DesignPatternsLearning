package com.fanzibang.structural.facade;

public class XFacade {

    public void x() {
        A a = new A();
        B b = new B();
        C c = new C();
        a.a();
        b.b();
        c.c();
    }
}
