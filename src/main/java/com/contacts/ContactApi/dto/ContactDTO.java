package com.contacts.ContactApi.dto;

import com.contacts.ContactApi.entities.Contact;

import lombok.Data;

@Data
public class ContactDTO {
	
	private Long id;
	private String name;
	private String emai;
	private String phone;
	
	public ContactDTO() {}

	public ContactDTO(Long id, String name, String emai, String phone) {
		this.id = id;
		this.name = name;
		this.emai = emai;
		this.phone = phone;
	}

	public ContactDTO(Contact contact) {
		id = contact.getId();
		name = contact.getName();
		emai = contact.getEmail();
		phone = contact.getPhone();
	}
	
	
	
}
