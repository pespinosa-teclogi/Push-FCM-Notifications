package com.testNoti.demo.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

@Service
public class NotificationService {

	private final FirebaseMessaging firebaseMessaging;

	public NotificationService(FirebaseMessaging firebaseMessaging) {
		this.firebaseMessaging = firebaseMessaging;
	}

	public void sendNotification(String token, String title, String body) {
		Message message = Message.builder().setToken(token).putData(title,body).build();

		String response = null;
		try {
			response = firebaseMessaging.send(message);
		} catch (FirebaseMessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully sent message: " + response);
	}
}
