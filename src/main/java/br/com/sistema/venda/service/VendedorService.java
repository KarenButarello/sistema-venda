package br.com.sistema.venda.service;
import br.com.sistema.venda.dto.NovoVendedor;
import br.com.sistema.venda.dto.VendasVendedor;
import br.com.sistema.venda.model.Venda;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.repository.VendaRepository;
import br.com.sistema.venda.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
public class VendedorService {
    @Autowired
    private VendedorRepository repository;
    @Autowired
    private VendaService vendaService;
    public Vendedor salvarVendedor(NovoVendedor novoVendedor){
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(novoVendedor.getNome());
        return repository.save(vendedor);
    }


    public List<VendasVendedor> buscaTodosVendedoresComVendas(LocalDate inicio, LocalDate fim) {
        List<VendasVendedor> vendasVendedor = new ArrayList<VendasVendedor>();
        List<Vendedor> vendedores = repository.findAll();

        for(Vendedor vendedor : vendedores){
            VendasVendedor vendaVendedor = new VendasVendedor();
            vendaVendedor.setNome(vendedor.getNome());
            List<Venda> vendas = vendaService.findAllByVendedorIdAndDataVendaBetween(vendedor.getId(), inicio, fim);
            vendaVendedor.setTotalVendas(vendas.size());
            long dias = inicio.until(fim, ChronoUnit.DAYS);
            vendaVendedor.setMediaVenda(new BigDecimal(vendas.size()).divide(BigDecimal.valueOf(dias), 2, RoundingMode.HALF_DOWN));


            vendasVendedor.add(vendaVendedor);
        }
        return vendasVendedor;
    }
}
