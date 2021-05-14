package ru.sahlob.db;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.sahlob.db.interfaces.DBUsersRepository;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.order.InputOrder;

@Service
@Data
public class DBUsersStorage {

    private final DBUsersRepository dbUsersRepository;


    public Client saveUser(Client client) {
       return dbUsersRepository.save(client);
    }

    public Client addNewUser(InputOrder inputOrder) {
        inputOrder.getCommunicationMethodNum();
        Client client = new Client(
                inputOrder.getClientName(),
                inputOrder.getClientPhone(),
                inputOrder.getClientEmail());
        return dbUsersRepository.save(client);
    }


    public Client getClientByPhoneOrEmail(String phone, String email) {
        var client = getClientByPhone(phone);
        return client == null ? getClientByEmail(email) : client;
    }

    public Client getClientById(int id) {
        return dbUsersRepository.findById(id).get();
    }

    public Client getClientByPhone(String phone) {
        return dbUsersRepository.findByPhone(phone);
    }

    public Client getClientByEmail(String email) {
        return dbUsersRepository.findByEmail(email);
    }

//    private void addAdditionalInfoToClientFromOrderAndInputOrder(Client client, InputOrder inputOrder, Order order) {
//        var additionalInfo = inputOrder.getCommunicationMethodAdditionalValue();
//        if (!additionalInfo.isEmpty()) {
//            var communicationMethod = order.getPerformCommunicationMethod();
//            if (communicationMethod == PerformCommunicationMethod.telegram) {
//                client.setTelegramPhone(additionalInfo);
//            }
//        }
//    }
}
