package br.com.sistema.venda.service;


import br.com.sistema.venda.dto.NovaVenda;
import br.com.sistema.venda.model.Venda;
import br.com.sistema.venda.repository.VendaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VendaServiceTest {

    @Mock
    private VendaRepository repository;
    @InjectMocks
    private VendaService vendaService;

    @Test
    public void deveFazerVenda(){
        Venda venda = new Venda();
        NovaVenda novaVenda = new NovaVenda();

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(venda);

        vendaService.salvarVenda(novaVenda);

        Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any());
    }

}
