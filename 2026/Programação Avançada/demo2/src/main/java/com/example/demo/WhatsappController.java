package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/whatsapp/webhook")
public class WhatsappController {

    // 1. A Rota de Verificação da Meta (GET)
    @GetMapping
    public ResponseEntity<String> verifyWebhook(
            @RequestParam(name = "hub.mode", required = false) String mode,
            @RequestParam(name = "hub.verify_token", required = false) String token,
            @RequestParam(name = "hub.challenge", required = false) String challenge) {

        // A senha que vamos configurar lá no painel da Meta
        String VERIFY_TOKEN = "farmacia_secreto_123";

        if ("subscribe".equals(mode) && VERIFY_TOKEN.equals(token)) {
            System.out.println("✅ Webhook verificado com sucesso pela Meta!");
            return ResponseEntity.ok(challenge); // Tem que devolver o challenge puro
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    // 2. A Rota que vai capturar o Erro Silencioso (POST)
    @PostMapping
    public ResponseEntity<Void> receiveMessage(@RequestBody String payload) {
        System.out.println("🚨 PAYLOAD DA META RECEBIDO 🚨");
        System.out.println(payload); // Aqui estará o código de erro!
        return ResponseEntity.ok().build();
    }
}
