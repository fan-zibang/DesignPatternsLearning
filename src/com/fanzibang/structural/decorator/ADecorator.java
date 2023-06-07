package com.fanzibang.structural.decorator;

/**
 * 代理模式的代码结构和装饰器模式的代码很相似，但是意图不同。
 * 在代理模式中，代理类附加的是跟原始类无关的功能，而在装饰器模式中，装饰器类附加的是跟原始类相关的增强功能。
 */
public class ADecorator implements IA{

    private IA a;

    public ADecorator(IA a) {
        this.a = a;
    }

    @Override
    public void f() {
        // 功能增强代码
        a.f();
        // 功能增强代码
    }
}
