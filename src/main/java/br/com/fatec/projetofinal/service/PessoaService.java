package br.com.fatec.projetofinal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.projetofinal.entities.Pessoa;
import br.com.fatec.projetofinal.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> getPessoas(){
        return repository.findAll();
    }

    public Pessoa getPessoaById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Pessoa não existe")
        );
    }

    public void deletePessoaById(int id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Pessoa não existe");
        }
    }

    public Pessoa save (Pessoa pessoa){
        return this.repository.save(pessoa);
    }

    public void update(int id, Pessoa pessoa) {
    
        try{
            Pessoa pessoaAtualizada = repository.getReferenceById(id);
            pessoaAtualizada.setNome(pessoa.getNome());
            pessoaAtualizada.setEmail(pessoa.getEmail());
            pessoaAtualizada.setTelefone(pessoa.getTelefone());
            pessoaAtualizada.setEndereco(pessoa.getEndereco());
            pessoaAtualizada.setCidade(pessoa.getCidade());
            pessoaAtualizada.setCep(pessoa.getCep());
            pessoaAtualizada.setEstado(pessoa.getEstado());
            this.repository.save(pessoaAtualizada);
        }
        catch(EntityNotFoundException e)
        {
            throw new EntityNotFoundException("Pessoa não cadastrado");
        }
    }
}
