package br.com.systemssa.desafiotres.repositories;

import br.com.systemssa.desafiotres.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
