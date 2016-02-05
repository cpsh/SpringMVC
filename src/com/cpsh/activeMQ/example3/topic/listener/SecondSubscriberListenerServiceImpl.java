package com.cpsh.activeMQ.example3.topic.listener;

import java.util.Date;
import java.util.HashMap;

public class SecondSubscriberListenerServiceImpl implements
        SubscriberListenerService {

    @Override
    public void receive(HashMap message) {
        System.out.println("--订阅者二Listener收到消息：" + new Date(new Long((Long) message.get("count"))));
    }

}
