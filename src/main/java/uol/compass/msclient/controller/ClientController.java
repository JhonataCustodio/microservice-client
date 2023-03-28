package uol.compass.msclient.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.msclient.domain.dto.ClientDtoRequest;
import uol.compass.msclient.domain.dto.ClientDtoResponse;
import uol.compass.msclient.domain.entity.Client;
import uol.compass.msclient.service.ClientService;

import java.net.URI;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
@NoArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody ClientDtoRequest request) {
        URI headerLocation = clientService.save(request);
        return ResponseEntity.created(headerLocation).build();
    }
    @GetMapping(params = "cpf")
    public ResponseEntity dataClient(@RequestParam("cpf") String cpf){
       var client = clientService.getByCPF(cpf);
       if (client.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(client);
    }
}
