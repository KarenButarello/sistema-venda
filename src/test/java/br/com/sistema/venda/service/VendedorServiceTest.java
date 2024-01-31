package br.com.sistema.venda.service;

import br.com.sistema.venda.dto.NovoVendedor;
import br.com.sistema.venda.dto.VendasVendedor;
import br.com.sistema.venda.model.Venda;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.repository.VendaRepository;
import br.com.sistema.venda.repository.VendedorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VendedorServiceTest {

    @Mock
    private VendedorRepository repository;
    @Mock
    private VendaService vendaService;
    @InjectMocks
    private VendedorService vendedorService;

    @Test
    public void deveFazerVendedor() {
        Vendedor vendedor = new Vendedor();
        NovoVendedor novoVendedor = new NovoVendedor();

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(vendedor);
        vendedorService.salvarVendedor(novoVendedor);
        Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any());
    }

    @Test
    public void buscaTodosVendedoresComVendas() {
        LocalDate inicio = LocalDate.of(2024, 01, 10);
        LocalDate fim = LocalDate.of(2024, 02, 10);
        Venda venda = new Venda();
        Vendedor vendedor = new Vendedor();
        vendedor.setId(1L);
        vendedor.setNome("joao");


        Mockito.when(repository.findAll()).thenReturn(List.of(vendedor));
        Mockito.when(vendaService.findAllByVendedorIdAndDataVendaBetween(1L, inicio, fim))
                .thenReturn(List.of(venda));



        List<VendasVendedor> resultado = vendedorService.buscaTodosVendedoresComVendas(inicio, fim);

        Assertions.assertEquals("joao", resultado.get(0).getNome());
        Assertions.assertEquals(1L, (long) resultado.get(0).getTotalVendas());
        Assertions.assertEquals(0.03d, resultado.get(0).getMediaVenda().doubleValue());

    }
}
