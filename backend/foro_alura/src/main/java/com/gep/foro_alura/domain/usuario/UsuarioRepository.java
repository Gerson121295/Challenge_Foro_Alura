package com.gep.foro_alura.domain.usuario;

import com.gep.foro_alura.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByUsername(String username);
    UserDetails findByEmail(String email);

    Page<Usuario> findAllByEnabledTrue(Pageable pageable);

    Usuario getReferenceById(Long id);

    Page<Usuario> findAll(Pageable pageable);//nueva

    Usuario getReferenceByUsername(String username);
    Boolean existsByUsername(String username);
}
