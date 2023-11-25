import entidades.Doctor;
import entidades.Paciente;
import DAO.GestionarEntidades;
import entidades.Registro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro extends JFrame {
    private JComboBox cmbUser_type;
    private JButton btnRegistrar;
    private JButton btnRegresar;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JLabel lblNombre;
    private JLabel lbllEmail;
    private JLabel lblPassword;
    private JLabel lblUser_type;
    private JPanel miPanel;




    GestionarEntidades gestor = new GestionarEntidades();

    public VentanaRegistro() {
    btnRegistrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(miPanel, "Es necesario llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                Focus();
            } else {
                Registro nuevoRegistro = new Registro(
                        txtNombre.getText(),
                        txtEmail.getText(),
                        txtPassword.getText(),
                        cmbUser_type.getSelectedItem().toString()
                );
                gestor.agregarRegistro(nuevoRegistro);
                JOptionPane.showMessageDialog(miPanel,"Registro exitoso!");
                limpiarCampos();
            }
        }
    });
    btnRegresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            String [] nuevo = {};
            VentanaLogin.main(nuevo);
        }
    });
}


    private boolean camposVacios() {
        return txtNombre.getText().isEmpty() ||
                txtEmail.getText().isEmpty() ||
                txtPassword.getText().isEmpty() ||
                cmbUser_type.getSelectedItem() == "" ;
    }



    private void Focus() {
        if (txtNombre.getText().isEmpty()) {
            txtNombre.requestFocus();
        } else if (txtEmail.getText().isEmpty()) {
            txtEmail.requestFocus();
        } else if (txtPassword.getText().isEmpty()) {
            txtPassword.requestFocus();
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        cmbUser_type.setSelectedIndex(-1);
    }





    public static void main(String[] args) {
        VentanaRegistro p = new VentanaRegistro();
        p.setContentPane(p.miPanel);
        p.setSize(500,250);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setTitle("Vita Clinic Registro");
        p.setLocationRelativeTo(null);
    }
}
