package entidades;

import java.io.Serializable;

public class Registro implements Serializable {

    private String nombre;
    private String email;
    private String password;
    private String userType;

    public Registro(String nombre,String email, String password, String userType) {
        this.nombre= nombre;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}