package miranda.com.cadastro.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NaoEncontradoGeralException extends RuntimeException{

    public NaoEncontradoGeralException(String mensagemDeError){
        super(mensagemDeError);
    }
}
