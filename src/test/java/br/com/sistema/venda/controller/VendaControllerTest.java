package br.com.sistema.venda.controller;

import br.com.sistema.venda.model.Venda;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.service.VendaService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
class VendaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VendaService vendaService;
    @Test
    public void deveSalvarVenda() throws Exception{
        Venda venda = new Venda();
        Vendedor vendedor = new Vendedor();

        venda.setId(1L);
        venda.setDataVenda(LocalDate.now());
        venda.setValor(new BigDecimal(50));
        venda.setVendedor(vendedor);

        vendedor.setId(1L);
        vendedor.setNome("joao");

        Mockito.when(vendaService.salvarVenda(ArgumentMatchers.any()))
                .thenReturn(venda);

        mockMvc.perform(MockMvcRequestBuilders.post("/vendas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"valor\": 80,\n" +
                        "\t\"idVendedor\": \"1\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dataVenda").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.valor").value(50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vendedor.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vendedor.nome").value("joao"));

    }

}