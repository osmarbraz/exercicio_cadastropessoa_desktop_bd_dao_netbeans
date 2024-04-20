package modelo;

public class Pessoa {

    private int pessoaId;
    private String nome;
    private String idade;
    private String dataNascimento;
    private String cidade;
    private String estadoCivil;

    @Override
    public String toString() {
        return "Pessoa{" + "pessoaId=" + pessoaId + ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", cidade=" + cidade + ", estadoCivil=" + estadoCivil + '}';
    }

    public Pessoa() {
        this(-1, "", "", "", "", "");
    }

    public Pessoa(int pessoaId, String nome, String idade, String dataNascimento, String cidade, String estadoCivil) {
        setPessoaId(pessoaId);
        setNome(nome);
        setIdade(idade);
        setDataNascimento(dataNascimento);
        setCidade(cidade);
        setEstadoCivil(estadoCivil);
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getIdade() {
        return idade;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
}
