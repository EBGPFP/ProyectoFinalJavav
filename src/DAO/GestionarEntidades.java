package DAO;

import entidades.Doctor;
import entidades.Paciente;
import entidades.Administrador;
import entidades.Cita;
import entidades.Registro;

import java.util.List;

public class GestionarEntidades {

    public void agregarPaciente(Paciente paciente) {
        List<Paciente> pacientes = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaPacientes.txt");
        pacientes.add(paciente);
        ArchivoUtil.escribirObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaPacientes.txt", pacientes);
    }

    public void agregarCita(Cita cita) {
        List<Cita> citas = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaCitas.txt");
        citas.add(cita);
        ArchivoUtil.escribirObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaCitas.txt", citas);
    }

    public void agregarRegistro(Registro registro) {
        List<Registro> registros = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaRegistrados.txt");
        registros.add(registro);
        ArchivoUtil.escribirObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaRegistrados.txt", registros);
    }

    public void agregarDoctor(Doctor doctor) {
        List<Doctor> doctores = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaDoctores.txt");
        doctores.add(doctor);
        ArchivoUtil.escribirObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaDoctores.txt", doctores);
    }

    public void agregarAdministrador(Administrador administrador) {
        List<Administrador> admins = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaAdministrador.txt");
        admins.add(administrador);
        ArchivoUtil.escribirObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaAdministrador.txt", admins);
    }

    public Administrador buscarAdministradorPorId(String id) {
        List<Administrador> admins = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaAdministrador.txt");
        for (Administrador administrador : admins) {
            if (administrador.getId().equals(id)) {
                return administrador;
            }
        }
        return null; // Si no se encuentra el paciente con ese ID
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

    public Registro buscarRegistro(String email,String password) {
        List<Registro> registros = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaRegistrados.txt");
        for (Registro registro : registros) {
            if (registro.getEmail().equals(email) && registro.getPassword().equals(password)) {
                return registro;
            }
        }

        return null; // Si no se encuentra en el archivo
    }

    public boolean buscarPacientePorNombre(String nombre) {
        List<Paciente> pacientes = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaPacientes.txt");
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false; // Si no se encuentra el paciente con ese nombre
    }

    public boolean buscarDoctorPorNombre(String nombre) {
        List<Doctor> doctores = ArchivoUtil.leerObjetos("C:\\Users\\brrrg\\Downloads\\ProyectofinalPruebas\\ListaDoctores.txt");
        for (Doctor doctor : doctores) {
            if (doctor.getNombre().equals(nombre)) {
                return true;
            }
        }

        return false; // Si no se encuentra al Doctor con ese Nombre
    }





}