package br.com.sistema.venda.controller;

import br.com.sistema.venda.dto.NovaVenda;
import br.com.sistema.venda.repository.VendaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vendas")
@RestController
public class VendaController {

    @Autowired
    private VendaRepository repository;

    @PostMapping
    public ResponseEntity salvarVenda(@RequestBody @Valid NovaVenda novaVenda){
        return ResponseEntity.ok(repository.findAll());
    }
}
