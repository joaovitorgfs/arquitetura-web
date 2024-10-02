package com.api.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gestao.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
