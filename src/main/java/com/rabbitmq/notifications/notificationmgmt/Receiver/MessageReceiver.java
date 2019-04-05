package com.rabbitmq.notifications.notificationmgmt.Receiver;

import com.google.gson.Gson;
import com.rabbitmq.notifications.notificationmgmt.Model.Message;
import com.rabbitmq.notifications.notificationmgmt.Sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @Autowired
    private MessageSender messageSender;

    public void receiveMessage(byte[] receivedMessage) {
        System.out.println("Consumed Message <" + receivedMessage.toString() + ">");
        // Need to parse the received message as a JSON object using GSON library.
        final Gson gson = new Gson();
        final Message message = gson.fromJson(new String(receivedMessage), Message.class);
        System.out.println("JSON Received <" + message + ">");
        //messageSender.sendMessage();
        messageSender.sendMailNotification(message);
    }
}
