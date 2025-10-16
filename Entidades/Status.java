package modelo.entidades;

import java.io.Serializable;

public class Status implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nome;

    public Status(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
