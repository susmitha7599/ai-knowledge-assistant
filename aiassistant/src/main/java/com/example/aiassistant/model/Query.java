package com.example.aiassistant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("queries")
public class Query {

    @Id
    private Long id;

    @Column("user_id")   // ✅ FIX
    private Long userId;

    private String prompt;

    private String response;

    public Query() {}

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getPrompt() { return prompt; }
    public String getResponse() { return response; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setPrompt(String prompt) { this.prompt = prompt; }
    public void setResponse(String response) { this.response = response; }
}