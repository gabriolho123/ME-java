package modelo.entidades;

// O erro no super(matricula, nome) deve sumir ap�s corrigir Usuario.java
public class Caixa extends Usuario {

    public Caixa(String matricula, String nome) { 
        super(matricula, nome); 
    }

    // M�todo de simula��o de pagamento
    public boolean registrarPagamento(Boleto boleto) {
        if (boleto != null) {
            boleto.registrarPagamento(new java.util.Date()); 
            return true;
        }
        return false;
    }
}
