package com.api.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.gestao.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
