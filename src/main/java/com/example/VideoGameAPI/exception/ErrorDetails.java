package com.example.VideoGameAPI.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime time,String message, String details) {
}
