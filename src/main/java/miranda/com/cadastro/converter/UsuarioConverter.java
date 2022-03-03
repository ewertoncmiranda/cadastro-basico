package miranda.com.cadastro.converter;

import miranda.com.cadastro.DTO.UsuarioDTO;
import miranda.com.cadastro.entidade.UsuarioEntity;
import miranda.com.cadastro.model.UsuarioModelo;

public class UsuarioConverter {

    public static UsuarioModelo entityToModel(UsuarioEntity usuarioEntity){
        return  UsuarioModelo.builder()
                .id(usuarioEntity.getId())
                .idade(usuarioEntity.getIdade())
                .nome(usuarioEntity.getNome())
                .build();
    }

    public static UsuarioEntity modelToEntity (UsuarioModelo usuarioModelo){
        return  UsuarioEntity.builder()
                .id(usuarioModelo.getId())
                .idade(usuarioModelo.getIdade())
                .nome(usuarioModelo.getNome())
                .build();
    }

    public static UsuarioDTO modelToDTO (UsuarioModelo usuarioModelo){
        return  UsuarioDTO.builder()
                .id(usuarioModelo.getId())
                .idade(usuarioModelo.getIdade())
                .nome(usuarioModelo.getNome())
                .build();
    }

    public static UsuarioModelo dtoToModel (UsuarioDTO usuarioDTO){
        return  UsuarioModelo.builder()
                .id(usuarioDTO.getId())
                .idade(usuarioDTO.getIdade())
                .nome(usuarioDTO.getNome())
                .build();
    }
}
