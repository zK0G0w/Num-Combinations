package org.example.numcombinations.dto;

public class ErrorResponseDTO {
    private String message;
    private String text;

    public ErrorResponseDTO(String message, String text) {
        this.message = message;
        this.text = text;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

