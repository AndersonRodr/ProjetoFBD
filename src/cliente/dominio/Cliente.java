package cliente.dominio;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private PessoaFisica pFisica;
    private PessoaJuridica pJuridica;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
        public PessoaFisica getpFisica() {
        return pFisica;
    }

    public void setpFisica(PessoaFisica pFisica) {
        this.pFisica = pFisica;
    }

    public PessoaJuridica getpJuridica() {
        return pJuridica;
    }

    public void setpJuridica(PessoaJuridica pJuridica) {
        this.pJuridica = pJuridica;
    }
}
