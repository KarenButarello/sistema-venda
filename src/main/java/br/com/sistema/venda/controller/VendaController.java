package br.com.sistema.venda.controller;

import br.com.sistema.venda.dto.NovaVenda;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vendas")
@RestController
public class VendaController {
    @PostMapping
    public ResponseEntity salvarVenda(@RequestBody @Valid NovaVenda novaVenda){
        return ResponseEntity.ok("ok");
    }
}
