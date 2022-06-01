package com.example.springmemo.rest.response;

import com.example.springmemo.persistence.entity.Memo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record MemoResponse(Long id, String content, @JsonProperty("created_at") LocalDateTime createdAt) {
    
    public static MemoResponse fromEntity(Memo memo) {
        return new MemoResponse(memo.id(), memo.content(), memo.createdAt());
    }
}
