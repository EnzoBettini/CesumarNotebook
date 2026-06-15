package com.spring.security.models;


/*
 * Record utilizado para receber os dados de autenticação.
 *
 * O record é uma forma simplificada de criar classes
 * apenas para transporte de dados (DTO).
 *
 * Nesse caso ele representa:
 * - login do usuário
 * - senha do usuário
 *
 * Geralmente é utilizado no endpoint de login.
 *
 * Exemplo JSON recebido:
 * {
 *    "login": "admin",
 *    "password": "123456"
 * }
 *
 * O Java cria automaticamente:
 * - construtor
 * - getters
 * - toString()
 * - equals()
 * - hashCode()
 */

public record AuthenticationDTO(String login, String password) {
}
public record AuthenticationDTO(String login, String password) {
}
