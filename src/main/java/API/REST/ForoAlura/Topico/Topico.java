package API.REST.ForoAlura.Topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Entity(name = "topico")
@Table(name = "topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private  String mensaje;
    private String fecha;
    private String autor;
    private String curso;

    public Topico(RegistroTopico registroTopico){
        this.titulo = registroTopico.titulo();
        this.mensaje = registroTopico.mensaje();
        this.fecha = registroTopico.fecha();
        this.autor = registroTopico.autor();
        this.curso = registroTopico.curso();
    }
    public void actualizar(ActualizarTopico actualizarTopico){
        if(actualizarTopico.titulo() != null){
            this.titulo = actualizarTopico.titulo();
        }
        if(actualizarTopico.mensaje() != null){
            this.mensaje = actualizarTopico.mensaje();
        }
        if(actualizarTopico.fecha() != null){
            this.fecha = actualizarTopico.fecha();
        }
        if(actualizarTopico.autor() != null){
            this.autor = actualizarTopico.autor();
        }
        if(actualizarTopico.curso() != null){
            this.curso = actualizarTopico.curso();
        }
    }
}
