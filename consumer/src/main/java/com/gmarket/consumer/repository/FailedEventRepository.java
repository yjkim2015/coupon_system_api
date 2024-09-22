package com.gmarket.consumer.repository;

import com.gmarket.consumer.domain.FailedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ykim14
 * @fileName : FailedEventRepository
 * @since : 2024-09-22
 */
public interface FailedEventRepository extends JpaRepository<FailedEvent, Long> {
}
