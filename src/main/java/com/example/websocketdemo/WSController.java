package com.example.websocketdemo;

import com.example.websocketdemo.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {

    @Autowired
    private WSService wsService;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody Message message) {
        wsService.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable String id, @RequestBody Message message) {
        wsService.notifyFrontendUser(id, message.getMessageContent());
    }

}
