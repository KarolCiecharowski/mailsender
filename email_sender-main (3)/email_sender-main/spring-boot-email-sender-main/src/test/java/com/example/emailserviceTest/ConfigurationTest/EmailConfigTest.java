package com.example.emailserviceTest.ConfigurationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import emailservice.Configuration.EmailConfig;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailConfigTest {

    @Test
    public void testGetJavaMailSender() {
        EmailConfig emailConfig = new EmailConfig();
        JavaMailSender mailSender = emailConfig.getJavaMailSender();

        assertNotNull(mailSender);
        assertEquals("smtp.gmail.com", ((JavaMailSenderImpl)mailSender).getHost());
        assertEquals(587, ((JavaMailSenderImpl)mailSender).getPort());

        Properties props = ((JavaMailSenderImpl)mailSender).getJavaMailProperties();
        assertEquals("smtp", props.get("mail.transport.protocol"));
        assertEquals("true", props.get("mail.smtp.auth"));
        assertEquals("true", props.get("mail.smtp.starttls.enable"));
        assertEquals("true", props.get("mail.debug"));
    }
}