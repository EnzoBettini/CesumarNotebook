package com.spring.security.enums;

/*
 * Enum responsável por representar os tipos de perfil
 * (roles/permissões) dos usuários do sistema.
 *
 * ENUM:
 * É um tipo especial usado para armazenar valores fixos
 * e constantes.
 *
 * Nesse sistema existem dois perfis:
 *
 * ADMIN
 * - possui permissões administrativas
 * - pode acessar rotas restritas
 *
 * USER
 * - usuário comum do sistema
 * - possui acesso limitado
 *
 * O Spring Security utiliza essas roles
 * para controlar permissões das rotas.
 *
 * Exemplo:
 * .hasRole("ADMIN")
 *
 * Isso significa que apenas usuários
 * com perfil ADMIN poderão acessar a rota.
 */

public enum UserRole {

    // Perfil administrador
    ADMIN,

    // Perfil usuário comum
    USER;
}