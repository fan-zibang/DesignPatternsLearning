package com.fanzibang.structural.bridge;

import java.util.List;

/**
 * API 接口监控告警：根据不同的告警规则，触发不同类型的告警。告警支持多种通知渠道，包括：邮件、短信、微信、自动语音电话。
 * 通知的紧急程度有多种类型，包括：SEVERE（严重）、URGENCY（紧急）、NORMAL（普通）、TRIVIAL（无关紧要）。
 * 不同的紧急程度对应不同的通知渠道。比如，SERVE（严重）级别的消息会通过“自动语音电话”告知相关人员。
 * <p>
 * 缺点：Notification 类里有很多 if-else 分支，实际上如果每个分支里的代码都不复杂并且后期没有无限膨胀的可能，这样的设计问题并不大，
 * 不一定要摒弃 if-else 逻辑，但是 Notification 中 if-else 的逻辑都比较复杂，发送通知的所有逻辑都扎堆在 Notification 中。
 * <p>
 * 解决思路：将不同渠道的发送逻辑剥离出来，写一个独立的消息发送类 MsgSender。Notification 相当于抽象，MsgSender 相当于实现，
 * 两者独立开发，通过组合关系，或者说是桥梁，任意组合在一起，不是在代码中固定写死，可以动态地去指定。
 */
public class Notification {
    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> wechatIds;

    public Notification() {}

    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddresses = emailAddress;
    }
    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }
    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }
    }

}
