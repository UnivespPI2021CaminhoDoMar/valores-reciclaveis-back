package br.com.univesp.valoresreciclaveis.repository;

import br.com.univesp.valoresreciclaveis.model.Categoria;
import br.com.univesp.valoresreciclaveis.model.Prestacao;
import br.com.univesp.valoresreciclaveis.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestacaoRepository extends JpaRepository<Prestacao, Long> {

    List<Prestacao> findAllByZonaAndCategoria(Zona zona, Categoria categoria);
}
