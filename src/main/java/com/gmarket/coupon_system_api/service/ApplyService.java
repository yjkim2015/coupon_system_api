package com.gmarket.coupon_system_api.service;

import com.gmarket.coupon_system_api.domain.Coupon;
import com.gmarket.coupon_system_api.repository.CouponCountRepository;
import com.gmarket.coupon_system_api.repository.CouponRepository;
import org.springframework.stereotype.Service;

/**
 * @author : ykim14
 * @fileName : ApplyService
 * @since : 2024-09-21
 */

@Service
public class ApplyService {

    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }

    public void apply(Long userId) {

        //long count = couponRepository.count();
        Long count = couponCountRepository.increment();
        if (count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
