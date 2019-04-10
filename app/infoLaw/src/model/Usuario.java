package model;

public class Usuario {

    private int id;
    private int senha;
    private String email;
    private boolean administrador;
    private boolean numeroseguranca;

    public Usuario() {
    }

    public Usuario(int id, int senha, String email, boolean administrador, boolean numeroseguranca) {
        this.id = id;
        this.senha = senha;
        this.email = email;
        this.administrador = administrador;
        this.numeroseguranca = numeroseguranca;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isNumeroseguranca() {
        return numeroseguranca;
    }

    public void setNumeroseguranca(boolean numeroseguranca) {
        this.numeroseguranca = numeroseguranca;
    }
    
    

}
