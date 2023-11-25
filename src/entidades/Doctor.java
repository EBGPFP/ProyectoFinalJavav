package entidades;

import java.io.Serializable;

public class Doctor implements Serializable {
    private String id;
    private String nombre;
    private String especialidad;
    private String telefono;
    private String sexo;

    public Doctor(String id, String nombre, String especialidad, String telefono, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


}