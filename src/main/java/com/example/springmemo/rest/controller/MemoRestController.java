package com.example.springmemo.rest.controller;

import com.example.springmemo.persistence.entity.Memo;
import com.example.springmemo.rest.request.MemoRequest;
import com.example.springmemo.rest.response.MemoResponse;
import com.example.springmemo.service.MemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/memos")
public class MemoRestController {
    
    private final MemoService memoService;

    public MemoRestController(MemoService memoService) {
        this.memoService = memoService;
    }
    
    @GetMapping
    public List<MemoResponse> findAll() {
        List<Memo> memoList = memoService.findAll();
        List<MemoResponse> memoResponseList = memoList.stream()
                .map(memo -> MemoResponse.fromEntity(memo))
                .toList();
        return memoResponseList;
    }
    
    @PostMapping
    public ResponseEntity<?> add(@RequestBody MemoRequest memoRequest) {
        Memo unregisteredMemo = memoRequest.toEntity();
        Memo registeredMemo = memoService.add(unregisteredMemo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment(registeredMemo.id().toString())
                .build().encode().toUri();
        return ResponseEntity.created(location).build();
    }
}
