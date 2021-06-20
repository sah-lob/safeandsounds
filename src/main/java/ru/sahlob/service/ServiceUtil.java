package ru.sahlob.service;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServiceUtil {
    public static String getRandomUuid() {
        return UUID.randomUUID()
                .toString()
                .replaceAll("-", "");
    }

    public static String generatePassword() {
        var upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        var lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        var numbers = RandomStringUtils.randomNumeric(2);
        var specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        var totalChars = RandomStringUtils.randomAlphanumeric(2);
        var combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(specialChar)
                .concat(totalChars);
        var pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        var password = pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }


}
