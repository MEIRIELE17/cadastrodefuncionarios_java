package conexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class USUARIO extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					USUARIO frame = new USUARIO();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public USUARIO() {
		setResizable(false);
		setTitle("Tela de login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 254);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(128, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBackground(new Color(255, 255, 255));
		lblUsuario.setBounds(79, 50, 57, 33);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(128, 0, 0));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBackground(new Color(255, 255, 255));
		lblSenha.setBounds(79, 100, 50, 33);
		contentPane.add(lblSenha);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(149, 50, 115, 33);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);

		pfSenha = new JPasswordField();
		pfSenha.setBounds(149, 100, 115, 33);
		contentPane.add(pfSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(240, 228, 142));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setForeground(new Color(128, 0, 64));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = conexao1.conecta_cadastro();

					String sql = "select *from login where usuario=? and senha=?";

					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pfSenha.getPassword()));

					ResultSet rs = stmt.executeQuery();

					if (rs.next()) {

						Tela_cadastro_funcionarios exibir = new Tela_cadastro_funcionarios();
						exibir.setVisible(true);

						setVisible(false);

					} else {

						JOptionPane.showMessageDialog(null, "Dados incorretos!");

					}

					stmt.close();
					con.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnEntrar.setBounds(79, 155, 185, 40);
		contentPane.add(btnEntrar);

	}
}
