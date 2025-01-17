package com.whatsapp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"body"})
public record RequestMessageText(String body) {
}
