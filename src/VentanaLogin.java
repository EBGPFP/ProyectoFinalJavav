import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.GestionarEntidades;
import entidades.Registro;

public class VentanaLogin extends JFrame {
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JLabel lblEmail;
    private JLabel lblpassword;
    private JButton btnIngresar;
    private JButton btnRegistrarse;
    private JPanel miPanel;
    private JButton cerrarSesiónButton;

    public static String tipo_Usuario;

    public static String nombreDeUsuario;
    GestionarEntidades gestor = new GestionarEntidades();



    private boolean camposVacios() {
        return txtEmail.getText().isEmpty() ||
                txtPassword.getText().isEmpty();
    }

    private void Focus() {
        if (txtEmail.getText().isEmpty()) {
            txtEmail.requestFocus();
        } else if (txtPassword.getText().isEmpty()) {
            txtPassword.requestFocus();
        }
    }

    public VentanaLogin() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (camposVacios()) {
                    JOptionPane.showMessageDialog(miPanel, "Es necesario llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    Focus();
                } else {

                    Registro registroTemporal = gestor.buscarRegistro(txtEmail.getText(),txtPassword.getText());
                    if (registroTemporal==null){
                        JOptionPane.showMessageDialog(miPanel,"El correo o las credenciales son incorrectas");
                    }else{
                        JOptionPane.showMessageDialog(miPanel,"Bienvenido "+registroTemporal.getNombre());
                        tipo_Usuario=registroTemporal.getUserType();
                        nombreDeUsuario= registroTemporal.getNombre();

                        dispose();
                        String [] nuevo = {VentanaLogin.tipo_Usuario,nombreDeUsuario};
                        VentanaMenu.main(nuevo);


                    }



                }
            }
        });
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] nuevo = {};
                VentanaRegistro.main(nuevo);
            }
        });
    }

    public static void main(String[] args) {
        VentanaLogin p = new VentanaLogin();
        p.setContentPane(p.miPanel);
        p.setSize(500,250);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setTitle("Vita Clinic Login");
        p.setLocationRelativeTo(null);
    }
}
