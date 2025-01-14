package com.whatsapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {
    private final ServiceWhatsApp serviceWhatsApp;

    public WhatsAppController(ServiceWhatsApp serviceWhatsApp) {
        this.serviceWhatsApp = serviceWhatsApp;
    }

    @PostMapping("/send")
    public String send() {
        return serviceWhatsApp.sendMenssage();
    }
}
