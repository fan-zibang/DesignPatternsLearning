package com.fanzibang.creational.factory.parser;

import com.fanzibang.creational.factory.RuleConfig;

public interface IRuleConfigParser {

    RuleConfig parse(String text);
}
