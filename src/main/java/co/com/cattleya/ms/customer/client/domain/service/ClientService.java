package co.com.cattleya.ms.customer.client.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import co.com.cattleya.ms.customer.client.domain.model.Client;
import co.com.cattleya.ms.customer.client.domain.repository.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> findAll() {
        return repository.findAll();
    }
    private Client findByName(String name){
        return repository.findByName(name);
    }

    public Client saveClient(Client client) {
        Client dbClient = findByName(client.getName());
        if(dbClient != null)
            return dbClient;
        return repository.save(client);
    }

    public Client findClient(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Client deleteClient(Client client) {
        Client dbClient = findByName(client.getName());

        if(dbClient != null){
            repository.delete(dbClient);
            return dbClient;
        }
        return null;
    }

    public Client updateClient(Client client) {
        Client dbClient = findByName(client.getName());

        if(dbClient != null){

            dbClient.setName(client.getName());
            dbClient.setAge(client.getAge());
            dbClient.setPhoto(client.getPhoto());
            dbClient.setDescription(client.getDescription());
            return repository.save(dbClient);
        }
        return null;

    }
}
