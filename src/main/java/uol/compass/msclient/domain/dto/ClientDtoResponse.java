package uol.compass.msclient.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoResponse {
    private  Long id;
    private String cpf;
    private  String nome;
    private Integer idade;
}
