package miranda.com.cadastro.controller;

import miranda.com.cadastro.DTO.UsuarioDTO;
import miranda.com.cadastro.converter.UsuarioConverter;
import miranda.com.cadastro.entidade.UsuarioEntity;
import miranda.com.cadastro.model.UsuarioModelo;
import miranda.com.cadastro.repositorio.UsuarioRepositorio;
import miranda.com.cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService serviceUsuario ;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        UsuarioDTO usuarioDTO = UsuarioConverter.modelToDTO(serviceUsuario.buscarPorId(id));
        return  ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<?> novoUsuario(@RequestBody UsuarioDTO novo){
        UsuarioModelo usuarioModelo = serviceUsuario.salvarNovoUsuario(UsuarioConverter.dtoToModel(novo));
        return ResponseEntity.ok(UsuarioConverter.modelToDTO(usuarioModelo));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        return ResponseEntity.accepted().body(serviceUsuario.excluirUsuario(id));
    }
    @GetMapping
    public ResponseEntity<?> buscarTodos(){
        return ResponseEntity.ok(serviceUsuario.buscarTodosOsUsuario());
    }




}
