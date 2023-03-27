package uol.compass.msclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.msclient.domain.dto.ClientDtoRequest;
import uol.compass.msclient.domain.dto.ClientDtoResponse;
import uol.compass.msclient.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public String status(){
        return "ok";
    }
    @PostMapping()
    public ResponseEntity<ClientDtoResponse> save(@RequestBody ClientDtoRequest request){
        ClientDtoResponse clientDtoResponse = clientService.save(request);
        return ResponseEntity.ok(clientDtoResponse);
    }
}
