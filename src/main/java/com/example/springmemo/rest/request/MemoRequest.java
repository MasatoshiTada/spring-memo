package com.example.springmemo.rest.request;

import com.example.springmemo.persistence.entity.Memo;

public record MemoRequest(String content) {
    
    public Memo toEntity() {
        return Memo.unregisteredMemo(this.content);
    }
}
