package com.api.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gestao.model.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
}
