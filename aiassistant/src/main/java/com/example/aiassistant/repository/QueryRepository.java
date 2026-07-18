package com.example.aiassistant.repository;

import com.example.aiassistant.model.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface QueryRepository extends ReactiveCrudRepository<Query, Long> {
    Flux<Query> findByUserId(Long userId);
}