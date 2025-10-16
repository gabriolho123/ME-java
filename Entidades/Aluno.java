package modelo.entidades;

import java.io.Serializable;

public class Aluno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String matricula;
    private String nome;

    // Construtor ajustado para sua GUI
    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
