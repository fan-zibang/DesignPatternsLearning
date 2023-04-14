package com.fanzibang.creational.factory.factoryMethod;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;
import com.fanzibang.creational.factory.parser.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
