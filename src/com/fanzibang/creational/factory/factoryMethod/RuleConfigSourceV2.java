package com.fanzibang.creational.factory.factoryMethod;

import com.fanzibang.creational.factory.RuleConfig;
import com.fanzibang.creational.factory.parser.IRuleConfigParser;

public class RuleConfigSourceV2 {
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
