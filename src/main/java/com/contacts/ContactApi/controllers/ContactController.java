package com.contacts.ContactApi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.contacts.ContactApi.dto.ContactDTO;
import com.contacts.ContactApi.services.ContactService;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
	
	@Autowired
	private ContactService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContactDTO> findById(@PathVariable Long id) {
		ContactDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ContactDTO>> findAll(ContactDTO dto){
		List<ContactDTO> search = service.findAll(dto);
		return ResponseEntity.ok(search);
	}
	
	@PostMapping
	public ResponseEntity<ContactDTO> insert(@RequestBody ContactDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ContactDTO> update(@PathVariable Long id, @RequestBody ContactDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
}
