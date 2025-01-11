package com.whatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioConWhatsAppApplication {

	public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	public static final String WHATSAPP_NUMBER = System.getenv("TWILIO_WHATSAPP_NUMBER");

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
						new PhoneNumber("whatsapp:+5491162125286"),
						new PhoneNumber("whatsapp:"+WHATSAPP_NUMBER),
						"Hola enviando desde java")
				.create();

		System.out.println(message.getSid());
	}
}