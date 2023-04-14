package com.fanzibang.creational.factory.factoryMethod;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;

/**
 * 当我们新增一种 parser 的时候，只需要新增一个实现了 IRuleConfigParserFactory 接口的 Factory 类即可
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();

}
