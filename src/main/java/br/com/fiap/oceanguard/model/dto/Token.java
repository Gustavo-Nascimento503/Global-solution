package br.com.fiap.oceanguard.model.dto;

public record Token(
    String token,
    String type,
    String prefix
) {} 
