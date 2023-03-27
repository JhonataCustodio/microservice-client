package uol.compass.msclient.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uol.compass.msclient.domain.dto.ClientDtoRequest;
import uol.compass.msclient.domain.dto.ClientDtoResponse;
import uol.compass.msclient.domain.entity.Client;
import uol.compass.msclient.infra.repository.ClientRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public ClientDtoResponse save(ClientDtoRequest request){
        Client client = modelMapper.map(request, Client.class);
        clientRepository.save(client);
        ClientDtoResponse clientDtoResponse = modelMapper.map(client, ClientDtoResponse.class);
        return clientDtoResponse;
    }
    public Optional<Client> getByCPF(String cpf){
        return clientRepository.findByCpf(cpf);
    }

}
