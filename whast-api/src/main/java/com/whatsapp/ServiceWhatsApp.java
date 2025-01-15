package com.whatsapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.dto.MessaBodyDTO;
import com.whatsapp.dto.ResponseWhatsApp;
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
        String url = "https://graph.facebook.com/v21.0/"+WHATSAPP_NUMBER+"/messages";
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer EAAok5pnEqKsBOx6Dw8ySsUKZCG9r8YjWCdY4Byy6ibKPdwvxva9R9g0ref2n1aq8Nh1umQX4WxcuPlUdygG01yljySCyMZB2rNlx1UlLy8hjgdgdk4UXxdWYsDZBTfIjFFY6G6CZBu7Fpl59huGRQICQGgWYoZAf7NyUEk2nSOz3wcSdCko2BDqYZAxAwZAznkFDP8IUZBML1S4PjyzmxB50fDve3trU")
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

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response, ResponseWhatsApp.class);
        }catch (RestClientException e) {
            System.err.println("Error enviando mensaje a "+payload.number() +": "+ e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
