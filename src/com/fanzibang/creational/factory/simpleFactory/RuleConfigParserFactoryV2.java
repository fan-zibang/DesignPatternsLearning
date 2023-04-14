package com.fanzibang.creational.factory.simpleFactory;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;
import com.fanzibang.creational.factory.parser.JsonRuleConfigParser;
import com.fanzibang.creational.factory.parser.PropertiesRuleConfigParser;
import com.fanzibang.creational.factory.parser.XmlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 优化：
 * 每次调用 RuleConfigParserFactory 的 createParser() 的时候，都要创建一个新的 parser。
 * 实际上，如果 parser 可以复用，为了节省内存和对象创建的时间，我们可以将 parser 事先创建好缓存起来。
 * 当调用 createParser() 函数的时候，我们从缓存中取出 parser 对象直接使用。
 *
 * 缺点：
 * 如果我们要添加新的 parser 时，需要改动 RuleConfigParserFactory 的代码，违反了开闭原则。
 * 实际上如果不是频繁地添加新的 parser，只是偶尔修改，稍微违反一下开闭原则也是可以接受的。
 */
public class RuleConfigParserFactoryV2 {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }

}
