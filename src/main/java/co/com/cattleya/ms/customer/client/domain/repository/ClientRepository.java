package co.com.cattleya.client.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cattleya.client.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    public Client findByName(String name);
}
