package com.whatsapp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.whatsapp.models.Contacts;
import com.whatsapp.models.Messages;

import java.util.List;

@JsonPropertyOrder({"messaging_product", "contacts", "messages"})
public record ResponseWhatsApp(String messaging_product, List<Contacts> contacts, List<Messages> messages) {
}
