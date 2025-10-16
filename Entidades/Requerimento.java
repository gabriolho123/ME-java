package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

public class Requerimento implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // Atributos
    private String numero;
    private Date dataSolicitacao;
    private Aluno solicitante;
    private TipoRequerimento tipo;
    private Status statusAtual;
    private Boleto boletoGerado;
    // ... outros atributos (dadosSolicitacao, etc.)
    
    // Construtor 
    public Requerimento(String numero, Aluno solicitante, TipoRequerimento tipo) {
        this.numero = numero;
        this.solicitante = solicitante;
        this.tipo = tipo;
        this.statusAtual = new Status("PENDENTE"); 
        this.dataSolicitacao = new Date(); 
    }
    
    // GETTERS OBRIGAT�RIOS
    public String getNumero() {
        return numero;
    }

    public Aluno getSolicitante() {
        return solicitante;
    }

    public TipoRequerimento getTipo() {
        return tipo;
    }

    public Status getStatusAtual() {
        return statusAtual;
    }

    public Boleto getBoletoGerado() {
        return boletoGerado;
    }
    
    // SETTER OBRIGAT�RIO
    public void setBoletoGerado(Boleto boletoGerado) {
        this.boletoGerado = boletoGerado;
    }
}
