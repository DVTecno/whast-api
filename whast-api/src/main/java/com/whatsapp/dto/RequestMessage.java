package com.whatsapp;

public record RequestMessage(String messaging_product, String messaging_type, String to, RequestMessageText text) {
    public RequestMessage(String messaging_type, String to, RequestMessageText text) {
        this("whatsapp", messaging_type, to, text);
    }
}
