import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class VentanaMenu extends JFrame {
    private JTextField txtNombreDeUsuario;
    private JLabel lblBienvenido;
    private JLabel lblTipoDeUsuario;
    private JButton btnPacientes;
    private JButton btnDoctores;
    private JButton btnCrearCita;
    private JPanel miPanel;
    private JButton cerrarSesiónButton;


    public VentanaMenu() {
        btnPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] nuevo = {VentanaLogin.tipo_Usuario};
                AltaPacienteGUI.main(nuevo);
            }
        });
        btnDoctores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] nuevo = {VentanaLogin.tipo_Usuario};
                AltaPacienteGUI.main(nuevo);
            }
        });
        btnCrearCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] nuevo = {};
                AltaPacienteGUI.main(nuevo);
            }
        });
        cerrarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] nuevo = {};
                VentanaLogin.main(nuevo);
            }
        });
    }

    public static void main(String[] args) {
        VentanaMenu p = new VentanaMenu();
        p.setContentPane(p.miPanel);
        p.setSize(500,250);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setTitle("Vita Clinic Menú");
        p.setLocationRelativeTo(null);

        p.lblTipoDeUsuario.setText(VentanaLogin.tipo_Usuario);
        p.txtNombreDeUsuario.setText(VentanaLogin.nombreDeUsuario);
        if (Objects.equals(VentanaLogin.tipo_Usuario, "Paciente")){
            p.btnCrearCita.setEnabled(false);
        }
    }

}
