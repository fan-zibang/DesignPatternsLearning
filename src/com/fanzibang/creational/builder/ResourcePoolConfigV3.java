package com.fanzibang.creational.builder;

/**
 * 校验逻辑放置到 Builder 类中，先创建建造者，并且通过 set() 方法设置建造者的变量值，
 * 然后在使用 build() 方法真正创建对象之前，做集中的校验，校验通过之后才会创建对象。
 * 除此之外，我们把 ResourcePoolConfig 的构造函数改为 private 私有权限。这样我们就只能通过建造者来创建 ResourcePoolConfig 类对象。
 * 并且，ResourcePoolConfig 没有提供任何 set() 方法，这样我们创建出来的对象就是不可变对象了。
 *
 * 思考：和工厂模式有什么区别？
 */
public class ResourcePoolConfigV3 {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfigV3(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    //我们将 Builder 类设计成 ResourcePoolConfig 的内部类。
    //我们也可以将 Builder 类设计成独立的非内部类 ResourcePoolConfigBuilder。
    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 8;
        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfigV3 build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (name == null || name.equals("")) {
                throw new RuntimeException("name 不能为空");
            }
            if (maxIdle > maxTotal) {
                throw new RuntimeException("maxIdle 不能大于 maxTotal");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new RuntimeException("minIdle 不能大于 maxTotal 和 maxIdle");
            }
            return new ResourcePoolConfigV3(this);
        }

        public Builder setName(String name) {
            if (name == null || name.equals("")) {
                throw new RuntimeException("name 不能为空");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new RuntimeException("maxTotal 不能小于等于 0");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new RuntimeException("maxIdle 不能小于 0");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new RuntimeException("minIdle 不能小于 0");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

    public static void main(String[] args) {
        // 报错 maxIdle 不能大于 maxTotal
        ResourcePoolConfigV3 resourcePoolConfigV3 = new Builder().setName("abc")
                .setMaxTotal(10)
                .setMaxIdle(11)
                .setMinIdle(5)
                .build();
    }

}
