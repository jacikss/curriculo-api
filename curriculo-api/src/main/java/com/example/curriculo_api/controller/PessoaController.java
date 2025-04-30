package com.example.curriculo_api.controller;

import com.example.curriculo_api.model.Pessoa;
import com.example.curriculo_api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Criar nova pessoa (POST)
    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    // Listar todas pessoas (GET)
    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok(pessoas);
    }

    // Buscar pessoa por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar pessoa (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(
            @PathVariable Long id,
            @RequestBody Pessoa pessoaAtualizada) {

        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(pessoaAtualizada.getNome());
                    pessoa.setEmail(pessoaAtualizada.getEmail());
                    pessoa.setTelefone(pessoaAtualizada.getTelefone());
                    pessoa.setCargoPretendido(pessoaAtualizada.getCargoPretendido());
                    pessoa.setResumoProfissional(pessoaAtualizada.getResumoProfissional());
                    Pessoa atualizada = pessoaRepository.save(pessoa);
                    return ResponseEntity.ok(atualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar pessoa (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
