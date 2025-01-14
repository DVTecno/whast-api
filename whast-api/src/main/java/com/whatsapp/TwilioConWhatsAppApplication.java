package com.whatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TwilioConWhatsAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(TwilioConWhatsAppApplication.class, args);
	}

//	public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
//	public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
//	public static final String WHATSAPP_NUMBER = System.getenv("TWILIO_WHATSAPP_NUMBER");
//	public static final String WHATSAPP_NUMBER_1 = System.getenv("CLIENT_WHATSAPP_NUMBER_1");
//	public static final String WHATSAPP_NUMBER_2 = System.getenv("CLIENT_WHATSAPP_NUMBER_2");
//
//	public static void main(String[] args) {
//		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//		List<String> phoneNumbers = Arrays.asList(
//				"whatsapp:"+WHATSAPP_NUMBER_1,
//				"whatsapp:"+WHATSAPP_NUMBER_2
//		);
//		String mensaje = "Hola, enviando este mensaje desde Java";
//
//		for (String phoneNumber : phoneNumbers) {
//			sendMessage(phoneNumber, mensaje);
//		}
//
//
////		Message message = Message.creator(
////						new PhoneNumber("whatsapp:"+WHATSAPP_NUMBER_1),
////						new PhoneNumber("whatsapp:"+WHATSAPP_NUMBER),
////						"Hola enviando desde java")
////				.create();
////
////		System.out.println(message.getSid());
//	}
//
//	private static void sendMessage(String to, String messageBody) {
//		try {
//			Message message = Message.creator(
//							new PhoneNumber(to),
//							new PhoneNumber("whatsapp:" + WHATSAPP_NUMBER),
//							messageBody)
//					.create();
//
//			System.out.println("Mensaje enviado a " + to + ". SID: " + message.getSid());
//		} catch (Exception e) {
//			System.err.println("Error enviando mensaje a " + to + ": " + e.getMessage());
//		}
//	}
}