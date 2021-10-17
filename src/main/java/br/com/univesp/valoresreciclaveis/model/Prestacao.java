package br.com.univesp.valoresreciclaveis.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_prestacao")
public class Prestacao {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Positive
    @Column(nullable = false)
    private BigDecimal qteMatComercializado;

    @Positive
    @Column(nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Zona zona;

    //Construtor padrão para Framework
    @Deprecated
    public Prestacao() {
    }

    //Construtor
    public Prestacao(Categoria categoria, BigDecimal qteMatComercializado, BigDecimal valor, Zona zona) {
        this.categoria = categoria;
        this.qteMatComercializado = qteMatComercializado;
        this.valor = valor;
        this.zona = zona;
    }

    //Getters
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
