package com.gmarket.consumer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author : ykim14
 * @fileName : FailedEvent
 * @since : 2024-09-22
 */

@Entity
public class FailedEvent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    public FailedEvent() {}

    public FailedEvent(Long userId) {
        this.userId = userId;
    }
}
