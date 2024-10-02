package com.api.gestao.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Estratégia de herança no JPA
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, // Indica que o campo "tipo" será usado para identificar a subclasse
    include = JsonTypeInfo.As.PROPERTY, 
    property = "tipo" // Define o nome da propriedade JSON que indica o tipo da subclasse
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PessoaFisica.class, name = "pessoaFisica"),
    @JsonSubTypes.Type(value = PessoaJuridica.class, name = "pessoaJuridica")
})
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private String telefone;
}
