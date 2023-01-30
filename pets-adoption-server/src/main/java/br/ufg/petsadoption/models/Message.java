package br.ufg.petsadoption.models;

import java.time.LocalDateTime;

public record Message(int statusCode, String message, LocalDateTime timestamp) {
}
