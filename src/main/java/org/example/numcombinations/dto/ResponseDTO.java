package org.example.numcombinations.dto;

import java.util.List;

public class ResponseDTO {
    private String message;
    private String text;
    private List<String> data;

    public ResponseDTO(String message, String text, List<String> data) {
        this.message = message;
        this.text = text;
        this.data = data;
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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
