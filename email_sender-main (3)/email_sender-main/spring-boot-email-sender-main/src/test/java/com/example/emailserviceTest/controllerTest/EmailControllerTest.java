package com.example.emailserviceTest.controllerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import emailservice.controller.EmailController;
import emailservice.model.Email;
import emailservice.repository.EmailRepository;

public class EmailControllerTest {

    @Test
    public void testGetAllEmails() {
        //given
        EmailRepository emailRepository = mock(EmailRepository.class);
        when(emailRepository.findAll()).thenReturn(createTestEmails());

        EmailController emailController = new EmailController(emailRepository, null, null);

        //when
        List<Email> emails = emailController.getAllEmails();

        //then
        assert(!emails.isEmpty());
    }




    private List<Email> createTestEmails() {
        List<Email> emails = new ArrayList<>();
        Email email1 = new Email();
        email1.setId(1L);
        email1.setSubject("Test email 1");
        email1.setText("This is a test email 1.");
        Email email2 = new Email();
        email2.setId(2L);
        email2.setSubject("Test email 2");
        email2.setText("This is a test email 2.");
        emails.add(email1);
        emails.add(email2);
        return emails;
    }
}