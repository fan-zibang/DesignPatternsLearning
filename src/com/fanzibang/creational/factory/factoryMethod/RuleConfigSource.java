package com.fanzibang.creational.factory.factoryMethod;

import com.fanzibang.creational.factory.RuleConfig;
import com.fanzibang.creational.factory.parser.IRuleConfigParser;

/**
 * 从下面的代码实现来看，工厂类对象的创建逻辑又耦合进了 load() 函数中，
 * 跟我们简单工厂最初代码非常相似，引入工厂方法非但没有解决问题，反倒让设计变得更加复杂了。
 * 可以使用工厂类再创建一个简单工厂，用来创建工厂类的对象，请看 factoryMethod.RuleConfigSourceV2
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigPath) {
        String fileExtension = getFileExtension(ruleConfigPath);
        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(fileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        } else if("xml".equalsIgnoreCase(fileExtension)) {
            parserFactory = new XmlRuleConfigParserFactory();
        } else if("properties".equalsIgnoreCase(fileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            throw new RuntimeException("Rule config file is not supported");
        }
        IRuleConfigParser parser = parserFactory.createParser();
        // 从 ruleConfigFilePath 文件中读取配置到 configText 中，再由 parser 解析成 RuleConfig
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // 解析文件名并返回扩展名
        return "json";
    }
}
