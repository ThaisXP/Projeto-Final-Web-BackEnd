package br.com.fatec.projetofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.projetofinal.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer>{
    
}
