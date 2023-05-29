package co.com.cattleya.ms.customer.client.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cattleya.ms.customer.client.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    public Client findByName(String name);
}
