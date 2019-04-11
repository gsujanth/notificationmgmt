package com.rabbitmq.notifications.notificationmgmt;

import com.rabbitmq.notifications.notificationmgmt.Sender.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationmgmtApplicationTests {

	@Autowired
	MessageSender messageSender;

	@Test
	public void contextLoads() {
		assertThat(messageSender).isNotNull();
	}

}
