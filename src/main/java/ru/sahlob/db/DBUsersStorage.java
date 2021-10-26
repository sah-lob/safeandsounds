package ru.sahlob.db;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.sahlob.db.interfaces.DBUsersRepository;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.order.InputOrder;
import ru.sahlob.service.ServiceUtil;

@Service
@Data
public class DBUsersStorage {

    private final DBUsersRepository dbUsersRepository;


    public Client saveUser(Client client) {
        return dbUsersRepository.save(client);
    }

    public Client addNewUserFromInputOrder(InputOrder inputOrder) {
        Client client = new Client(
                inputOrder.getClientName(),
                inputOrder.getClientPhone(),
                inputOrder.getClientEmail());
        client.setUuid(ServiceUtil.getRandomUuid());
        return dbUsersRepository.save(client);
    }

    public Client getClientByPhoneOrEmail(String phone, String email) {
        var client = getClientByPhone(phone);
        return client == null ? getClientByEmail(email) : client;
    }

    public Client getClientByPhoneOrEmail(String data) {
        return getClientByPhoneOrEmail(data, data);
    }

    public Client getClientById(int id) {
        return dbUsersRepository.findById(id).get();
    }

    public Client getClientByUuid(String uuid) {
        return dbUsersRepository.findByUuid(uuid);
    }

    public Client getClientByPhone(String phone) {
        return dbUsersRepository.findByPhone(phone);
    }

    public Client getClientByEmail(String email) {
        return dbUsersRepository.findByEmail(email);
    }

    public Client getClientByName(String name) {
        return dbUsersRepository.findByFirstName(name);
    }
}
