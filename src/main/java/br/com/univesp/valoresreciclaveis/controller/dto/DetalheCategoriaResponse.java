package br.com.univesp.valoresreciclaveis.controller.dto;

import br.com.univesp.valoresreciclaveis.model.Categoria;
import br.com.univesp.valoresreciclaveis.model.Zona;

import java.math.BigDecimal;

//classe para exposição dos detalhes de prestação de contas
public class DetalheCategoriaResponse {

    private Categoria categoria;

    private BigDecimal valorMaximo;

    private BigDecimal valorMinimo;

    private BigDecimal valorMedio;


    public DetalheCategoriaResponse(Categoria categoria, BigDecimal valorMaximo, BigDecimal valorMinimo, BigDecimal valorMedio) {
        this.categoria = categoria;
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.valorMedio = valorMedio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public BigDecimal getValorMedio() {
        return valorMedio;
    }
}
