package com.kp.accountService.controller;

import com.kp.accountService.dto.GenAIRequestDTO;
import com.kp.accountService.dto.GenAIResponseDTO;
import com.kp.accountService.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GenAIController {

    private final GeminiService geminiService;

    @PostMapping("/generate")
    public ResponseEntity<GenAIResponseDTO> generateContent(@RequestBody GenAIRequestDTO genAIRequestDTO) {
        var genAIResponseDTO = geminiService.generateContent(genAIRequestDTO);
        return ResponseEntity.ok(genAIResponseDTO);
    }
}