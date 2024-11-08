package dominio;

public class Curso {

    private int codigo;
    private String nome;
    private String descricao;
    private int cargahr;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargahr() {
        return cargahr;
    }

    public void setCargahr(int cargahr) {
        this.cargahr = cargahr;
    }

    public Curso() {

    }

    public Curso(int codigo, String nome, String descricao, int cargahr) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargahr = cargahr;
    }
}