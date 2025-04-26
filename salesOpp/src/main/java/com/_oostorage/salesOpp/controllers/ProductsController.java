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

    @GetMapping("get-products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductsDTO> getProducts() {
        return productsService.getProducts();
    }

    @PatchMapping("update-product")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse updateProduct(@RequestBody Map<String, Object> product) {
        productsService.updateProduct(product);
        return new ApiResponse(true, "update successful");
    }

    @PostMapping("create-products")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createProducts(@RequestBody ProductsDTO productsDTO) {
        return productsService.createProduct(productsDTO);
    }
}
