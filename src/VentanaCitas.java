import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.GestionarEntidades;
import entidades.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class VentanaCitas extends JFrame {
    private JTextField txtPaciente;
    private JTextField txtDoctor;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtObservaciones;
    private JButton btnCrear;
    private JButton btnLimpiar;
    private JLabel lblPaciente;
    private JLabel lblDoctor;
    private JLabel lblFecha;
    private JLabel lblHora;
    private JLabel lblObservaciones;
    private JPanel miPanel;
    private JButton regresarAlMenúButton;

    GestionarEntidades gestor = new GestionarEntidades();

    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
    DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_TIME;
    public VentanaCitas() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (camposVacios()) {
                    JOptionPane.showMessageDialog(miPanel, "Es necesario llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    Focus();
                } else {

                //Vamos a verificar que existan los nombres de pacientes y doctores en las bases de datos

                    if (gestor.buscarPacientePorNombre(txtPaciente.getText())){

                        if (gestor.buscarDoctorPorNombre(txtDoctor.getText())){

                        //Ahora vamos a pasar a las validaciones de fecha y hora


                            if (!fechaValida(txtFecha.getText())) {
                                JOptionPane.showMessageDialog(miPanel, "La fecha debe estar en formato YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            if (!horaValida(txtHora.getText())) {
                                JOptionPane.showMessageDialog(miPanel, "La hora debe estar en formato HH-mm", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            Cita nuevaCita = new Cita(
                                    txtPaciente.getText(),
                                    txtDoctor.getText(),
                                    txtFecha.getText(),
                                    txtHora.getText(),
                                    txtObservaciones.getText()
                            );
                            nuevaCita.setId(nuevaCita.generarId());
                            gestor.agregarCita(nuevaCita);
                            JOptionPane.showMessageDialog(miPanel,"Cita Creada con éxito");


                        }else{
                            JOptionPane.showMessageDialog(miPanel,"El Doctor ingresado no existe");
                        }


                    } else {
                        JOptionPane.showMessageDialog(miPanel,"El Paciente ingresado no existe");
                        return;
                    }





                }



            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        regresarAlMenúButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] nuevo = {VentanaLogin.tipo_Usuario};
                VentanaMenu.main(nuevo);
            }
        });
    }


    private void limpiarCampos() {
        txtPaciente.setText("");
        txtDoctor.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtObservaciones.setText("");
    }


    private void Focus() {
        if (txtPaciente.getText().isEmpty()) {
            txtPaciente.requestFocus();
        } else if (txtDoctor.getText().isEmpty()) {
            txtDoctor.requestFocus();
        } else if (txtFecha.getText().isEmpty()) {
            txtFecha.requestFocus();
        } else if (txtHora.getText().isEmpty()) {
            txtHora.requestFocus();
        }else if (txtObservaciones.getText().isEmpty()) {
            txtObservaciones.requestFocus();
        }
    }


    private boolean camposVacios() {
        return txtPaciente.getText().isEmpty() ||
                txtDoctor.getText().isEmpty() ||
                txtFecha.getText().isEmpty() ||
                txtHora.getText().isEmpty()||
                txtObservaciones.getText().isEmpty();
    }

    public boolean fechaValida(String date) {
        try {
            LocalDate.parse(date, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean horaValida(String time) {
        try {
            LocalTime.parse(time, timeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        VentanaCitas p = new VentanaCitas();
        p.setContentPane(p.miPanel);
        p.setSize(500,250);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setTitle("Crear Cita");
        p.setLocationRelativeTo(null);
    }
}
