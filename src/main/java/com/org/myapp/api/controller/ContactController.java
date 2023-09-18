package com.org.myapp.api.controller;

import com.org.myapp.api.model.ContactUsRequest;
import com.org.myapp.api.translator.ContactUsTranslator;
import com.org.myapp.domain.service.contactus.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/contactus")
public class ContactController {

    private ContactUsTranslator contactUsTranslator;
    private ContactUsService contactUsService;

    @Autowired
    public ContactController(ContactUsTranslator contactUsTranslator, ContactUsService contactUsService) {
        this.contactUsTranslator = contactUsTranslator;
        this.contactUsService = contactUsService;
    }

    // receive new contact us message
    @PostMapping
    @RequestMapping(value="/submit")
    public ResponseEntity submitNewContactUs(@RequestBody @Valid ContactUsRequest contactUsRequest){
        return ResponseEntity.ok(this.contactUsService.submitContactUsRequest(this.contactUsTranslator.toDomainModel(contactUsRequest)));
    }

}
