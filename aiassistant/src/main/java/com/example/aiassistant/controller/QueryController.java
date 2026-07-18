package com.example.aiassistant.controller;

import com.example.aiassistant.model.Query;
import com.example.aiassistant.model.QueryRequest;
import com.example.aiassistant.service.QueryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")

public class QueryController {

     private final QueryService service;

    public QueryController(QueryService service) {
        this.service = service;
    }


    @GetMapping("/history/{userId}")
    public Flux<Query> getHistory(@PathVariable Long userId) {
        return service.getHistory(userId);
    }
    
    @PostMapping("/query")
public Mono<Query> saveQuery(@RequestBody QueryRequest request) {

    Query query = new Query();
    query.setUserId(request.getUserId());
    query.setPrompt(request.getPrompt());

    return service.saveWithAI(query);
}

}
