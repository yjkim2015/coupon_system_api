package com.gmarket.coupon_system_api.service;

import com.gmarket.coupon_system_api.domain.Coupon;
import com.gmarket.coupon_system_api.producer.CouponCreateProducer;
import com.gmarket.coupon_system_api.repository.CouponCountRepository;
import com.gmarket.coupon_system_api.repository.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author : ykim14
 * @fileName : ApplyService
 * @since : 2024-09-21
 */

@Service
public class ApplyService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;

    private final CouponCreateProducer couponCreateProducer;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository, CouponCreateProducer couponCreateProducer) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
    }

    public void apply(Long userId) {

        //long count = couponRepository.count();
        Long count = couponCountRepository.increment();
        logger.error("{}", count);
        if (count > 100) {
            return;
        }

        couponCreateProducer.create(userId);
    }
}
