package br.com.univesp.valoresreciclaveis.service;

import br.com.univesp.valoresreciclaveis.controller.dto.DetalheCategoriaResponse;
import br.com.univesp.valoresreciclaveis.controller.dto.DetalheZonaResponse;
import br.com.univesp.valoresreciclaveis.model.Categoria;
import br.com.univesp.valoresreciclaveis.model.Prestacao;
import br.com.univesp.valoresreciclaveis.model.Zona;
import br.com.univesp.valoresreciclaveis.repository.PrestacaoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PrestacaoService {



    public List<DetalheZonaResponse> detalhesPrestacao(PrestacaoRepository repository){
        List<Prestacao> listaPrestacoes = repository.findAll();

        Set<Zona> zonas = new HashSet<>();
        List<DetalheZonaResponse> listaZonaResponse = new ArrayList<>();

        listaPrestacoes.forEach(item -> zonas.add(item.getZona()));
        zonas.forEach(z -> {
            List<DetalheCategoriaResponse> listaCategoriaResponse = new ArrayList<>();
            List<Prestacao> prestacoesPorZona = listaPrestacoes.stream().filter(prestacao -> prestacao.getZona() == z).collect(Collectors.toList());
            Set<Categoria> listaCategorias = new HashSet<Categoria>(prestacoesPorZona.stream().map(prestacao -> prestacao.getCategoria()).collect(Collectors.toSet()));
            listaCategorias.forEach(categoria -> {
                List<Prestacao> prestacoesPorCategoriaEZona = prestacoesPorZona.stream().filter(prestacao -> prestacao.getCategoria() == categoria).collect(Collectors.toList());
                List<BigDecimal> listaValores = prestacoesPorCategoriaEZona.stream().map(prestacao -> prestacao.getValor().divide(prestacao.getQteMatComercializado(), RoundingMode.DOWN)).collect(Collectors.toList());
                BigDecimal max =  listaValores.stream().reduce(new BigDecimal(Integer.MIN_VALUE), (subtotal, element) -> subtotal.max(element));
                BigDecimal min =  listaValores.stream().reduce(new BigDecimal(Integer.MAX_VALUE), (subtotal, element) -> subtotal.min(element));
                BigDecimal avg = listaValores.stream().reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element)).divide(new BigDecimal(listaValores.size()));

                listaCategoriaResponse.add(new DetalheCategoriaResponse(categoria, max, min, avg));
            });
            listaZonaResponse.add(new DetalheZonaResponse(z, listaCategoriaResponse));

        });

        return listaZonaResponse;
    }
}
