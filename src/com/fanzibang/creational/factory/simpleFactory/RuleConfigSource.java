package com.fanzibang.creational.factory.simpleFactory;

import com.fanzibang.creational.factory.parser.IRuleConfigParser;
import com.fanzibang.creational.factory.RuleConfig;

public class RuleConfigSource {

    public RuleConfig load(String fileConfigFilePath) {
        String fileExtension = getFileExtension(fileConfigFilePath);
        // 为了让类的职责更加单一、代码更加清晰，我们还可以进一步将 createParser() 函数剥离到一个独立的类中，让这个类只负责对象的创建。
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(fileExtension);
        if (parser == null) {
            throw new RuntimeException("Rule config file is not supported");
        }
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // 解析文件名并返回扩展名
        return "json";
    }
}
