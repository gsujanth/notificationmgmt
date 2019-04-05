package com.rabbitmq.notifications.notificationmgmt.Sender;

import com.rabbitmq.notifications.notificationmgmt.Model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private static final String SUBJECT="Test Subject";

    @Autowired
    private Environment env;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(){
        final byte[] message = "{userId='isjfdij', userEmail='shfs@jj.com', userPhone='4837487845', userFirstName='rytyu', userLastName='gfg', userPassword='hfkfe'}".getBytes();
        template.convertAndSend(env.getProperty("spring.rabbitmq.api.directExchangeName"), env.getProperty("spring.rabbitmq.api.routingKey.user"), message);
    }

    public void sendMailNotification(Message message){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("dyyufgi@gmail.com");
            mailMessage.setFrom(env.getProperty("spring.mail.username"));
            mailMessage.setSubject("Test");
            mailMessage.setText("Hi Bro");
            // Java Mail API for sending the email.
            javaMailSender.send(mailMessage);
        } catch (Exception exception) {
            System.out.println("Exception has occured while sending the email...Exception class is " + exception);
        }
    }
}
