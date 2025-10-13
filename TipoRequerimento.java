package modelo.entidades;

import java.io.Serializable;

public class TipoRequerimento implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos
    private String nome;
    private double valorTaxa;

    // Construtor (OBRIGAT�RIO para a GUI)
    public TipoRequerimento(String nome, double valorTaxa) {
        this.nome = nome;
        this.valorTaxa = valorTaxa;
    }

    // GETTERS (OBRIGAT�RIO para a GUI acessar o valor)
    public String getNome() {
        return nome;
    }

    public double getValorTaxa() {
        return valorTaxa;
    }
    
    // SETTERS (Se necess�rio)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorTaxa(double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }
}