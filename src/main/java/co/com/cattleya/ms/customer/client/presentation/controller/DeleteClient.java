package co.com.cattleya.ms.customer.client.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.cattleya.ms.customer.client.application.dto.delete.DeleteClientRequest;
import co.com.cattleya.ms.customer.client.domain.model.Client;
import co.com.cattleya.ms.customer.client.domain.service.ClientService;
@RestController
@RequestMapping("customer")
public class DeleteClient {
    private final ClientService service;
    @Autowired
    public DeleteClient(ClientService service) {
        this.service = service;
    }
    @DeleteMapping
    public ResponseEntity<Client> deleteClients(@RequestBody DeleteClientRequest request){
        if (request == null)
            return ResponseEntity.badRequest().build();
        Client client = service.deleteClient(Client.builder()
                        .name(request.getName())
                .build());
        if(client == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(client);
    }
}
