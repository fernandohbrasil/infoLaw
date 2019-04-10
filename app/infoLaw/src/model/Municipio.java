package model;

public class Municipio {

    private int id;
    private String nome;
    private String uf;
    private String cep;

    public Municipio() {
    }

    public Municipio(int id, String nome, String uf, String cep) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.cep = cep;
    }

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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Municipio{" + "nome=" + nome + '}';
    }
    
    

}
