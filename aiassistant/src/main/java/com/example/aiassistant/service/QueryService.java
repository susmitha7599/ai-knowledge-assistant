package com.example.aiassistant.service;

import com.example.aiassistant.model.Query;
import com.example.aiassistant.repository.QueryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QueryService {

    private final QueryRepository repository;
    private final AIService aiService;

    // ✅ constructor injection
    public QueryService(QueryRepository repository, AIService aiService) {
        this.repository = repository;
        this.aiService = aiService;
    }

    // ✅ NEW METHOD (this is what you're missing)
    public Mono<Query> saveWithAI(Query query) {
        return aiService.getAIResponse(query.getPrompt())
                .flatMap(response -> {
                    query.setResponse(response);
                    return repository.save(query);
                });
    }

    // existing method (keep if you want)
    public Flux<Query> getHistory(Long userId) {
        return repository.findByUserId(userId);
    }
}