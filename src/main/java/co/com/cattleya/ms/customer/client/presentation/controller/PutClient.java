package co.com.cattleya.client.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.cattleya.client.application.dto.update.UpdateClientRequest;
import co.com.cattleya.client.domain.model.Client;
import co.com.cattleya.client.domain.service.ClientService;


@RestController
@RequestMapping("client")
public class PutClient {
    private final ClientService service;

    @Autowired
    public PutClient(ClientService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<Client> update( @RequestBody UpdateClientRequest request) {
        if (request == null)
            return ResponseEntity.badRequest().build();
        Client client = service.updateClient(Client.builder()
                .name(request.getName())
                .age(request.getAge())
                .description(request.getDescription())
                .photo(request.getPhoto())
                .build());
        if (client == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(client);
    }
}
