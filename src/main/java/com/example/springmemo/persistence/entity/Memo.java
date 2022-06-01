package com.example.springmemo.persistence.entity;

import java.time.LocalDateTime;

public record Memo(Long id, String content, LocalDateTime createdAt) {
    
    public static Memo unregisteredMemo(String content) {
        return new Memo(null, content, null);
    }
    
    public Memo withNewId(Long newId) {
        return new Memo(newId, this.content, this.createdAt);
    }
}
