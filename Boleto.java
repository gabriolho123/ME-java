package modelo.entidades;

import java.util.Date;

public class Boleto {
    private String numeroBoleto;
    private Double valor; // <<< O ATRIBUTO VALOR
    private Date dataEmissao;
    private String statusPagamento; // AGUARDANDO_PAGAMENTO, QUITADO

    public Boleto(String numeroBoleto, Double valor) {
        this.numeroBoleto = numeroBoleto;
        this.valor = valor;
        this.dataEmissao = new Date();
        this.statusPagamento = "AGUARDANDO PAGAMENTO";
    }

    // *** ESTE M�TODO getValor() � O QUE ESTAVA FALTANDO OU COM PROBLEMA! ***
    public Double getValor() {
        return valor;
    }
    
    // M�todos
    public void registrarPagamento(Date dataPagamento) {
        this.statusPagamento = "QUITADO";
    }
}