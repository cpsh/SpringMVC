package com.cpsh.activeMQ.example3.topic.listener;

import java.util.HashMap;

public interface SubscriberListenerService {
    public void receive(HashMap message);
}
