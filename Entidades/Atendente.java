package modelo.entidades;

import java.io.Serializable;

public class Atendente implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // Atributos b�sicos de um funcion�rio/atendente
    private String matricula;
    private String nome;
    private String setor; // Ex: "Secretaria", "Coordena��o", etc.

    // Construtor
    public Atendente(String matricula, String nome, String setor) {
        this.matricula = matricula;
        this.nome = nome;
        this.setor = setor;
    }

    // GETTERS

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    // SETTERS (Se for necess�rio alterar os dados ap�s a cria��o)
    
    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    // M�todo para exibir o nome do Atendente no console (opcional)
    @Override
    public String toString() {
        return this.nome + " (" + this.setor + ")";
    }
}
