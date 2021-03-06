package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocios.ControladorFuncionario;
import negocios.basicos.Funcionario;

import java.awt.SystemColor;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PopUpFuncionario extends JFrame {

	public static ControladorFuncionario cf = new ControladorFuncionario();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static ControladorFuncionario getCf() {
		return cf;
	}

	public static void setCf(ControladorFuncionario cf) {
		PopUpFuncionario.cf = cf;
	}

	/**
	 * Launch the application.a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					PopUpFuncionario frame = new PopUpFuncionario();
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
	public PopUpFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PopUpFuncionario.class.getResource("/images/IconPope.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 145, 145));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
						|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Favor, preencher tudo.");
				} else {
					Funcionario f = new Funcionario(textField.getText(), textField_1.getText(), textField_4.getText(),
							textField_2.getText(), textField_3.getText());

					if (cf.existeLoginSenha(f)) {
						JOptionPane.showMessageDialog(null, "Funcion?rio j? existe.");
					} else {
						cf.cadastrar(f);
						dispose();
						System.out.println(cf);

					}

				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(224, 205, 171, 45);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 145, 145));
		panel.setBounds(10, 11, 414, 183);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(1, 3, 58, 24);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(69, 0, 345, 27);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(5, 41, 54, 24);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(69, 38, 345, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Login:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(1, 76, 58, 27);
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(69, 76, 345, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(1, 114, 58, 27);
		panel.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBounds(69, 114, 345, 27);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tipo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(1, 152, 58, 27);
		panel.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBounds(69, 152, 345, 27);
		textField_4.setToolTipText("Valores permitidos: \"Gerente\" ou \"Funcionario\"");
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(43, 205, 171, 45);
		contentPane.add(btnNewButton_1);
	}

}
