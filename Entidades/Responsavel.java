package modelo.entidades;

public class Responsavel extends Usuario {
    private String setor;

    public Responsavel(String matricula, String nome) {
        super(matricula, nome); // Chama o construtor do Usuario
    }

    // Getters e Setters
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
