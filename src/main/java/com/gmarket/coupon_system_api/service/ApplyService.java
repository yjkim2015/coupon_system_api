package com.gmarket.coupon_system_api.service;

import com.gmarket.coupon_system_api.domain.Coupon;
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

    public ApplyService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public void apply(Long userId) {
        long count = couponRepository.count();
        if (count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
