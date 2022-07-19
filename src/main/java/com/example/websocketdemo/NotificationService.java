package com.example.websocketdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void sendGlobalNotification() {
        ResponseMessage message = new ResponseMessage("Global Notification");

        simpMessagingTemplate.convertAndSend("/topic/global-notifications", message);
    }

    public void sendPrivateNotification(final String userId) {
        ResponseMessage message = new ResponseMessage("Private Notification");

        simpMessagingTemplate.convertAndSendToUser(userId,"/topic/private-notifications", message);
    }
}
