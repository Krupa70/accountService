package com.kp.accountService.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "gemini")
public class GeminiProperties {
    private Api api;
    private Model model;

    @Data
    public static class Api {
        private String key;
    }

    @Data
    public static class Model {
        private String name;
    }
}

