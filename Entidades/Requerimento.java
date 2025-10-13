package modelo.entidades;

import java.util.Date;
import java.io.Serializable;

public class Requerimento implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos
    private String numero;
    private Date dataSolicitacao;
    private String dadosSolicitacao;
    private String parecerFinal;
    private String statusFinal;
    private boolean taxaEhAplicavel;
    
    // Relacionamentos (Associações)
    private Aluno solicitante;
    private TipoRequerimento tipo;
    private Status statusAtual;
    private Boleto boletoGerado;
    private Responsavel responsavelAtual;

    // Construtor
    public Requerimento(String numero, Aluno solicitante, TipoRequerimento tipo) {
        this.numero = numero;
        this.solicitante = solicitante;
        this.tipo = tipo;
        this.statusAtual = new Status("PENDENTE"); // Status inicial padrão
        this.dataSolicitacao = new Date(); // Inicializa a data no momento da criação
    }

    // Métodos Operacionais
    
    /**
     * Define o Responsavel que está tratando o requerimento.
     */
    public void encaminhar(Responsavel novoResponsavel) {
        this.responsavelAtual = novoResponsavel;
    }
    
    /**
     * Altera o status atual do requerimento.
     */
    public void alterarStatus(Status novoStatus) {
        this.statusAtual = novoStatus;
    }
    
    // GETTERS (Essenciais para a GUI acessar os dados)
    
    public String getNumero() {
        return numero;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
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

    public Responsavel getResponsavelAtual() {
        return responsavelAtual;
    }

    public Boleto getBoletoGerado() {
        return boletoGerado;
    }

    // SETTERS
    
    public void setBoletoGerado(Boleto boletoGerado) {
        this.boletoGerado = boletoGerado;
    }

    public void setDadosSolicitacao(String dadosSolicitacao) {
        this.dadosSolicitacao = dadosSolicitacao;
    }

    public void setParecerFinal(String parecerFinal) {
        this.parecerFinal = parecerFinal;
    }

    public void setStatusFinal(String statusFinal) {
        this.statusFinal = statusFinal;
    }

    public void setTaxaEhAplicavel(boolean taxaEhAplicavel) {
        this.taxaEhAplicavel = taxaEhAplicavel;
    }
}
