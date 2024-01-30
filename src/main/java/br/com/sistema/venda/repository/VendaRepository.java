package br.com.sistema.venda.repository;

import br.com.sistema.venda.model.Venda;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findAllByVendedorIdAndDataVendaBetween(Long id, LocalDate inicio, LocalDate fim);

}
