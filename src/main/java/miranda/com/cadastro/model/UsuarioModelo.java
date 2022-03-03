package miranda.com.cadastro.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioModelo {

    private String nome ;
    private int idade ;
    private long id ;

}
