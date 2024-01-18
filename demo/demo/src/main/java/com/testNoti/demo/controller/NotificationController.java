package com.testNoti.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testNoti.demo.dto.NotificationRequest;
import com.testNoti.demo.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendNotification(@RequestBody NotificationRequest request) {
		try {
			notificationService.sendNotification(request.getToken(), request.getTitle(), request.getBody());
			return new ResponseEntity<>("Notification sent successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to send notification: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
