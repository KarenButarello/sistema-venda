package br.com.sistema.venda.service;
import br.com.sistema.venda.dto.NovoVendedor;
import br.com.sistema.venda.model.Vendedor;
import br.com.sistema.venda.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendedorService {
    @Autowired
    private VendedorRepository repository;
    public Vendedor salvarVendedor(NovoVendedor novoVendedor){
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(novoVendedor.getNome());
        return repository.save(vendedor);
    }
}
