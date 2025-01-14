package com.whatsapp;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class ServiceWhatsApp {
    private final RestClient restClient;
    public static final String WHATSAPP_NUMBER = System.getenv("META_WHATSAPP_NUMBER");
    public static final String WHATSAPP_NUMBER_2 = System.getenv("CLIENT_WHATSAPP_NUMBER_2");

    public ServiceWhatsApp() {
        String url = "https://graph.facebook.com/v21.0/META_WHATSAPP_NUMBER/messages";
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer "+System.getenv("META_WHATSAPP_TOKEN"))
                .build();
    }

    public String sendMenssage() {
        RequestMessage requestMessage = new RequestMessage("whatsapp", WHATSAPP_NUMBER, new RequestMessageText("Hola, enviando este mensaje desde Java"));
        try {
            return restClient.post()
                    .uri("")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestMessage)
                    .retrieve()
                    .body(String.class);
        }catch (RestClientException e) {
            System.err.println("Error enviando mensaje a " + WHATSAPP_NUMBER + ": " + e.getMessage());
        }
        return null;
    }

}
