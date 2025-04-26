package com._oostorage.salesOpp.services.clients;

import com._oostorage.salesOpp.Entities.ClientsEntity;
import com._oostorage.salesOpp.dto.ClientsDTO;
import com._oostorage.salesOpp.mappers.ClientsMapper;
import com._oostorage.salesOpp.repositories.ClientsRepository;
import com._oostorage.salesOpp.services.generalService.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    private final ClientsMapper clientsMapper;
    private final ClientsRepository clientsRepository;
    private final GeneralService generalService;

    @Override
    public void updateClient(Map<String, Object> product) {
        ClientsEntity clientsEntity = clientsRepository.getReferenceById(Integer.parseInt(product.get("seq").toString()));
        generalService.updateEntity(product, clientsEntity, ClientsEntity.class);

        clientsRepository.saveAndFlush(clientsEntity);

    }

    @Override
    public List<ClientsDTO> getClients() {
        return clientsRepository.findAll().stream().map(clientsMapper::clientsEntityToClientsDTO).collect(Collectors.toList());
    }

    @Override
    public Integer createClient(ClientsDTO clientsDTO) {
        ClientsEntity clientsEntity = clientsMapper.clientsDTOToClientsEntity(clientsDTO);
        return clientsRepository.saveAndFlush(clientsEntity).getId();
    }
}
