package br.com.univesp.valoresreciclaveis.controller.dto;

import br.com.univesp.valoresreciclaveis.model.Categoria;
import br.com.univesp.valoresreciclaveis.model.Prestacao;
import br.com.univesp.valoresreciclaveis.model.Zona;
import br.com.univesp.valoresreciclaveis.repository.PrestacaoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//classe para exposição dos detalhes de prestação de contas
public class DetalheZonaResponse {

    private Zona zona;

    private List<DetalheCategoriaResponse> categorias;

    public DetalheZonaResponse(Zona zona, List<DetalheCategoriaResponse> categorias) {
        this.zona = zona;
        this.categorias = categorias;
    }

    public Zona getZona() {
        return zona;
    }

    public List<DetalheCategoriaResponse> getCategorias() {
        return categorias;
    }
}
