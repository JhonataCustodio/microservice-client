package uol.compass.msclient.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uol.compass.msclient.domain.dto.ClientDtoRequest;
import uol.compass.msclient.domain.dto.ClientDtoResponse;
import uol.compass.msclient.domain.entity.Client;
import uol.compass.msclient.infra.repository.ClientRepository;

import java.net.URI;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public URI save(@RequestBody ClientDtoRequest request){
        Client client = modelMapper.map(request, Client.class);
        clientRepository.save(client);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        //ClientDtoResponse clientDtoResponse = modelMapper.map(client, ClientDtoResponse.class);

        return headerLocation;
    }
    public Optional<Client> getByCPF(String cpf){
        return clientRepository.findByCpf(cpf);
    }

}
