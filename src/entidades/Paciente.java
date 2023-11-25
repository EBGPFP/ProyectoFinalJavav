package entidades;

import java.io.Serializable;

public class Paciente implements Serializable {
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String seguroSocial;
    private String sexo;

    public Paciente(String id, String nombre, String email, String telefono, String seguroSocial, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.seguroSocial = seguroSocial;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSeguroSocial() {
        return seguroSocial;
    }

    public void setSeguroSocial(String seguroSocial) {
        this.seguroSocial = seguroSocial;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}