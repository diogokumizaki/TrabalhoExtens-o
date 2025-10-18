package controllers;

import models.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.TransacaoRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable UUID id) {
        return transacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transacao criar(@RequestBody Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable UUID id, @RequestBody Transacao transacaoAtualizada) {
        return transacaoRepository.findById(id)
                .map(transacao -> {
                    transacao.setTitulo(transacaoAtualizada.getTitulo());
                    transacao.setPreco(transacaoAtualizada.getPreco());
                    transacao.setCategoriaId(transacaoAtualizada.getCategoriaId());
                    transacao.setUsuarioId(transacaoAtualizada.getUsuarioId());
                    return ResponseEntity.ok(transacaoRepository.save(transacao));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable UUID id) {
        return transacaoRepository.findById(id)
                .map(transacao -> {
                    transacaoRepository.delete(transacao);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Transacao> listarPorUsuario(@PathVariable UUID usuarioId) {
        return transacaoRepository.findByUsuarioId(usuarioId);
    }
}
