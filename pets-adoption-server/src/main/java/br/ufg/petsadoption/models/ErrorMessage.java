package br.ufg.petsadoption.models;

import java.time.LocalDateTime;

public record ErrorMessage(int statusCode, String message, String description, LocalDateTime timestamp) {
}
