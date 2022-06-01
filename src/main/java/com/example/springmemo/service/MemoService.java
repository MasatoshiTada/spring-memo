package com.example.springmemo.service;

import com.example.springmemo.persistence.entity.Memo;
import com.example.springmemo.persistence.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemoService {
    
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }
    
    @Transactional(readOnly = true)
    public List<Memo> findAll() {
        List<Memo> memoList = memoRepository.findAll();
        return memoList;
    }
    
    @Transactional(readOnly = false)
    public Memo add(Memo unregisteredMemo) {
        Memo registeredMemo = memoRepository.add(unregisteredMemo);
        return registeredMemo;
    }
}
