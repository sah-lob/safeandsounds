package ru.sahlob;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.client.ClientRoles;
import ru.sahlob.security.MyUserPrincipal;

import java.util.Collections;

@Service
public class MyUserDetailsServiceTest  implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = new Client();
        client.setFirstName("firstName");
        client.setActive(true);
        client.setRoles(Collections.singleton(ClientRoles.ADMIN));
        client.setPassword("qwer");
        client.setId(3);
        return new MyUserPrincipal(client);
    }
}
