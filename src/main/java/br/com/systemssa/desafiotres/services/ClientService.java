package br.com.systemssa.desafiotres.services;

import br.com.systemssa.desafiotres.dto.ClientDTO;
import br.com.systemssa.desafiotres.entities.Client;
import br.com.systemssa.desafiotres.repositories.ClientRepository;
import br.com.systemssa.desafiotres.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Optional<Client> result = repository.findById(id);
        Client client = result.orElseThrow(() -> new ResourceNotFoundException("Cadastro não localizado"));
        ClientDTO dto = new ClientDTO(client);
        return dto;
    }
}
