package com.org.myapp.domain.service.contactus;

import com.org.myapp.domain.model.ContactUsRequest;
import org.springframework.data.repository.CrudRepository;

public interface ContactUsDataStore extends CrudRepository<ContactUsRequest, String> {
}
