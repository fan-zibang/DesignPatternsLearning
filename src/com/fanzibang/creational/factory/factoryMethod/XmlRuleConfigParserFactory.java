package com.fanzibang.creational.factory.factoryMethod;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;
import com.fanzibang.creational.factory.parser.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory{

    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
