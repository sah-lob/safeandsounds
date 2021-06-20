package ru.sahlob.persistance.client;

import lombok.Data;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.interfaces.DBUsersRepository;
import ru.sahlob.security.MyUserPrincipal;

import java.security.Principal;

@Data
public class PersonalAccount {
    private boolean authorized;
    private String name;

    public PersonalAccount(Principal user, DBUsersStorage dbUsersStorage) {
        if (user == null) {
            authorized = false;
        } else {
            authorized = true;
            var client = dbUsersStorage.getClientByPhoneOrEmail(user.getName());
            name = client.getFirstName();
        }
    }

    public PersonalAccount(MyUserPrincipal myUserPrincipal, DBUsersStorage dbUsersStorage) {
        if (myUserPrincipal == null) {
            authorized = false;
        } else {
            authorized = true;
            var client = dbUsersStorage.getClientByPhoneOrEmail(myUserPrincipal.getUsername());
            name = client.getFirstName();
        }
    }
}
