package com.api.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gestao.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
