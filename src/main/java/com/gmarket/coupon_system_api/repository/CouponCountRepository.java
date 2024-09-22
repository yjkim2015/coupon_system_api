package com.gmarket.coupon_system_api.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : ykim14
 * @fileName : CouponCountRepository
 * @since : 2024-09-21
 */

@Repository
public class CouponCountRepository {
    private final RedisTemplate<String, String> redisTemplate;

    public CouponCountRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    void init() {
        this.redisTemplate.delete("coupon_count");
    }

    public Long increment() {
        return redisTemplate.opsForValue().increment("coupon_count");
    }
}
