package com._oostorage.salesOpp.controllers;

import com._oostorage.salesOpp.dto.ClientsDTO;
import com._oostorage.salesOpp.services.ApiResponse;
import com._oostorage.salesOpp.services.clients.ClientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients/")
@RequiredArgsConstructor
public class ClientsController {
    private final ClientsService clientsService;

    @GetMapping("get-clients")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientsDTO> getClients() {
        return clientsService.getClients();
    }

    @PatchMapping("update-product")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse updateClient(@RequestBody Map<String, Object> product) {
        clientsService.updateClient(product);
        return new ApiResponse(true, "update successful");
    }

    @PostMapping("create-clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createClients(@RequestBody ClientsDTO clientsDTO) {
        return clientsService.createClient(clientsDTO);
    }
}
