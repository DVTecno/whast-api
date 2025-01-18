package com.whatsapp.controller;

import com.whatsapp.service.ServiceWhatsApp;
import com.whatsapp.dto.MessaBodyDTO;
import com.whatsapp.dto.ResponseWhatsApp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseWhatsApp send(@RequestBody MessaBodyDTO payload) {
        return serviceWhatsApp.sendMenssage(payload);
    }
}
