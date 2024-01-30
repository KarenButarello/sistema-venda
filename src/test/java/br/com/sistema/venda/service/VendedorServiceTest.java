package br.com.sistema.venda.service;

import br.com.sistema.venda.dto.NovoVendedor;
import br.com.sistema.venda.model.Venda;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.repository.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VendedorServiceTest {

    @Mock
    private VendedorRepository repository;
    @InjectMocks
    private VendedorService vendedorService;

    @Test
    public void deveFazerVendedor(){
        Vendedor vendedor = new Vendedor();
        NovoVendedor novoVendedor = new NovoVendedor();

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(vendedor);
        vendedorService.salvarVendedor(novoVendedor);
        Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
