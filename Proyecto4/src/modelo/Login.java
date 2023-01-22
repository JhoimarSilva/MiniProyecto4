package modelo;

public class Login {
    String password;
    int usuario;

    public Login(){

    }

    public Login(int usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
