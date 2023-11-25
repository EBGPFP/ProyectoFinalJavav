package entidades;

import java.io.Serializable;

public class Cita implements Serializable {



    private static int contadorId = 1;

    private String id;
    private String paciente;
    private String doctor;
    private String fecha;
    private String hora;
    private String observaciones;

    // Constructor vacío
    public Cita() {
    }

    // Constructor con parámetros
    public Cita(String paciente, String doctor, String fecha, String hora, String observaciones) {

        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.observaciones = observaciones;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    // Método para generar un ID automático
    public String generarId() {
        return String.valueOf(contadorId++);
    }


}

