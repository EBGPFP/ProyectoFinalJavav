package DAO;

import entidades.Doctor;
import entidades.Paciente;

import java.util.List;

public class GestionarEntidades {

    public void agregarPaciente(Paciente paciente) {
        List<Paciente> pacientes = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaPacientes.txt");
        pacientes.add(paciente);
        ArchivoUtil.escribirObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaPacientes.txt", pacientes);
    }

    public void agregarDoctor(Doctor doctor) {
        List<Doctor> doctores = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaDoctores.txt");
        doctores.add(doctor);
        ArchivoUtil.escribirObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaDoctores.txt", doctores);
    }

    public Paciente buscarPacientePorId(String id) {
        List<Paciente> pacientes = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaPacientes.txt");
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null; // Si no se encuentra el paciente con ese ID
    }

    public Doctor buscarDoctorPorId(String id) {
        List<Doctor> doctores = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaDoctores.txt");
        for (Doctor doctor : doctores) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }

        return null; // Si no se encuentra al Doctor con ese ID
    }


}