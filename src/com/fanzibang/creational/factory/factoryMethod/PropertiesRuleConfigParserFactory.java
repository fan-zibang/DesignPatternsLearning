package com.fanzibang.creational.factory.factoryMethod;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;
import com.fanzibang.creational.factory.parser.PropertiesRuleConfigParser;

public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory{

    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
