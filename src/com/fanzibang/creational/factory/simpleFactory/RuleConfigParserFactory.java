package com.fanzibang.creational.factory.simpleFactory;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;
import com.fanzibang.creational.factory.parser.JsonRuleConfigParser;
import com.fanzibang.creational.factory.parser.PropertiesRuleConfigParser;
import com.fanzibang.creational.factory.parser.XmlRuleConfigParser;

/**
 * 简单工厂
 */
public class RuleConfigParserFactory {
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}
