package com.fanzibang.creational.builder;

/**
 * 解决V1：
 * 用 set() 函数来给成员变量赋值，以替代冗长的构造函数
 * name 是必填的，所以放到构造函数中强制创建类对象的时候填写
 * 其他配置项 maxTotal、maxIdle、minIdle 都不是必填的，所以我们通过 set() 函数来设置。
 *
 * 缺点：
 * 1.当必填项很多的时候也会造成构造函数参数列表很长的情况，如果把必填项也通过 set() 方法来设置，
 * 那校验这些必填项是否已经填写的逻辑就无处安放了。
 * 2.如果配置项之间有依赖关系，比如说用户设置了 maxTotal、maxIdle 和 minIdle 其中一个，
 * 就必须显式地设置另外两个，或者配置项之间有约束条件，maxIdle 和 minIdle 要小于等于 maxTotal
 * 那我们继续按照下面的思路编写代码，这种依赖关系和约束条件将无处安放。
 */
public class ResourcePoolConfigV2 {
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 8;
    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfigV2(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("name 不能为空");
        }
        this.name = name;
    }

    public void setMaxTotal(int maxTotal) {
        if (maxTotal < 0) {
            throw new RuntimeException("maxTotal 不能为负数");
        }
        this.maxTotal = maxTotal;
    }

    public void setMaxIdle(int maxIdle) {
        if (maxIdle < 0) {
            throw new RuntimeException("maxIdle 不能为负数");
        }
        this.maxIdle = maxIdle;
    }

    public void setMinIdle(int minIdle) {
        if (minIdle < 0) {
            throw new RuntimeException("minIdle 不能为负数");
        }
        this.minIdle = minIdle;
    }
}
