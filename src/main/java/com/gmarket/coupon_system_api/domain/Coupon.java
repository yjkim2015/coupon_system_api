package com.gmarket.coupon_system_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author : ykim14
 * @fileName : Coupoin
 * @since : 2024-09-21
 */

@Entity
public class Coupon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    public Coupon() {

    }

    public Coupon(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
