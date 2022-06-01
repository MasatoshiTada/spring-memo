package com.example.springmemo.web.form;

import com.example.springmemo.persistence.entity.Memo;

public record MemoForm(String content) {
    
    public Memo toEntity() {
        return Memo.unregisteredMemo(this.content);
    }
}
