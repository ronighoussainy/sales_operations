package com._oostorage.salesOpp.repositories;

import com._oostorage.salesOpp.Entities.SaleTransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleTransactionsRepository extends JpaRepository<SaleTransactionsEntity, Integer> {

    List<SaleTransactionsEntity> findBySaleId(Integer id);
}
