package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import negocios.basicos.Venda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaControleVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtInicio;
	private JTextField txtFim;
	private JTextField campoCliente;
	private JTextField campoFunc;
	private JTextField campoArea;
	private boolean filtroCliente = false;
	private boolean filtroFuncionario = false;
	private boolean filtroArea = false;
	private boolean filtroPeriodo = false;

	private String aux[] = { "Funcionario", "Cliente", "Area", "Data/Hora", "Valor Total" };
	private DefaultTableModel dtm = new DefaultTableModel(aux, 0);

	/**
	 * Launch the application.aa
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaControleVendas frame = new TelaControleVendas();
					frame.setLocationRelativeTo(null);
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
	// da funcao recebe os filtros relativos aos botes e atualiza a tabela em funcao
	// dos mesmos.
	public void atualizar() {

		if (filtroArea == false && filtroFuncionario == false && filtroCliente == false && filtroPeriodo == false) {
			dtm.setRowCount(0);
			int tamanho = TelaNovaVenda.getCv().getRepositorioVendas().getVendas().size();
			ArrayList<Venda> arrays = new ArrayList<>();
			arrays.addAll(TelaNovaVenda.getCv().getRepositorioVendas().getVendas());
			for (int i = 0; i < tamanho; i++) {

				Object[] objs = { arrays.get(i).getFuncionario().getNome(),
						arrays.get(i).getCarrinho().getCliente().getNome(),
						arrays.get(i).getCarrinho().getCliente().getEndereco(), arrays.get(i).getDatahora(),
						arrays.get(i).getCarrinho().getValorTotal() };
				dtm.addRow(objs);

			}

		} else if (filtroArea) {
			dtm.setRowCount(0);
			int tamanho = TelaNovaVenda.getCv().getRepositorioVendas().getVendas().size();
			ArrayList<Venda> arrays = new ArrayList<>();
			arrays.addAll(TelaNovaVenda.getCv().getRepositorioVendas().getVendas());
			for (int i = 0; i < tamanho; i++) {
				if (campoArea.getText().equalsIgnoreCase(arrays.get(i).getCarrinho().getCliente().getEndereco())) {
					Object[] objs = { arrays.get(i).getFuncionario().getNome(),
							arrays.get(i).getCarrinho().getCliente().getNome(),
							arrays.get(i).getCarrinho().getCliente().getEndereco(), arrays.get(i).getDatahora(),
							arrays.get(i).getCarrinho().getValorTotal() };
					dtm.addRow(objs);

				}

			}
		} else if (filtroFuncionario) {
			dtm.setRowCount(0);
			int tamanho = TelaNovaVenda.getCv().getRepositorioVendas().getVendas().size();
			ArrayList<Venda> arrays = new ArrayList<>();
			arrays.addAll(TelaNovaVenda.getCv().getRepositorioVendas().getVendas());
			for (int i = 0; i < tamanho; i++) {
				if (campoFunc.getText().equalsIgnoreCase(arrays.get(i).getFuncionario().getNome())) {
					Object[] objs = { arrays.get(i).getFuncionario().getNome(),
							arrays.get(i).getCarrinho().getCliente().getNome(),
							arrays.get(i).getCarrinho().getCliente().getEndereco(), arrays.get(i).getDatahora(),
							arrays.get(i).getCarrinho().getValorTotal() };
					dtm.addRow(objs);

				}

			}
		} else if (filtroCliente) {
			dtm.setRowCount(0);
			int tamanho = TelaNovaVenda.getCv().getRepositorioVendas().getVendas().size();
			ArrayList<Venda> arrays = new ArrayList<>();
			arrays.addAll(TelaNovaVenda.getCv().getRepositorioVendas().getVendas());
			for (int i = 0; i < tamanho; i++) {
				if (campoCliente.getText().equalsIgnoreCase(arrays.get(i).getCarrinho().getCliente().getNome())) {
					Object[] objs = { arrays.get(i).getFuncionario().getNome(),
							arrays.get(i).getCarrinho().getCliente().getNome(),
							arrays.get(i).getCarrinho().getCliente().getEndereco(), arrays.get(i).getDatahora(),
							arrays.get(i).getCarrinho().getValorTotal() };
					dtm.addRow(objs);

				}

			}
		} else if (filtroPeriodo) {
			dtm.setRowCount(0);

			int tamanho = TelaNovaVenda.getCv().getRepositorioVendas().getVendas().size();
			ArrayList<Venda> arrays = new ArrayList<>();
			arrays.addAll(TelaNovaVenda.getCv().getRepositorioVendas().getVendas());

			DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataInicio = LocalDate.parse(txtInicio.getText(), form);
			LocalDate dataFim = LocalDate.parse(txtFim.getText(), form);

			for (int i = 0; i < tamanho; i++) {

				LocalDate dataVenda = LocalDate.of(arrays.get(i).getDatahora().getYear(),
						arrays.get(i).getDatahora().getMonthValue(), arrays.get(i).getDatahora().getDayOfMonth());

				if (dataInicio.isBefore(dataVenda) && dataFim.isAfter(dataVenda)) {
					Object[] objs = { arrays.get(i).getFuncionario().getNome(),
							arrays.get(i).getCarrinho().getCliente().getNome(),
							arrays.get(i).getCarrinho().getCliente().getEndereco(), arrays.get(i).getDatahora(),
							arrays.get(i).getCarrinho().getValorTotal() };
					dtm.addRow(objs);

				}

			}
		}

	}

	public TelaControleVendas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaControleVendas.class.getResource("/images/IconPope.png")));
		setTitle("Controle de Vendas - Pope's Dance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 145, 145));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 11, 926, 659);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(dtm);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(138, 34, 34));
		panel.setBounds(9, 11, 309, 659);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Filtros:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 289, 27);
		panel.add(lblNewLabel);

		JRadioButton radioArea = new JRadioButton("Area");
		radioArea.setForeground(Color.LIGHT_GRAY);
		radioArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroArea = true;
				filtroFuncionario = false;
				filtroCliente = false;
				filtroPeriodo = false;
				campoFunc.setText("");
				campoCliente.setText("");
				txtInicio.setText("");
				txtFim.setText("");

			}
		});
		radioArea.setBounds(10, 55, 54, 23);
		panel.add(radioArea);

		JRadioButton radioFunc = new JRadioButton("Funcion\u00E1rio");
		radioFunc.setForeground(Color.LIGHT_GRAY);
		radioFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroArea = false;
				filtroFuncionario = true;
				filtroCliente = false;
				filtroPeriodo = false;
				campoArea.setText("");
				campoCliente.setText("");
				txtInicio.setText("");
				txtFim.setText("");
			}
		});
		radioFunc.setBounds(10, 150, 94, 23);
		panel.add(radioFunc);

		JRadioButton radioCliente = new JRadioButton("Cliente");
		radioCliente.setForeground(Color.LIGHT_GRAY);
		radioCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroArea = false;
				filtroFuncionario = false;
				filtroCliente = true;
				filtroPeriodo = false;
				campoFunc.setText("");
				campoArea.setText("");
				txtInicio.setText("");
				txtFim.setText("");
			}
		});
		radioCliente.setBounds(10, 245, 66, 23);
		panel.add(radioCliente);

		JRadioButton radioPeriodo = new JRadioButton("Per\u00EDodo");
		radioPeriodo.setForeground(Color.LIGHT_GRAY);
		radioPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroArea = false;
				filtroFuncionario = false;
				filtroCliente = false;
				filtroPeriodo = true;
				campoFunc.setText("");
				campoCliente.setText("");
				campoArea.setText("");

			}
		});
		radioPeriodo.setBounds(10, 339, 75, 23);
		panel.add(radioPeriodo);

		JRadioButton radioLimpa = new JRadioButton("Limpar Sele\u00E7\u00E3o");
		radioLimpa.setForeground(Color.LIGHT_GRAY);
		radioLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroArea = false;
				filtroFuncionario = false;
				filtroCliente = false;
				filtroPeriodo = false;
				campoFunc.setText("");
				campoCliente.setText("");
				campoArea.setText("");
				txtInicio.setText("");
				txtFim.setText("");
			}
		});
		radioLimpa.setBounds(94, 445, 126, 23);
		panel.add(radioLimpa);

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioArea);
		bg.add(radioFunc);
		bg.add(radioPeriodo);
		bg.add(radioCliente);
		bg.add(radioLimpa);

		txtInicio = new JTextField();
		txtInicio.setToolTipText("DD/MM/AAAA");
		txtInicio.setBounds(10, 383, 134, 27);
		panel.add(txtInicio);
		txtInicio.setColumns(10);

		txtFim = new JTextField();
		txtFim.setToolTipText("DD/MM/AAAA");
		txtFim.setColumns(10);
		txtFim.setBounds(165, 383, 134, 27);
		panel.add(txtFim);

		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// atualizar a table em rela��o aos filtros
				// ta com problema no valor final.
				// att essa func�o
				atualizar();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnNewButton.setBounds(10, 523, 289, 70);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Fechar tela");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaGerente tg = new TelaGerente();
				tg.setLocationRelativeTo(null);
				tg.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 625, 289, 23);
		panel.add(btnNewButton_1);

		campoCliente = new JTextField();
		campoCliente.setBounds(10, 275, 289, 27);
		panel.add(campoCliente);
		campoCliente.setColumns(10);

		campoFunc = new JTextField();
		campoFunc.setBounds(10, 180, 289, 27);
		panel.add(campoFunc);
		campoFunc.setColumns(10);

		campoArea = new JTextField();
		campoArea.setBounds(10, 85, 289, 27);
		panel.add(campoArea);
		campoArea.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Data de inicio");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 369, 134, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Data Final");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setBounds(165, 369, 134, 14);
		panel.add(lblNewLabel_1_1);

		
	}
	
}
