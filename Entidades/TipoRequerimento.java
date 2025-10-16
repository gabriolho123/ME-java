package modelo.entidades;

import java.io.Serializable;

public class TipoRequerimento implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String nome;
    private double valorTaxa;

    // Construtor OBRIGATÓRIO
    public TipoRequerimento(String nome, double valorTaxa) {
        this.nome = nome;
        this.valorTaxa = valorTaxa;
    }
    
    // GETTERS OBRIGATÓRIOS
    public String getNome() {
        return nome;
    }

    public double getValorTaxa() {
        return valorTaxa;
    }
}