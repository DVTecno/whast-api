package com.whatsapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.dto.RequestMessage;
import com.whatsapp.dto.RequestMessageText;
import com.whatsapp.dto.MessaBodyDTO;
import com.whatsapp.dto.ResponseWhatsApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class ServiceWhatsApp {

    private final RestClient restClient;

    public ServiceWhatsApp(@Value("${whatsapp.token}") String token,
                           @Value("${META_WHATSAPP_NUMBER}") String whatsappNumber) {
        String url = String.format("https://graph.facebook.com/v21.0/%s/messages", whatsappNumber);
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer " + token)
                .build();
    }

    public ResponseWhatsApp sendMenssage(MessaBodyDTO payload) {
        RequestMessage requestMessage = new RequestMessage("whatsapp", payload.number(), new RequestMessageText(payload.message()));
        try {
            String response = restClient.post()
                    .uri("")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestMessage)
                    .retrieve()
                    .body(String.class);

            return new ObjectMapper().readValue(response, ResponseWhatsApp.class);
        } catch (RestClientException e) {
            logError("Error sending message to " + payload.number(), e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        }
        return null;
    }

    private void logError(String message, Exception exception) {
        System.err.println(message + ": " + exception.getMessage());
    }
}
