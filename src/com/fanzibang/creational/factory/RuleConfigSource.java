package com.fanzibang.creational.factory;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;
import com.fanzibang.creational.factory.parser.JsonRuleConfigParser;
import com.fanzibang.creational.factory.parser.PropertiesRuleConfigParser;
import com.fanzibang.creational.factory.parser.XmlRuleConfigParser;

public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParser(fileExtension);
        if (parser == null) {
            throw new RuntimeException("Rule config file is not supported");
        }
        // 从 ruleConfigFilePath 文件中读取配置到 configText 中，再由 parser 解析成 RuleConfig
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // 解析文件名并返回扩展名
        return "json";
    }

    // 善于将功能独立的代码块封装成函数
    // 按照这个设计思路，我们可以将代码中涉及 parser 创建的部分逻辑剥离出来，抽象成 createParser() 函数
    private IRuleConfigParser createParser(String configFormat) {
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
