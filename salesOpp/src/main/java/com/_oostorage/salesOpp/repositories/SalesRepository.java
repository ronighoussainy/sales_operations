package com._oostorage.salesOpp.repositories;

import com._oostorage.salesOpp.Entities.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesEntity,Integer> {
}
