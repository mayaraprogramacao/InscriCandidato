package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class CandidatoGUI extends JFrame {

	
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textcpf;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JLabel lblTipo;
	private JLabel lblinscricao;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnProfessorEnsinoMedio;
	private JRadioButton rdbtnProfessorEnsinoSuperior;
	private JButton btnEnviar;
	private JButton btnLimpar;
	ButtonGroup rb;
	

	public CandidatoGUI() {
		Handler ouvinte = new Handler();
		setTitle("CONCURSO - INSCRIÇÃO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblinscricao = new JLabel("INSCRI\u00C7\u00C3O DE CANDIDATO");
		lblinscricao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblinscricao.setBounds(52, 34, 177, 21);
		contentPane.add(lblinscricao);
		
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(52, 83, 70, 21);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(52, 115, 177, 30);
		contentPane.add(textNome);
		textNome.setColumns(10);

		lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCPF.setBounds(52, 156, 70, 21);
		contentPane.add(lblCPF);

		textcpf = new JTextField();
		textcpf.setColumns(10);
		textcpf.setBounds(52, 188, 177, 30);
		contentPane.add(textcpf);

		lblTipo = new JLabel("CARGO");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(52, 229, 115, 21);
		contentPane.add(lblTipo);
		
		rdbtnNewRadioButton = new JRadioButton("Professor Ensino Fundamental");
		rdbtnNewRadioButton.setBounds(52, 250, 177, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnProfessorEnsinoMedio = new JRadioButton("Professor Ensino M\u00E9dio");
		rdbtnProfessorEnsinoMedio.setBounds(52, 274, 169, 23);
		contentPane.add(rdbtnProfessorEnsinoMedio);
		
		rdbtnProfessorEnsinoSuperior = new JRadioButton("Professor Ensino Superior");
		rdbtnProfessorEnsinoSuperior.setBounds(52, 300, 169, 24);
		contentPane.add(rdbtnProfessorEnsinoSuperior);
		
		rb = new ButtonGroup();
		rb.add(rdbtnNewRadioButton);
		rb.add(rdbtnProfessorEnsinoMedio);
		rb.add(rdbtnProfessorEnsinoSuperior);

		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(151, 331, 89, 23);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(ouvinte);

		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(52, 331, 89, 23);
		contentPane.add(btnLimpar);
		btnLimpar.addActionListener(ouvinte);
		
		setVisible(true);
		
	}
	public void limpar() {
		textNome.setText("");
		textcpf.setText("");
	} 
		public class Handler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLimpar) {
					limpar();
				}
				else {
					if(e.getSource()==btnEnviar) {
						String nome = textNome.getText();
						String cpf = textcpf.getText();
						String cargo = rb.getSelection().toString();
						if((nome.equals(""))|| (cpf.equals(""))||(cargo.equals(""))) {
							JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "ATENÇÃO!!", 2, null);
						}
						else {
							
							if((!nome.equals(""))&&(!cpf.equals(""))&&(!cargo.equals(""))) {
								JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!", "SUCESSO!!", 1, null);
								limpar();
								
							}
						}
					}
				}
				
			}
			
		}
	
	}
