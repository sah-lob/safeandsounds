package ru.sahlob.persistance.client;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.security.MyUserPrincipal;

import java.security.Principal;

@Data
public class PersonalAccount {
    public static final String ATTRIBUTE_NAME = "personalAccount";
    private boolean authorized;
    private String name;
    private Client client;

    public PersonalAccount(Principal user, DBUsersStorage dbUsersStorage) {
        if (user == null) {
            authorized = false;
        } else {
            authorized = true;
            client = dbUsersStorage.getClientByPhoneOrEmail(user.getName());
            name = client.getFirstName();
        }
    }

    public PersonalAccount(Authentication authentication, DBUsersStorage dbUsersStorage) {
        String userName = null;
        if (authentication.getPrincipal() instanceof MyUserPrincipal) {
            userName = ((MyUserPrincipal) authentication.getPrincipal()).getUsername();
        } else if (authentication.getPrincipal() instanceof User) {
            userName = ((User) authentication.getPrincipal()).getUsername();
        }
        if (userName == null) {
            authorized = false;
        } else {
            authorized = true;
            client = dbUsersStorage.getClientByPhoneOrEmail(userName);
            name = client.getFirstName();
        }
    }

    public PersonalAccount(MyUserPrincipal myUserPrincipal, DBUsersStorage dbUsersStorage) {
        if (myUserPrincipal == null) {
            authorized = false;
        } else {
            authorized = true;
            client = dbUsersStorage.getClientByPhoneOrEmail(myUserPrincipal.getUsername());
            name = client.getFirstName();
        }
    }
}
