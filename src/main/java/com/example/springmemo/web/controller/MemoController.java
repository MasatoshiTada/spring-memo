package com.example.springmemo.web.controller;

import com.example.springmemo.persistence.entity.Memo;
import com.example.springmemo.service.MemoService;
import com.example.springmemo.web.form.MemoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemoController {
    
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }
    
    @GetMapping("/")
    public String index(Model model) {
        List<Memo> memoList = memoService.findAll();
        model.addAttribute("memoList", memoList);
        return "index";
    }
    
    @PostMapping("/add")
    public String add(MemoForm memoForm) {
        Memo unregisteredMemo = memoForm.toEntity();
        memoService.add(unregisteredMemo);
        return "redirect:/";
    }
}
