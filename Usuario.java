package modelo.entidades;

// *** MUDE PARA public abstract class Usuario ***
public abstract class Usuario { 
    private String matricula;
    private String nome;
    private String email;
    
    // Construtor que as classes filhas (Caixa, Aluno, etc.) CHAMAM
    public Usuario(String matricula, String nome) { 
        this.matricula = matricula;
        this.nome = nome;
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }
}