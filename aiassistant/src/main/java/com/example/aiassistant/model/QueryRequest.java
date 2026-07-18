package com.example.aiassistant.model;

public class QueryRequest {

    private Long userId;
    private String prompt;

    public QueryRequest() {}

    public Long getUserId() { return userId; }
    public String getPrompt() { return prompt; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setPrompt(String prompt) { this.prompt = prompt; }
}