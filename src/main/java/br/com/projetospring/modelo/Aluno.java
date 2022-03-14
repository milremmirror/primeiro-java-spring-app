package br.com.projetospring.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class Aluno {

    @Id
    private Long matricula;
    private String nome;
    private String email;
    private String telefone;
    private Instant dataCadastro;

}
