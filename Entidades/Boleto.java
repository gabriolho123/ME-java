package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

public class Boleto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String numeroBoleto;
    private Double valor;
    private Date dataEmissao;
    private String statusPagamento; 
    
    // Construtor
    public Boleto(String numeroBoleto, Double valor) {
        this.numeroBoleto = numeroBoleto;
        this.valor = valor;
        this.dataEmissao = new Date(); 
        this.statusPagamento = "AGUARDANDO PAGAMENTO";
    }
    
    // MÉTODOS GET CORRIGIDOS E ADICIONADOS
    
    public String getNumero() {
        return this.numeroBoleto;
    }

    public Double getValor() {
        return this.valor;
    }
    
    // Outros métodos
    public void registrarPagamento(Date dataPagamento) {
        this.statusPagamento = "QUITADO";
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }
}