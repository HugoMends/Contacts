package com.contacts.ContactApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contacts.ContactApi.dto.ContactDTO;
import com.contacts.ContactApi.entities.Contact;
import com.contacts.ContactApi.repositories.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository repository;
	
	@Transactional(readOnly = true)
	public List<ContactDTO> findAll(ContactDTO dto){
		List<Contact> result = repository.findAll(); 
		return result.stream().map(x -> new ContactDTO(x)).toList();
	}
	
	@Transactional
	public ContactDTO insert(ContactDTO dto) {
		Contact cont = new Contact();
		cont.setName(dto.getName());
		cont.setEmail(dto.getEmail());
		cont.setPhone(dto.getPhone());
		repository.save(cont);
		return new ContactDTO(cont);
	}
}
