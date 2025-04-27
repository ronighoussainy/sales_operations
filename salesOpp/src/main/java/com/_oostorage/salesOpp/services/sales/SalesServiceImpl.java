package com._oostorage.salesOpp.services.sales;

import com._oostorage.salesOpp.Entities.SaleTransactionLogsEntity;
import com._oostorage.salesOpp.Entities.SaleTransactionsEntity;
import com._oostorage.salesOpp.Entities.SalesEntity;
import com._oostorage.salesOpp.dto.SaleTransactionLogsDTO;
import com._oostorage.salesOpp.dto.SaleTransactionsDTO;
import com._oostorage.salesOpp.dto.SalesDTO;
import com._oostorage.salesOpp.mappers.SaleTransactionLogsMapper;
import com._oostorage.salesOpp.mappers.SaleTransactionsMapper;
import com._oostorage.salesOpp.mappers.SalesMapper;
import com._oostorage.salesOpp.mappers.SellersMapper;
import com._oostorage.salesOpp.repositories.SaleTransactionLogsRepository;
import com._oostorage.salesOpp.repositories.SaleTransactionsRepository;
import com._oostorage.salesOpp.repositories.SalesRepository;
import com._oostorage.salesOpp.repositories.SellersRepository;
import com._oostorage.salesOpp.services.clients.ClientsService;
import com._oostorage.salesOpp.services.generalService.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService {

    private final SalesMapper salesMapper;
    private final SalesRepository salesRepository;
    private final ClientsService clientsService;
    private final SellersMapper sellersMapper;
    private final SellersRepository sellersRepository;
    private final SaleTransactionsMapper saleTransactionsMapper;
    private final SaleTransactionsRepository saleTransactionsRepository;
    private final GeneralService generalService;
    private final SaleTransactionLogsRepository saleTransactionLogsRepository;
    private final SaleTransactionLogsMapper saleTransactionLogsMapper;

    @Override
    public List<SalesDTO> getSales() {
        return salesRepository.findAll().stream().map(this::salesEntityToSalesDto).collect(Collectors.toList());
    }

    @Override
    public SalesDTO getOneSale(Integer id) {
        return salesEntityToSalesDto(salesRepository.getReferenceById(id));
    }

    @Override
    public Integer createSales(SalesDTO salesDTO) {
        SalesEntity salesEntity = salesMapper.salesDTOToSalesEntity(salesDTO);
        List<SaleTransactionsEntity> saleTransactionsEntities = new ArrayList<>();
        Integer id = salesRepository.saveAndFlush(salesEntity).getId();
        for (SaleTransactionsDTO saleTransactionsDTO : salesDTO.getSaleTransactionsDTOList()) {
            saleTransactionsDTO.setSaleId(id);
            saleTransactionsEntities.add(saleTransactionsMapper.saleTransactionsDTOToSaleTransactionsEntity(saleTransactionsDTO));
        }
        saleTransactionsRepository.saveAllAndFlush(saleTransactionsEntities);
        salesRepository.updateSalesTotal(id, calculateTotla(saleTransactionsEntities));
        return id;
    }

    @Override
    public void updateSalesTransactions(List<Map<String, Object>> saleTransactionsDTOList) {
        List<SaleTransactionsEntity> saleTransactionsEntities = new ArrayList<>();
        List<SaleTransactionLogsEntity> saleTransactionLogsEntities = new ArrayList<>();
        for (Map<String, Object> salesTransaction : saleTransactionsDTOList) {
            SaleTransactionsEntity saleTransactionsEntity = saleTransactionsRepository.findById(Integer.parseInt(salesTransaction.get("id").toString())).get();
            saleTransactionLogsEntities.add(setTransactionLog(saleTransactionsEntity
                    , Double.parseDouble(salesTransaction.get("price").toString())
                    , Integer.parseInt(salesTransaction.get("quantity").toString())))
            ;
            generalService.updateEntity(salesTransaction, saleTransactionsEntity, SaleTransactionsEntity.class);
            saleTransactionsEntities.add(saleTransactionsEntity);
        }
        saleTransactionsRepository.saveAllAndFlush(saleTransactionsEntities);
        saleTransactionLogsRepository.saveAllAndFlush(saleTransactionLogsEntities);

        salesRepository.updateSalesTotal(saleTransactionsEntities.get(0).getSaleId(), calculateTotla(saleTransactionsEntities));
    }

    @Override
    public List<SaleTransactionLogsDTO> getSalesTransactionLogs() {
        return saleTransactionLogsRepository.findAll().stream().map(saleTransactionLogsMapper::saleTransactionLogsEntityToSaleTransactionLogsDTO).collect(Collectors.toList());
    }

    SalesDTO salesEntityToSalesDto(SalesEntity salesEntity) {
        SalesDTO salesDTO = salesMapper.salesEntityToSalesDTO(salesEntity);
        salesDTO.setClientsDTO(clientsService.getClientById(salesDTO.getClientId()));
        salesDTO.setSellersDTO(sellersMapper.sellersEntityToSellersDTO(sellersRepository.getReferenceById(salesDTO.getSellerId())));
        salesDTO.setSaleTransactionsDTOList(saleTransactionsRepository
                .findBySaleId(salesDTO.getId())
                .stream()
                .map(saleTransactionsMapper::saleTransactionsEntityToSaleTransactionsDTO)
                .collect(Collectors.toList()));
        return salesDTO;
    }

    Double calculateTotla(List<SaleTransactionsEntity> saleTransactionsEntityList) {
        double total = 0.0;
        for (SaleTransactionsEntity saleTransactionsEntity : saleTransactionsEntityList) {
            total += (saleTransactionsEntity.getPrice() * saleTransactionsEntity.getQuantity());

        }
        return total;
    }

    SaleTransactionLogsEntity setTransactionLog(SaleTransactionsEntity saleTransactionsEntity, double newPrice, Integer newQuantity) {
        SaleTransactionLogsEntity saleTransactionLogsEntity = new SaleTransactionLogsEntity();
        saleTransactionLogsEntity.setTransactionId(saleTransactionsEntity.getId());
        saleTransactionLogsEntity.setNewPrice(newPrice);
        saleTransactionLogsEntity.setOldPrice(saleTransactionsEntity.getPrice());
        saleTransactionLogsEntity.setNewQuantity(newQuantity);
        saleTransactionLogsEntity.setOldQuantity(saleTransactionsEntity.getQuantity());
        return saleTransactionLogsEntity;
    }
}
