package modelo.entidades;

import java.io.Serializable;

public class TipoRequerimento implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos
    private String nome;
    private double valorTaxa;

    // Construtor (OBRIGATÓRIO para a GUI)
    public TipoRequerimento(String nome, double valorTaxa) {
        this.nome = nome;
        this.valorTaxa = valorTaxa;
    }

    // GETTERS (OBRIGATÓRIO para a GUI acessar o valor)
    public String getNome() {
        return nome;
    }

    public double getValorTaxa() {
        return valorTaxa;
    }
    
    // SETTERS (Se necessário)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorTaxa(double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }
}
