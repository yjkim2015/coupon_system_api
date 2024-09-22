package com.gmarket.coupon_system_api.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author : ykim14
 * @fileName : CouponCreateProducer
 * @since : 2024-09-22
 */
@Component
public class CouponCreateProducer {
    private final KafkaTemplate<String, Long> kafkaTemplate;

    public CouponCreateProducer(KafkaTemplate<String, Long> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void create(Long userId) {
        kafkaTemplate.send("coupon_create", userId);
    }
}
