import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import DAO.GestionarEntidades;
import entidades.Paciente;


public class AltaPacienteGUI extends JFrame {

    JPanel miPanel;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnRegresar;
    private JTextField txtSeguroSocial;
    private JTextField txtTeléfono;
    private JButton btnLimpiar;
    private JLabel lblnombre;
    private JLabel lblEmail;
    private JLabel lblTeléfono;
    private JLabel lblNúmSocial;
    private JTextField txtID;
    private JLabel lblID;
    private JComboBox cmbSexo;
    private JLabel lblSexo;



    private GestionarEntidades gestor2 = new GestionarEntidades();

    public AltaPacienteGUI() {
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
                    Paciente nuevoPaciente = new Paciente(
                            txtID.getText(),
                            txtNombre.getText(),
                            txtEmail.getText(),
                            txtTeléfono.getText(),
                            txtSeguroSocial.getText(),
                            cmbSexo.getSelectedItem().toString()
                    );
                    gestor2.agregarPaciente(nuevoPaciente);
                    JOptionPane.showMessageDialog(miPanel,"Paciente agregado con éxito");
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

                Paciente PacienteTemporal = gestor2.buscarPacientePorId(txtID.getText());
                if (PacienteTemporal==null){
                    JOptionPane.showMessageDialog(miPanel,"No se encontró al Paciente con el ID proporcionado");
                }else{
                    txtNombre.setText(PacienteTemporal.getNombre());
                    txtEmail.setText(PacienteTemporal.getEmail());
                    txtTeléfono.setText(PacienteTemporal.getTelefono());
                    cmbSexo.setSelectedItem(PacienteTemporal.getSexo());
                    txtSeguroSocial.setText(PacienteTemporal.getSeguroSocial());
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
        } else if (txtEmail.getText().isEmpty()) {
            txtEmail.requestFocus();
        } else if (txtTeléfono.getText().isEmpty()) {
            txtTeléfono.requestFocus();
        } else if (txtSeguroSocial.getText().isEmpty()) {
            txtSeguroSocial.requestFocus();
        } else if (cmbSexo.getSelectedItem() == null) {
            cmbSexo.requestFocus();
        }
    }


    private boolean camposVacios() {
        return txtNombre.getText().isEmpty() ||
                txtEmail.getText().isEmpty() ||
                txtTeléfono.getText().isEmpty() ||
                cmbSexo.getSelectedItem() == "" ||
                txtSeguroSocial.getText().isEmpty();
    }

    private void limpiarCampos() {
        txtID.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
        txtTeléfono.setText("");
        cmbSexo.setSelectedIndex(-1);
        txtSeguroSocial.setText("");

    }

    public static void main(String[] args) {
        AltaPacienteGUI p = new AltaPacienteGUI();
        p.setContentPane(p.miPanel);
        p.setSize(500,250);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setTitle("Modificar lista de Pacientes");
        p.setLocationRelativeTo(null);


        if (Objects.equals(VentanaLogin.tipo_Usuario, "Paciente")){
            p.btnAgregar.setEnabled(false);
        }
    }
}
