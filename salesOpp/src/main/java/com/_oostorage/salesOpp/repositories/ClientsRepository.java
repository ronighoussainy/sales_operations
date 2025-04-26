package com._oostorage.salesOpp.repositories;

import com._oostorage.salesOpp.Entities.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<ClientsEntity,Integer> {
}
