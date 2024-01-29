package br.com.sistema.venda.controller;
import br.com.sistema.venda.dto.NovoVendedor;
import br.com.sistema.venda.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vendedor")
@RestController
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity salvarVendedor(@RequestBody @Valid NovoVendedor novoVendedor) {
        return ResponseEntity.ok(vendedorService.salvarVendedor(novoVendedor));
    }
}
