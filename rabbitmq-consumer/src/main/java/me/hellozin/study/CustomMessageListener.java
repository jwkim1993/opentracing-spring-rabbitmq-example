package me.hellozin.study;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(final CustomMessage message) {
        System.out.println(message);
    }

    @RabbitListener(queues = "spring-boot-back")
    public CustomMessage receiveAndSendMessage(final CustomMessage message) {
        System.out.println(message);
        return message;
    }

}
