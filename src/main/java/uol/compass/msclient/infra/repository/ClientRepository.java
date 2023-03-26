package uol.compass.msclient.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.msclient.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
