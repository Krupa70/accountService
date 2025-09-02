package com.kp.accountService.service;

import ch.qos.logback.core.util.StringUtil;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.kp.accountService.dto.GenAIRequestDTO;
import com.kp.accountService.dto.GenAIResponseDTO;
import com.kp.accountService.util.GeminiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor // <--- LOMBOK ANNOTATION ADDED HERE
public class GeminiService {

    private final GeminiProperties geminiProperties;

    public GenAIResponseDTO generateContent(GenAIRequestDTO genAIRequestDTO) {
        log.info("Attempting to generate content using model: {}",
                geminiProperties.getModel().getName());

        try {
            GenerateContentResponse response;
            var geminiAPiKey = geminiProperties.getApi().getKey();
            var modelName = StringUtil.isNullOrEmpty(genAIRequestDTO.model()) ?
                    geminiProperties.getModel().getName()
                    : genAIRequestDTO.model();
            try (Client client = Client.builder()
                    .apiKey(geminiAPiKey).build()) {
              /*  response = client.models.generateContent(
                        "gemini-2.5-flash",
                        "Explain how AI works in a few words",
                        null);*/
                response = client.models.generateContent(
                        modelName,
                        genAIRequestDTO.prompt(),
                        null);
            }

            String generatedText = response.text();
            log.info("Successfully received response from Gemini {}", generatedText);
            return GenAIResponseDTO.builder().text(generatedText).build();
        } catch (Exception e) {
            log.error("Error generating content from Gemini API: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to call Gemini API", e);
        }
    }
}
