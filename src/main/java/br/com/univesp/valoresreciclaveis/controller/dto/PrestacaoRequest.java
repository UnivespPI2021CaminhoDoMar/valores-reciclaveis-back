package br.com.univesp.valoresreciclaveis.controller.dto;

import br.com.univesp.valoresreciclaveis.model.Categoria;
import br.com.univesp.valoresreciclaveis.model.Prestacao;
import br.com.univesp.valoresreciclaveis.model.Zona;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PrestacaoRequest {

    @NotNull
    private Categoria categoria;

    @Positive
    @NotNull
    private BigDecimal qteMatComercializado;

    @Positive
    @NotNull
    private BigDecimal valor;

    @NotNull
    private Zona zona;

    public PrestacaoRequest(Categoria categoria, BigDecimal qteMatComercializado, BigDecimal valor, Zona zona) {
        this.categoria = categoria;
        this.qteMatComercializado = qteMatComercializado;
        this.valor = valor;
        this.zona = zona;
    }

    public Prestacao toModel(){
        return new Prestacao(categoria, qteMatComercializado, valor, zona);
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getQteMatComercializado() {
        return qteMatComercializado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Zona getZona() {
        return zona;
    }
}
