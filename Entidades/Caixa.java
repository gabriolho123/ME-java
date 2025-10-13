package modelo.entidades;

// O erro no super(matricula, nome) deve sumir após corrigir Usuario.java
public class Caixa extends Usuario {

    public Caixa(String matricula, String nome) { 
        super(matricula, nome); 
    }

    // Método de simulação de pagamento
    public boolean registrarPagamento(Boleto boleto) {
        if (boleto != null) {
            boleto.registrarPagamento(new java.util.Date()); 
            return true;
        }
        return false;
    }
}
