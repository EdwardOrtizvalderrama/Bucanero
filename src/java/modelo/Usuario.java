package modelo;

public class Usuario {
    private String user;
    private String pass;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

   
    public String getPass() {
        return pass;
    }
    
     public String getUser() {
        return user;
    }
}
