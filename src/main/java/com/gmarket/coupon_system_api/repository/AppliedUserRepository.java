package com.gmarket.coupon_system_api.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : ykim14
 * @fileName : AppliedUserRepository
 * @since : 2024-09-22
 */

@Repository
public class AppliedUserRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public AppliedUserRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long add(Long userId) {
        return redisTemplate.opsForSet().add("applied_user", userId.toString());
    }
}
