package com.whatsapp;

public record RequestMessage(String messaging_type, String to, RequestMessageText text) {
}
