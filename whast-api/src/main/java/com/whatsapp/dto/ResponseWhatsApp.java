package com.whatsapp.dto;

import com.whatsapp.Messages;

import java.util.List;

public record ResponseWhatsApp(String messaging_product, List<Contacts> contacts, List<Messages> messages) {
}
