package com.api.gestao.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PessoaFisica extends Pessoa {

    private String cpf;
    private LocalDate dataNascimento;
}
