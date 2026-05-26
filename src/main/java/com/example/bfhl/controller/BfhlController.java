package com.example.bfhl.controller;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import com.example.bfhl.service.BfhlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BfhlController {

    private final BfhlService bfhlService;

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @PostMapping("/bfhl")
    public ResponseDto process(
            @RequestBody RequestDto requestDto
    ) {

        return bfhlService.process(requestDto);
    }
}