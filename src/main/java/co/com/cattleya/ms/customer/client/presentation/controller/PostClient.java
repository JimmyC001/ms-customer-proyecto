package co.com.cattleya.ms.customer.client.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import co.com.cattleya.ms.customer.client.application.dto.create.CreateClientRequest;
import co.com.cattleya.ms.customer.client.application.dto.create.CreateClientResponse;
import co.com.cattleya.ms.customer.client.domain.model.Client;
import co.com.cattleya.ms.customer.client.domain.service.ClientService;

@RestController
@RequestMapping("customer")
public class PostClient {
    private final ClientService service;

    @Autowired
    public PostClient(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateClientResponse> create(@RequestBody CreateClientRequest request) {
        if (request == null)
            return ResponseEntity.noContent().build();
        Client client = service.saveClient(Client.builder()
                .name(request.getName())
                .age(request.getAge())
                .description(request.getDescription())
                .photo(request.getPhoto())
            .build());
        if(client == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateClientResponse.builder()
                .name(client.getName())
                .age(client.getAge())
                .description(client.getDescription())
                .photo(client.getPhoto())
                .build());
    }
}
