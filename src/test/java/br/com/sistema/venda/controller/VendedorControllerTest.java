package br.com.sistema.venda.controller;

import br.com.sistema.venda.dto.VendasVendedor;
import br.com.sistema.venda.model.Venda;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.service.VendedorService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class VendedorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VendedorService vendedorService;

    @Test
    public void deveSalvarVendedor() throws Exception {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(1L);
        vendedor.setNome("mateus");

        Mockito.when(vendedorService.salvarVendedor(ArgumentMatchers.any()))
                .thenReturn(vendedor);

        mockMvc.perform(MockMvcRequestBuilders.post("/vendedor")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\t\"nome\":\"mateus\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("mateus"));
    }
    @Test
    public void deveMostrarVendasVendedor() throws Exception{
        VendasVendedor vendasVendedor = new VendasVendedor();
        BigDecimal bigDecimal = new BigDecimal(1);

        vendasVendedor.setNome("joao");
        vendasVendedor.setTotalVendas(31);
        vendasVendedor.setMediaVenda(bigDecimal);

        Mockito.when(vendedorService.buscaTodosVendedoresComVendas(LocalDate.of(2024,01,10), LocalDate.of(2024,02,10)))
                .thenReturn(List.of(vendasVendedor));

        mockMvc.perform(MockMvcRequestBuilders.get("/vendedor")
                        .queryParam("inicio","2024-01-10")
                        .queryParam("fim","2024-02-10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("joao"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].totalVendas").value(31))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mediaVenda").value(1))
                ;

    }
}
