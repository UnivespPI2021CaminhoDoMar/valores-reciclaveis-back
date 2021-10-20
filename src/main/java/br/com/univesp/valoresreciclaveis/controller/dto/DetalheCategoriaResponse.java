package br.com.univesp.valoresreciclaveis.controller.dto;

import br.com.univesp.valoresreciclaveis.model.Categoria;
import br.com.univesp.valoresreciclaveis.model.Zona;

import java.math.BigDecimal;

//classe para exposição dos detalhes de prestação de contas
public class DetalheCategoriaResponse {

    private Categoria nomeCategoria;

    private BigDecimal maximo;

    private BigDecimal minimo;

    private BigDecimal media;


    public DetalheCategoriaResponse(Categoria categoria, BigDecimal valorMaximo, BigDecimal valorMinimo, BigDecimal valorMedio) {
        this.nomeCategoria = categoria;
        this.maximo = valorMaximo;
        this.minimo = valorMinimo;
        this.media = valorMedio;
    }

    public Categoria getNomeCategoria() {
        return nomeCategoria;
    }

    public BigDecimal getMaximo() {
        return maximo;
    }

    public BigDecimal getMinimo() {
        return minimo;
    }

    public BigDecimal getMedia() {
        return media;
    }
}
