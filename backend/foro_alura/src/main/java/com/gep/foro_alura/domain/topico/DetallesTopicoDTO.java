package com.gep.foro_alura.domain.topico;

import com.gep.foro_alura.domain.curso.Categoria;

import java.time.LocalDateTime;

public record DetallesTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime ultimaActualizacion,
        Estado estado,
        String usuario,
        String curso,
        Categoria categoriaCurso

) {

    public DetallesTopicoDTO(Topico topico) {
        this(topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaCreacion(),
            topico.getUltimaActualizacion(),
            topico.getEstado(),
            topico.getUsuario().getUsername(),
            topico.getCurso().getName(),
            topico.getCurso().getCategoria()
                );
    }
}
