package com.fastporte.fastportewebservice.service;

import com.fastporte.fastportewebservice.entities.Driver;

import java.util.List;
import java.util.Optional;

public interface IDriverService {

    Driver save(Driver t) throws Exception; //Registrar o actualizar
    void delete(String id) throws Exception; //Eliminar
    List<Driver> getAll() throws Exception; //Traer el listado de cualquier objeto
    Optional<Driver> getById(String id) throws Exception; //   Traer un objeto por su id

}
