package modelo.entidades;

public class Aluno extends Usuario {
    private String curso;

    public Aluno(String matricula, String nome) {
        super(matricula, nome); // Chama o construtor do Usuario
    }

    // Getters e Setters
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
