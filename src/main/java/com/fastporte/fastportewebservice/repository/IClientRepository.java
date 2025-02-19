package com.fastporte.fastportewebservice.repository;

import com.fastporte.fastportewebservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, String> {

}
