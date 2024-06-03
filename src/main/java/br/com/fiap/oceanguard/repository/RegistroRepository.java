package br.com.fiap.oceanguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.oceanguard.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long> { }
