package com.contacts.ContactApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.contacts.ContactApi.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService service;
	
	
}
