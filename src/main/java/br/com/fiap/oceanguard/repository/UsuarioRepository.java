package br.com.fiap.oceanguard.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.oceanguard.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
}