import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import DAO.GestionarEntidades;
import entidades.Doctor;

public class AltaDoctorGUI extends JFrame {
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtEspecialidad;
    private JTextField txtTeléfono;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnRegresar;
    private JButton btnLimpiar;
    JPanel miPanel;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblEspecialidad;
    private JLabel lblTeléfono;
    private JLabel lblSexo;
    private JComboBox cmbSexo;


    private GestionarEntidades gestor = new GestionarEntidades();

    public AltaDoctorGUI() {
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (camposVacios()) {
                    JOptionPane.showMessageDialog(miPanel, "Es necesario llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    Focus();
                } else {

                    Doctor nuevoDoctor = new Doctor(
                            txtID.getText(),
                            txtNombre.getText(),
                            txtEspecialidad.getText(),
                            txtTeléfono.getText(),
                            cmbSexo.getSelectedItem().toString()
                    );
                    gestor.agregarDoctor(nuevoDoctor);
                    JOptionPane.showMessageDialog(miPanel,"Doctor agregado con éxito");
                    limpiarCampos();
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (txtID.getText().isEmpty()){
                        JOptionPane.showMessageDialog(miPanel,"El campo ID no puede estar vacío");
                        txtID.requestFocus();
                        return;

                    }

                Doctor DoctorTemporal = gestor.buscarDoctorPorId(txtID.getText());
                if (DoctorTemporal==null){
                    JOptionPane.showMessageDialog(miPanel,"No se encontró al Doctor con el ID proporcionado");
                }else{
                    txtNombre.setText(DoctorTemporal.getNombre());
                    txtTeléfono.setText(DoctorTemporal.getTelefono());
                    cmbSexo.setSelectedItem(DoctorTemporal.getSexo());
                    txtEspecialidad.setText(DoctorTemporal.getEspecialidad());
                }
            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] nuevo = {VentanaLogin.tipo_Usuario};
                VentanaMenu.main(nuevo);
            }
        });
    }

    private void Focus() {
        if (txtID.getText().isEmpty()) {
            txtID.requestFocus();
        } else if (txtNombre.getText().isEmpty()) {
            txtNombre.requestFocus();
        } else if (txtEspecialidad.getText().isEmpty()) {
            txtEspecialidad.requestFocus();
        } else if (txtTeléfono.getText().isEmpty()) {
            txtTeléfono.requestFocus();
        }else if (cmbSexo.getSelectedItem() == null) {
            cmbSexo.requestFocus();
        }
    }

    private boolean camposVacios() {
        return txtID.getText().isEmpty() ||
                txtNombre.getText().isEmpty() ||
                txtEspecialidad.getText().isEmpty() ||
                cmbSexo.getSelectedItem() == "" ||
                txtTeléfono.getText().isEmpty();
    }

    private void limpiarCampos() {
        txtID.setText("");
        txtNombre.setText("");
        txtEspecialidad.setText("");
        cmbSexo.setSelectedIndex(-1);
        txtTeléfono.setText("");
    }

    public static void main(String[] args) {
        AltaDoctorGUI p = new AltaDoctorGUI();
        p.setContentPane(p.miPanel);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setSize(500, 250);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        p.setTitle("Modificar lista de Doctores");

        if (Objects.equals(VentanaLogin.tipo_Usuario, "Paciente")){
            p.btnAgregar.setEnabled(false);
        }

    }
}