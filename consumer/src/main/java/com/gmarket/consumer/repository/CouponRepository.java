package com.gmarket.consumer.repository;

import com.gmarket.consumer.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ykim14
 * @fileName : CouponRepository
 * @since : 2024-09-21
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
