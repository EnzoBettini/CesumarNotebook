package com.spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.print.DocFlavor;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        /*
         * Método responsável por configurar a segurança da aplicação.
         *
         * Aqui definimos:
         * - quais rotas podem ser acessadas sem login
         * - quais precisam de autenticação
         * - quais exigem permissões específicas
         * - como será o gerenciamento de sessão
         */

        return httpSecurity

                /*
                 * Desabilita a proteção CSRF.
                 *
                 * Em APIs REST com JWT normalmente o CSRF é desativado,
                 * pois a autenticação acontece através de token.
                 */
                .csrf(csrf -> csrf.disable())

                /*
                 * Define que a aplicação será STATELESS.
                 *
                 * Isso significa:
                 * - o servidor não guarda sessão do usuário
                 * - cada requisição precisa enviar o token novamente
                 * - muito utilizado com JWT
                 */
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                /*
                 * Configuração das permissões das rotas.
                 */
                .authorizeHttpRequests(authorize -> authorize

                        /*
                         * Permite que qualquer usuário acesse
                         * a rota de login sem autenticação.
                         */
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()

                        /*
                         * Permite cadastro de usuário sem login.
                         */
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                        /*
                         * Apenas usuários com perfil ADMIN
                         * podem acessar essa rota.
                         */
                        .requestMatchers(HttpMethod.POST, "/pessoas").hasRole("ADMIN")

                        /*
                         * Qualquer outra rota exige autenticação.
                         */
                        .anyRequest().authenticated()
                )

                /*
                 * Finaliza a configuração da segurança
                 * e cria o filtro de segurança da aplicação.
                 */
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {

        /*
         * Bean responsável por fornecer o AuthenticationManager.
         *
         * O AuthenticationManager é o componente do Spring Security
         * responsável por realizar o processo de autenticação.
         *
         * Ele verifica:
         * - usuário
         * - senha
         * - permissões
         *
         * Esse objeto geralmente é utilizado no login
         * para validar as credenciais do usuário.
         */

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        /*
         * Bean responsável por criptografar senhas.
         *
         * BCryptPasswordEncoder utiliza o algoritmo BCrypt,
         * um dos mais seguros para armazenamento de senhas.
         *
         * A senha NÃO fica salva em texto puro no banco.
         *
         * Exemplo:
         * Senha digitada:
         * 123456
         *
         * Senha salva:
         * $2a$10$A8sd9asd...
         *
         * Também é utilizado para comparar a senha digitada
         * com a senha criptografada armazenada no banco.
         */

        return new BCryptPasswordEncoder();
    }

}
