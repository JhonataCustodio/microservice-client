package uol.compass.msclient.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uol.compass.msclient.domain.Client;
import uol.compass.msclient.infra.repository.ClientRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    @Transactional
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public Optional<Client> getByCPF(String cpf){
        return clientRepository.findByCpf(cpf);
    }

}
