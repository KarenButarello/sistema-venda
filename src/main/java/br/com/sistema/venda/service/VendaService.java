package br.com.sistema.venda.service;
import br.com.sistema.venda.dto.NovaVenda;
import br.com.sistema.venda.model.Venda;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;
    public Venda salvarVenda(NovaVenda novaVenda){
        Venda venda = new Venda();
        venda.setDataVenda(LocalDateTime.now());
        venda.setValor(novaVenda.getValor());
        Vendedor vendedor = new Vendedor();
        vendedor.setId(novaVenda.getIdVendedor());
        venda.setVendedor(vendedor);
        return repository.save(venda);
    }
}
