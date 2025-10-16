package modelo.entidades;

import java.io.Serializable;

public class Atendente implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // Atributos básicos de um funcionário/atendente
    private String matricula;
    private String nome;
    private String setor; // Ex: "Secretaria", "Coordenação", etc.

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

    // SETTERS (Se for necessário alterar os dados após a criação)
    
    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    // Método para exibir o nome do Atendente no console (opcional)
    @Override
    public String toString() {
        return this.nome + " (" + this.setor + ")";
    }
}