package com._oostorage.salesOpp.controllers;

import com._oostorage.salesOpp.dto.ProductsDTO;
import com._oostorage.salesOpp.services.ApiResponse;
import com._oostorage.salesOpp.services.products.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products/")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    /**
     *
     * @return list of products in the database
     */
    @GetMapping("get-products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductsDTO> getProducts() {
        return productsService.getProducts();
    }

    /**
     *
     * @param product product to be updated data
     * @return success msg
     * patch for partial update not the entire data needs to be sent
     */
    @PatchMapping("update-product")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse updateProduct(@RequestBody Map<String, Object> product) {
        productsService.updateProduct(product);
        return new ApiResponse(true, "update successful");
    }

    /**
     *
     * @param productsDTO data of product to be created
     * @return success msg with id of created product
     */
    @PostMapping("create-products")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createProducts(@RequestBody ProductsDTO productsDTO) {

        return new ApiResponse(true, "created successfully", productsService.createProduct(productsDTO));
    }
}
