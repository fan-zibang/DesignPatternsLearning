package com.fanzibang.creational.builder;

/**
 * 缺点：
 * 在下面的代码中，我们可以看到，ResourcePoolConfig 有四个配置项，对应到构造函数中就是 4 个参数，
 * 还不算多，但是如果配置项逐渐增多，变成了 8 个、10 个甚至更多，那继续使用下面的设计思路，
 * 构造函数的参数列表将会很长，代码可读性和易用性都会变差。
 */
public class ResourcePoolConfigV1 {

    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 8;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfigV1(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("name 不能为空");
        }
        this.name = name;

        if (maxTotal != null) {
            if (maxTotal < 0) {
                throw new RuntimeException("maxTotal 不能为负数");
            }
        }
        this.maxTotal = maxTotal;

        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new RuntimeException("maxIdle 不能为负数");
            }
        }
        this.maxIdle = maxIdle;

        if (minIdle != null) {
            if (minIdle < 0) {
                throw new RuntimeException("minIdle 不能为负数");
            }
        }
        this.minIdle = minIdle;
    }
}
