package br.com.sistema.venda.controller;

import br.com.sistema.venda.dto.NovoVendedor;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.service.VendedorService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
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

}
