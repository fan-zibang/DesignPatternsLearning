package com.fanzibang.structural.adapter;

// 对象适配器：基于组合
public class AdaptorBaseObject implements ITarget{

    private Adaptee adaptee;

    public AdaptorBaseObject(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        // 委托给 Adaptee
        adaptee.fa();
    }

    @Override
    public void f2() {
        //...重新实现f2()...
    }

    @Override
    public void f3() {
        adaptee.fc();
    }
}
