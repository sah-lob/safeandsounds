package ru.sahlob.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ServiceUtilTest {

    @Test
    public void whenCreatePassword() {
        String password = ServiceUtil.generatePassword();

        assertTrue(true);
    }

}