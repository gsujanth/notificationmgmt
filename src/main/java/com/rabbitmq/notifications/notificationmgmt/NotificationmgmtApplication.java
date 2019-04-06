package com.rabbitmq.notifications.notificationmgmt;

import com.rabbitmq.notifications.notificationmgmt.Receiver.MessageReceiver;
import com.rabbitmq.notifications.notificationmgmt.Sender.MessageSender;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
//@RestController
public class NotificationmgmtApplication {

    @Autowired
    private Environment env;

    @Autowired
    private MessageSender messageSender;

    @Bean
    Queue queue() {
		return QueueBuilder.durable(env.getProperty("spring.rabbitmq.api.queueName.user")).build();
	}
	@Bean
    DirectExchange exchange() {
		return new DirectExchange(env.getProperty("spring.rabbitmq.api.directExchangeName"), true, false);
	}
	@Bean
    Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(env.getProperty("spring.rabbitmq.api.routingKey.user"));
	}

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(env.getProperty("spring.rabbitmq.api.queueName.user"));
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    //@Bean
    @GetMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(){
        messageSender.sendMessage();
        return "Message sent";
    }

    @GetMapping("/send")
    public String send(){
        return "send.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(NotificationmgmtApplication.class, args);
    }

}
