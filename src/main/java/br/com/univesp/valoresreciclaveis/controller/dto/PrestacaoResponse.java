package br.com.univesp.valoresreciclaveis.controller.dto;

import br.com.univesp.valoresreciclaveis.model.Categoria;
import br.com.univesp.valoresreciclaveis.model.Prestacao;
import br.com.univesp.valoresreciclaveis.model.Zona;

import java.math.BigDecimal;

//Classe apenas para transporte de dados
public class PrestacaoResponse {

    //atributos
    private Categoria categoria;

    private BigDecimal qteMatComercializado;

    private BigDecimal valor;

    private Zona zona;

    //Construtor
    public PrestacaoResponse(Prestacao prestacao){
        this.categoria = prestacao.getCategoria();
        this.qteMatComercializado = prestacao.getQteMatComercializado();
        this.valor = prestacao.getValor();
        this.zona = prestacao.getZona();
    }

    ///Getters para exposição dos dados
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
