package com.fastporte.fastportewebservice.service;

import com.fastporte.fastportewebservice.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    Client findByEmailAndPassword(String email, String password) throws Exception;

    Client save(Client t) throws Exception; //Registrar o actualizar
    void delete(String id) throws Exception; //Eliminar
    List<Client> getAll() throws Exception; //Traer el listado de cualquier objeto
    Optional<Client> getById(String id) throws Exception; //   Traer un objeto por su id
}
