package com.matovic.redis.publisher;

import com.matovic.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
public class Publisher {

    @Autowired
    private RedisTemplate template;

    @Autowired
    private ChannelTopic topic;

    @PostMapping
    public String publishMessage(@RequestBody Product product) {
        template.convertAndSend(topic.getTopic(), product.toString());
        return "Product published!";
    }
}
