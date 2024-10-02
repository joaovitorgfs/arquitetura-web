package com.api.gestao.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String razaoSocial;
}
