package entidades;

import java.io.Serializable;

public class Administrador implements Serializable {
    private String id;
    private String nombre;
    private String sexo;

    private String email;

    private String password;
    private int accessLevel=1;

    public Administrador(String id, String nombre, String email, String password, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
