package com.example.emailserviceTest.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import emailservice.model.User;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testGetId() {
        User user = new User();
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void testGetEmail() {
        User user = new User();
        String email = "test@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testSetEmail() {
        User user = new User();
        String email = "test@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

}