package ru.sahlob.persistance.client;

import lombok.Data;
import ru.sahlob.security.MyUserPrincipal;

import java.security.Principal;

@Data
public class PersonalAccount {
    private boolean authorized;
    private String name;

    public PersonalAccount(Principal user) {
        if (user == null) {
            authorized = false;
        } else {
            authorized = true;
            name = user.getName();
        }
    }

    public PersonalAccount(MyUserPrincipal myUserPrincipal) {
        if (myUserPrincipal == null) {
            authorized = false;
        } else {
            authorized = true;
            name = myUserPrincipal.getUsername();
        }
    }
}
