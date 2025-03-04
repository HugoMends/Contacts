package com.contacts.ContactApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.ContactApi.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
