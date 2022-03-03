package miranda.com.cadastro.service;


import miranda.com.cadastro.DTO.UsuarioDTO;
import miranda.com.cadastro.converter.UsuarioConverter;
import miranda.com.cadastro.entidade.UsuarioEntity;
import miranda.com.cadastro.exceptions.NaoEncontradoGeralException;
import miranda.com.cadastro.model.UsuarioModelo;
import miranda.com.cadastro.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio repositorio;

    public UsuarioModelo salvarNovoUsuario(UsuarioModelo novoUsuario){
        try {
            UsuarioEntity usuarioEntity = UsuarioConverter.modelToEntity(novoUsuario);
            UsuarioEntity save = repositorio.save(usuarioEntity);
            return  UsuarioConverter.entityToModel(save);
        }catch (Exception e){
            throw e;
        }
    }

    public List<UsuarioModelo> buscarTodosOsUsuario(){
        try{
            List<UsuarioEntity> lista = new ArrayList<>();
            repositorio.findAll().forEach(lista::add);
            return  lista.stream()
                    .map(UsuarioConverter::entityToModel)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw  e;
        }
    }

    public UsuarioModelo buscarPorId(Long id){
     return UsuarioConverter
             .entityToModel(repositorio.findById(id).orElseThrow(NaoEncontradoGeralException::new));
    }

    public boolean excluirUsuario(Long id){
        if(repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

}
