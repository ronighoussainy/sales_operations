package com._oostorage.salesOpp.repositories;

import com._oostorage.salesOpp.Entities.SaleTransactionLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTransactionLogsRepository extends JpaRepository<SaleTransactionLogsEntity, Integer> {
}
