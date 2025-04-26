package com._oostorage.salesOpp.services.products;

import com._oostorage.salesOpp.Entities.ProductsEntity;
import com._oostorage.salesOpp.dto.ProductsDTO;
import com._oostorage.salesOpp.mappers.ProductsMapper;
import com._oostorage.salesOpp.repositories.ProductsRepository;
import com._oostorage.salesOpp.services.generalService.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private final ProductsMapper productsMapper;
    private final ProductsRepository productsRepository;
    private final GeneralService generalService;

    @Override
    public void updateProduct(Map<String, Object> product) {
        ProductsEntity productsEntity = productsRepository.getReferenceById(Integer.parseInt(product.get("seq").toString()));
        generalService.updateEntity(product, productsEntity, ProductsEntity.class);

        productsRepository.saveAndFlush(productsEntity);

    }

    @Override
    public List<ProductsDTO> getProducts() {
        return productsRepository.findAll().stream().map(productsMapper::productsEntityToProductsDTO).collect(Collectors.toList());
    }

    @Override
    public Integer createProduct(ProductsDTO productsDTO) {
        ProductsEntity productsEntity = productsMapper.productsDTOToProductsEntity(productsDTO);
        return productsRepository.saveAndFlush(productsEntity).getId();
    }


}
