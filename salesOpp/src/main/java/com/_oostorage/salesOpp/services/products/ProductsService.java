package com._oostorage.salesOpp.services.products;

import com._oostorage.salesOpp.dto.ProductsDTO;

import java.util.List;
import java.util.Map;

public interface ProductsService {
    void updateProduct(Map<String, Object> product);

    List<ProductsDTO> getProducts();

    Integer createProduct(ProductsDTO productsDTO);
}
