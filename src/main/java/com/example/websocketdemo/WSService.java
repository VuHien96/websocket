package com.example.websocketdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WSService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private NotificationService notificationService;

    public void notifyFrontend(String message) {
        ResponseMessage response = new ResponseMessage(message);
        notificationService.sendGlobalNotification();
        simpMessagingTemplate.convertAndSend("/topic/messages", response);
    }

    public void notifyFrontendUser(String id, String message) {
        ResponseMessage response = new ResponseMessage(message);
        notificationService.sendPrivateNotification(id);
        simpMessagingTemplate.convertAndSendToUser(id, "/topic/private-messages", response);
    }
}
