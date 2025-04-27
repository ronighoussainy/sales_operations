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

    /**
     *
     * @return List<ClientsDTO> list of all clients available in the database
     */
    @GetMapping("get-clients")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientsDTO> getClients() {
        return clientsService.getClients();
    }

    /**
     *
     * @param id id of client that we want to get his data
     * @return ClientsDTO data of client
     */
    @GetMapping("get-one-client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientsDTO getClientById(@PathVariable Integer id) {
        return clientsService.getClientById(id);
    }

    /**
     *
     * @param client data of client to update
     * @return success msg
     * patch for partial update not the entire data needs to be sent
     */
    @PatchMapping("update-client")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse updateClient(@RequestBody Map<String, Object> client) {
        clientsService.updateClient(client);
        return new ApiResponse(true, "update successful");
    }

    /**
     *
     * @param clientsDTO data of client to create
     * @return success msg and the id of the new client
     */
    @PostMapping("create-clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createClients(@RequestBody ClientsDTO clientsDTO) {
        return new ApiResponse(true, "created successfully", clientsService.createClient(clientsDTO));
    }
}
