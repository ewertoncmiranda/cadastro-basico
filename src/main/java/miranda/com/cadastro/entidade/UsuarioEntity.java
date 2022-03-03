package miranda.com.cadastro.entidade;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Table(name = "USUARIO_TBL")
@Data
@SequenceGenerator(name = "seq_user" ,sequenceName = "seq_user" ,allocationSize = 1 ,initialValue = 1)
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_user")
    private Long id ;
    private String nome ;
    private int idade ;

}
