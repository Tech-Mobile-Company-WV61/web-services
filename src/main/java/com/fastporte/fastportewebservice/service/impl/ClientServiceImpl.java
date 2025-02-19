package com.fastporte.fastportewebservice.service.impl;

import com.fastporte.fastportewebservice.entities.Client;
import com.fastporte.fastportewebservice.repository.IClientRepository;
import com.fastporte.fastportewebservice.service.IClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) // Solo servicios de lectura
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public Client save(Client client) throws Exception {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void delete(String id) throws Exception {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAll() throws Exception {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getById(String id) throws Exception {
        return clientRepository.findById(id);
    }

}
