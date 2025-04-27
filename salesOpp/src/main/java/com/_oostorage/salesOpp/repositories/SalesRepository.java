package com._oostorage.salesOpp.repositories;

import com._oostorage.salesOpp.Entities.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update SalesEntity u set u.total=?2 where u.id=?1")
    void updateSalesTotal(Integer id, Double total);
}
