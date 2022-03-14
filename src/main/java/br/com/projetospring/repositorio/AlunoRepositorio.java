package br.com.projetospring.repositorio;

import br.com.projetospring.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {
}
