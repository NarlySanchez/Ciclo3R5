package com.usa.reto3.repository;

import com.usa.reto3.repository.interfaces.ClientInterface;
import com.usa.reto3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nbsc1
 */

@Repository

public class ClientRepository {

    @Autowired
    private ClientInterface crud1;

    public List<Client> getAll() {
        return (List<Client>) crud1.findAll();
    }

    public Optional<Client> getClient(int id) {
        return crud1.findById(id);
    }

    public Client save(Client client) {
        return crud1.save(client);
    }

    public void delete(Client client) {
        crud1.delete(client);
    }

}
