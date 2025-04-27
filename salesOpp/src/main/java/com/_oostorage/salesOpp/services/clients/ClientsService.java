package com._oostorage.salesOpp.services.clients;

import com._oostorage.salesOpp.dto.ClientsDTO;

import java.util.List;
import java.util.Map;

public interface ClientsService {
    void updateClient(Map<String, Object> client);

    List<ClientsDTO> getClients();


    Integer createClient(ClientsDTO clientsDTO);

    ClientsDTO getClientById(Integer id);
}
