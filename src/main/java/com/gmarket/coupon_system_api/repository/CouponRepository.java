package com.gmarket.coupon_system_api.repository;

import com.gmarket.coupon_system_api.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ykim14
 * @fileName : CouponRepository
 * @since : 2024-09-21
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
