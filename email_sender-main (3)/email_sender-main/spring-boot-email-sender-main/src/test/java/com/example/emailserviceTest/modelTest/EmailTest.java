package com.example.emailserviceTest.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import emailservice.model.Email;

@SpringBootTest
public class EmailTest {

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        Email email = new Email();
        email.setId(id);
        assertEquals(id, email.getId());
    }

    @Test
    public void testSetAndGetSubject() {
        String subject = "Test Subject";
        Email email = new Email();
        email.setSubject(subject);
        assertEquals(subject, email.getSubject());
    }

    @Test
    public void testSetAndGetText() {
        String text = "Test Text";
        Email email = new Email();
        email.setText(text);
        assertEquals(text, email.getText());
    }

    @Test
    public void testSetAndGetEmail() {
        String emailStr = "test@example.com";
        Email email = new Email();
        email.setEmail(emailStr);
        assertEquals(emailStr, email.getEmail());
    }

    @Test
    public void testConstructor() {
        Long id = 1L;
        String subject = "Test Subject";
        String text = "Test Text";
        String emailStr = "test@example.com";
        Email email = new Email(id, subject, text, emailStr);
        assertEquals(id, email.getId());
        assertEquals(subject, email.getSubject());
        assertEquals(text, email.getText());
        assertEquals(emailStr, email.getEmail());
    }
}
