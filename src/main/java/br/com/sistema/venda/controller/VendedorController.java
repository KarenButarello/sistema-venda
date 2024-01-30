package br.com.sistema.venda.controller;
import br.com.sistema.venda.dto.NovoVendedor;
import br.com.sistema.venda.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/vendedor")
@RestController
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity getTodosVendedoresComVendas(@RequestParam LocalDate inicio , @RequestParam LocalDate fim){
        var todosVendedores = vendedorService.buscaTodosVendedoresComVendas(inicio,fim);
        return ResponseEntity.ok(todosVendedores);
    }

    @PostMapping
    public ResponseEntity salvarVendedor(@RequestBody @Valid NovoVendedor novoVendedor) {
        return ResponseEntity.ok(vendedorService.salvarVendedor(novoVendedor));
    }


}
