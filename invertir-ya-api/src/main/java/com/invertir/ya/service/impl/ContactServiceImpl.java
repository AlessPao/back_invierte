package com.invertir.ya.service.impl;

import com.invertir.ya.model.Contact;
import com.invertir.ya.repo.IContactRepo;
import com.invertir.ya.repo.IGenericRepo;
import com.invertir.ya.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl extends CRUDImpl<Contact, Integer> implements IContactService
{
    private final IContactRepo repo;

    @Override
    protected IGenericRepo<Contact, Integer> getRepo() {
        return repo;
    }

    @Override
    public Contact save(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return super.save(contact);
    }
}
