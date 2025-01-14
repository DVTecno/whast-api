package com.whatsapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {
    private final ServiceWhatsApp serviceWhatsApp;

    public WhatsAppController(ServiceWhatsApp serviceWhatsApp) {
        this.serviceWhatsApp = serviceWhatsApp;
    }

    @GetMapping("/send")
    public String send() {
        return serviceWhatsApp.sendMenssage();
    }
}
