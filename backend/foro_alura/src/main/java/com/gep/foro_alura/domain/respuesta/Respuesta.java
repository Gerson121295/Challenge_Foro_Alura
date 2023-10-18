package com.gep.foro_alura.domain.respuesta;

import com.gep.foro_alura.domain.topico.Topico;
import com.gep.foro_alura.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "respuestas")
@Entity(name = "Respuesta")
@EqualsAndHashCode(of = "id")

public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion; // = LocalDateTime.now();

    @Column(name="ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    private Boolean solucion;
    private Boolean borrado;

    /*
    En la tabla respuestas de la BD va id_usuario y id_topico pero al hacer la relacion con @ManyToOne y
    realizar el @JoinColumn(name = "id_usuario") en donde se le especifica con que usuario se une,
    por lo que no es necesario definir estros atributos en esta tabla(automaticamente se crean.
    */


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id") //se crea un campo id_usuario en esta tabla Respuesta la cual unira "tendra relacion con la tabla usuarios.
    private Usuario usuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="topico_id")
    private Topico topico;

    public Respuesta(CrearRespuestaDTO crearRespuestaDTO, Usuario usuario, Topico topico) {
        this.mensaje = crearRespuestaDTO.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.ultimaActualizacion = LocalDateTime.now();
        this.solucion = false;
        this.borrado = false;
        this.usuario = usuario;
        this.topico = topico;
    }

   public void actualizarRespuesta(ActualizarRespuestaDTO actualizarRespuestaDTO){
        if(actualizarRespuestaDTO.mensaje() != null){
            this.mensaje = actualizarRespuestaDTO.mensaje();
        }
        if (actualizarRespuestaDTO.solucion() != null){
            this.solucion = actualizarRespuestaDTO.solucion();
        }
        this.ultimaActualizacion = LocalDateTime.now();
   }

   public void eliminarRespuesta(){
        this.borrado = true;
   }


}


