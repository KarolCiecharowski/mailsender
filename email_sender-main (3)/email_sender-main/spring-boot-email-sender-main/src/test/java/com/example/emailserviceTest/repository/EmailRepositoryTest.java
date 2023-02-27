package com.example.emailserviceTest.repository;

import emailservice.repository.EmailRepository;
import emailservice.model.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class EmailRepositoryTest {

    @Autowired
    private EmailRepository emailRepository;

    @Test
    public void testFindByEmail() {
        // arrange
        Email email = new Email();
        email.setEmail("test@example.com");
        email.setSubject("Test subject");
        email.setText("Test text");
        emailRepository.save(email);

        // act
        Optional<Email> result = emailRepository.findByEmail("test@example.com");

        // assert
        assertTrue(result.isPresent());
        assertEquals("Test subject", result.get().getSubject());
        assertEquals("Test text", result.get().getText());
    }
}