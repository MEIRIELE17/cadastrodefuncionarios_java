package conexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Tela_cadastro_funcionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNome;
	private JTextField tfCargo;
	private JTextField tfSalario;
	private JTextField tfEmail;
	private JPanel panel;
	private JButton btnSalvar;
	private JScrollPane scrollPane;
	private JTable tabela_dados;
	private JButton btnListar;
	private JButton btnAtualizar;
	private JButton btnAbrir;
	private JTextField tfBuscar;
	private JButton btnExcluir;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro_funcionarios frame = new Tela_cadastro_funcionarios();
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
	public Tela_cadastro_funcionarios() {
		setTitle("Cadastro de funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setForeground(new Color(128, 0, 64));
		lblId.setBackground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 11, 48, 25);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(128, 0, 64));
		lblNome.setBackground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 40, 48, 25);
		contentPane.add(lblNome);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(new Color(128, 0, 64));
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCargo.setBounds(10, 67, 48, 16);
		contentPane.add(lblCargo);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setForeground(new Color(128, 0, 64));
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalario.setBounds(10, 92, 48, 14);
		contentPane.add(lblSalario);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(128, 0, 64));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 117, 48, 14);
		contentPane.add(lblEmail);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(56, 13, 296, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(56, 40, 760, 20);
		contentPane.add(tfNome);
		
		tfCargo = new JTextField();
		tfCargo.setColumns(10);
		tfCargo.setBounds(56, 65, 760, 20);
		contentPane.add(tfCargo);
		
		tfSalario = new JTextField();
		tfSalario.setColumns(10);
		tfSalario.setBounds(56, 89, 760, 20);
		contentPane.add(tfSalario);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(56, 117, 760, 20);
		contentPane.add(tfEmail);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 148, 806, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(new Color(128, 0, 64));
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Informe o Id");
					
				}else {
				
				try {
					
					Connection con = conexao1.conecta_cadastro();
					
					// atualizar a tabela a partir do id
					
					String sql = "update cadastro_dados set nome=?, cargo=?, salario=?, email=? where id=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
												
					stmt.setString(1, tfNome.getText());
					stmt.setString(2, tfCargo.getText());
					stmt.setString(3, tfSalario.getText());
					stmt.setString(4, tfEmail.getText());
					stmt.setString(5, tfId.getText());
					
					stmt.execute();
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Atualização realizada!");
					
								
										
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
				
			}
		});
		btnAtualizar.setBounds(408, 37, 153, 21);
		panel.add(btnAtualizar);
		
		btnAbrir = new JButton("Abrir Id");
		btnAbrir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbrir.setBackground(new Color(240, 228, 142));
		btnAbrir.setForeground(new Color(128, 0, 64));
		btnAbrir.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				if(tfBuscar.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o Id");
					
					
				}else {
					
				
								
				try {
										
					Connection con = conexao1.conecta_cadastro();
					String sql = "select * from cadastro_dados where id like ?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					//capturar  para identificar o parametro solicitado//
					
					stmt.setString(1, "%"+tfBuscar.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					//verificar uma forma de quando não tiver o "Id" os campos ficarem em branco//
					
					
					while (rs.next()) {
						
						tfId.setText(rs.getString("id"));
						tfNome.setText(rs.getString("nome"));
						tfCargo.setText(rs.getString("cargo"));
						tfSalario.setText(rs.getString("salario"));
						tfEmail.setText(rs.getString("email"));
					
						
					} 
					
					rs.close();
					con.close();
					
					
										
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
				}
			}
		});
		
		tfBuscar = new JTextField();
		tfBuscar.setBackground(new Color(240, 228, 142));
		tfBuscar.setBounds(31, 37, 89, 20);
		panel.add(tfBuscar);
		tfBuscar.setColumns(10);
		btnAbrir.setBounds(31, 11, 89, 22);
		panel.add(btnAbrir);
		
		btnListar = new JButton("Listar funcionarios");
		btnListar.setForeground(new Color(128, 0, 64));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setBounds(190, 11, 583, 22);
		panel.add(btnListar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(128, 0, 64));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//esta condição establece que se o clicar no icone exluir//
				//e o campo estiver em branco não há exclusão de nada, pede para "Informe o Id""//
				
				if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o Id!");
					
				}else {
									
								
				//conectei todas as telas conforme "conexao1.java"//
			
				try {
					
					
					Connection con = conexao1.conecta_cadastro();
					
				String sql = "delete from cadastro_dados where id=?";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				
				//para executar a solicitação acima//
				
				stmt.setString(1, tfId.getText());
				
				stmt.execute();
				stmt.close();
				con.close();
				
				JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
				
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
				
			}
				
			}
		});
		btnExcluir.setBounds(628, 36, 145, 22);
		panel.add(btnExcluir);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(128, 0, 64));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(190, 36, 145, 22);
		panel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//foi inserido um "if" para quando não tiver nada preenchido, não salvar nada em branco, informará "Dados incompletos"//
				
				if(tfNome.getText().equals("")|| tfCargo.getText().equals("") || tfSalario.getText().equals("") || tfEmail.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Dados incompletos");
					
				}else {
				
				try {
					
					Connection con = conexao1.conecta_cadastro();
					String sql = "INSERT INTO cadastro_dados(nome, cargo, salario, email) values (?, ?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfNome.getText());
					stmt.setString(2, tfCargo.getText());
					stmt.setDouble(3, Double.parseDouble(tfSalario.getText()));
					stmt.setString(4, tfEmail.getText());
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					
					//utilizei setText("") com campo vazio para que apos salvo os dados se apaguem
					
					tfNome.setText("");
					tfCargo.setText("");   
					tfSalario.setText("");
					tfEmail.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	
			}
			}    //fechamento do "else", pois se todos dados preenchidos roda normal o código inserido//
		});
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				Connection con = conexao1.conecta_cadastro();
				
				String sql =  "Select  *from cadastro_dados";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				// realiza uma consuta ao banco de dados//
				
				ResultSet rs= stmt.executeQuery();
				
				DefaultTableModel modelo = (DefaultTableModel) tabela_dados.getModel();
				modelo.setNumRows(0);
				
				
				//solicitar que percorra o banco de dados para identificar que sempre retornar verdade
				while (rs.next()) {
					modelo.addRow(new Object[] {rs.getString("id"), rs.getString("nome"), rs.getString("cargo"), rs.getString("salario"), rs.getString("email")});
					
					
				}
				
				//para fechar a conexão e nenhum banco ficar aberto
				
				rs.close();
				con.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
			}
			
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 228, 806, 285);
		contentPane.add(scrollPane);
		
		tabela_dados = new JTable();
		tabela_dados.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabela_dados.setBackground(new Color(255, 255, 255));
		tabela_dados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Cargo", "Salario", "Email"
			}
		));
		scrollPane.setViewportView(tabela_dados);

	}
}
