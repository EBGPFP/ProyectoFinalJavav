import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        // Solicitar la elección del usuario
        String input = JOptionPane.showInputDialog(null,
                "Bienvenido. ¿Desea modificar la lista de doctores (1) o la de pacientes (2)?");

        if (input != null) {
            try {
                int opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 1:
                        JFrame p = new JFrame("Alta Doctor");
                        p.setContentPane(new AltaDoctorGUI().miPanel);
                        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        p.setSize(500, 250);
                        p.setVisible(true);
                        p.setLocationRelativeTo(null);
                        p.setTitle("Modificar lista de Doctores");
                        break;
                    case 2:
                        AltaPacienteGUI t = new AltaPacienteGUI();
                        t.setContentPane(t.miPanel);
                        t.setSize(500,250);
                        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        t.setVisible(true);
                        t.setTitle("Modificar lista de Pacientes");
                        t.setLocationRelativeTo(null);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, introduzca un número.");
            }
        }







    }
}