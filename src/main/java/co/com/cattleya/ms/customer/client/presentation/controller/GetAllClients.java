package co.com.cattleya.ms.customer.client.presentation.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.cattleya.ms.customer.client.domain.model.Client;
import co.com.cattleya.ms.customer.client.domain.service.ClientService;

@RestController
@RequestMapping("client")
public class GetAllClients {
    private final ClientService service;
    @Autowired
    public GetAllClients(ClientService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = service.findAll();
        List<Client> filteredClients = clients.stream()
                .collect(Collectors.toList());
        if(clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(filteredClients);
    }
}
