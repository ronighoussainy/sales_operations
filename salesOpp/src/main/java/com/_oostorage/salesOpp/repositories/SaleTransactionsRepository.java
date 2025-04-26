package com._oostorage.salesOpp.repositories;

import com._oostorage.salesOpp.Entities.SaleTransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTransactionsRepository extends JpaRepository<SaleTransactionsEntity,Integer> {
}
