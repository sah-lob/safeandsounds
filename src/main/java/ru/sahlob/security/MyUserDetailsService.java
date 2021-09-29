package ru.sahlob.security;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.persistance.client.Client;

@Service
@Data
public class MyUserDetailsService implements UserDetailsService {

    private final DBUsersStorage dbUsersStorage;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client user = dbUsersStorage.getClientByPhoneOrEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}
