package com.kp.accountService.dto;

/**
 * A Java record representing the request body for the GenAI API call.
 * Records are immutable data classes that automatically generate a
 * canonical constructor, accessors for each component, and implementations
 * of `equals()`, `hashCode()`, and `toString()`.
 */
public record GenAIRequestDTO(String model, String prompt) {
}
