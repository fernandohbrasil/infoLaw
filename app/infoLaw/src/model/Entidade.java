package model;

public class Entidade {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private Municipio oMunicipio;
    private String cep;
    private String bairro;
    private String rua;
    private String numero;
    private String cpf;
    private String rg;
    private String cnpj;
    private String ie;

    public Entidade() {
    }

    public Entidade(int id, String nome, String telefone, String email, Municipio oMunicipio, String cep, String bairro, String rua, String numero, String cpf, String rg, String cnpj, String ie) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.oMunicipio = oMunicipio;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cpf = cpf;
        this.rg = rg;
        this.cnpj = cnpj;
        this.ie = ie;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Municipio getoMunicipio() {
        return oMunicipio;
    }

    public void setoMunicipio(Municipio oMunicipio) {
        this.oMunicipio = oMunicipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
