package com._oostorage.salesOpp.controllers;

import com._oostorage.salesOpp.Entities.SaleTransactionLogsEntity;
import com._oostorage.salesOpp.dto.ProductsDTO;
import com._oostorage.salesOpp.dto.SaleTransactionLogsDTO;
import com._oostorage.salesOpp.dto.SalesDTO;
import com._oostorage.salesOpp.services.ApiResponse;
import com._oostorage.salesOpp.services.sales.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sales/")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;


    /**
     *
     * @return list all sales in the database
     */
    @GetMapping("get-sales")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesDTO> getSales() {
        return salesService.getSales();
    }



    /**
     *
     * @param id of sale
     * @return SalesDto data of one specific sale
     */
    @GetMapping("get-one-sale/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesDTO getSales(@PathVariable Integer id) {
        return salesService.getOneSale(id);
    }


    /**
     *
     * @param salesDTO data of sale to be created (includes list of transactions)
     * @return success msg with id of created sale
     */
    @PostMapping("create-sale")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createProducts(@RequestBody SalesDTO salesDTO) {

        return new ApiResponse(true, "created successfully", salesService.createSales(salesDTO));
    }

    /**
     *
     * @param saleTransactionsDTOList list of transactions to update
     * @return success msg
     * patch for partial update not the entire data needs to be sent
     */
    @PatchMapping("update-sale-transactions")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse createProducts(@RequestBody List<Map<String, Object>> saleTransactionsDTOList) {
        salesService.updateSalesTransactions(saleTransactionsDTOList);
        return new ApiResponse(true, "updated successfully");
    }
    /**
     *
     * @return list all sale logs
     */
    @GetMapping("get-sales-logs")
    @ResponseStatus(HttpStatus.OK)
    public  List<SaleTransactionLogsDTO>  getSalesTransactionLogs() {
        return salesService.getSalesTransactionLogs();
    }
}
