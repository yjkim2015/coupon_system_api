package com.gmarket.consumer.consumer;

import com.gmarket.consumer.domain.Coupon;
import com.gmarket.consumer.domain.FailedEvent;
import com.gmarket.consumer.repository.CouponRepository;
import com.gmarket.consumer.repository.FailedEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author : ykim14
 * @fileName : CouponCreatedConsumer
 * @since : 2024-09-22
 */

@Component
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;

    private final FailedEventRepository failedEventRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CouponCreatedConsumer(CouponRepository couponRepository, FailedEventRepository failedEventRepository) {
        this.couponRepository = couponRepository;
        this.failedEventRepository = failedEventRepository;
    }

    @KafkaListener(topics = "coupon_create", groupId = "group_1")
    public void listener(Long userId) {
        try {
            couponRepository.save(new Coupon(userId));
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            //배치 필요
            failedEventRepository.save(new FailedEvent(userId));
        }
    }
}
