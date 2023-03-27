package uol.compass.msclient.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.msclient.domain.entity.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCpf(String cpf);
}
