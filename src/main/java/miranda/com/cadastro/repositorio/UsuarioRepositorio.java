package miranda.com.cadastro.repositorio;

import miranda.com.cadastro.entidade.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioEntity,Long> {
}
