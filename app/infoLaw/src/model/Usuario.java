package model;

public class Usuario {
    private int id;
    private int senha;
    private String username;
    private boolean administrador;

    private static Usuario uniqueInstance;

    private Usuario() {

    }

    public static Usuario getInstance() {
        synchronized (Usuario.class) {
            if (uniqueInstance == null) {                
                uniqueInstance = new Usuario();
            }
        }        
        return uniqueInstance;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", senha=" + senha + ", username=" + username + ", administrador=" + administrador + '}';
    }        
}
