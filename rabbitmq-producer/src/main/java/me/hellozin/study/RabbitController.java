package me.hellozin.study;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RabbitController {

    private final String topicExchange = "spring-boot-exchange";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public CustomMessage sendMsg() {
        System.out.println("Sending message...");
        CustomMessage message = new CustomMessage("Hello Message!", 1, true);
        rabbitTemplate.convertAndSend(topicExchange, "foo.bar.baz", message);

	return message;
    }
}
