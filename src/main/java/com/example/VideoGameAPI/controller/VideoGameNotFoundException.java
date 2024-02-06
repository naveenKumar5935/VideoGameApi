package com.example.VideoGameAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class VideoGameNotFoundException extends RuntimeException {
    public VideoGameNotFoundException(String message) {
        super(message);
    }
}
