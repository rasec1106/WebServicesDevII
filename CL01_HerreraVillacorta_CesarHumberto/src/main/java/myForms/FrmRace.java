package myForms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import myThreads.MyProgressBar;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmRace extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar01;
	private JProgressBar progressBar02;
	private JProgressBar progressBar03;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRace frame = new FrmRace();
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
	public FrmRace() {
		setTitle("ATENCION DE CAJEROS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATENCION DE CAJEROS EN CENTRO COMERCIAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(127, 24, 705, 98);
		contentPane.add(lblNewLabel);
		
		progressBar01 = new JProgressBar();
		progressBar01.setForeground(new Color(0, 128, 0));
		progressBar01.setBounds(72, 182, 780, 26);
		contentPane.add(progressBar01);
		
		JLabel lblNewLabel_1 = new JLabel("CAJERO-1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(72, 137, 113, 35);
		contentPane.add(lblNewLabel_1);
		
		progressBar02 = new JProgressBar();
		progressBar02.setForeground(new Color(0, 128, 0));
		progressBar02.setBounds(72, 282, 780, 26);
		contentPane.add(progressBar02);
		
		JLabel lblNewLabel_1_1 = new JLabel("CAJERO-2");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(72, 237, 113, 35);
		contentPane.add(lblNewLabel_1_1);
		
		progressBar03 = new JProgressBar();
		progressBar03.setForeground(new Color(0, 128, 0));
		progressBar03.setBounds(72, 383, 780, 26);
		contentPane.add(progressBar03);
		
		JLabel lblNewLabel_1_2 = new JLabel("CAJERO-3");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(72, 338, 113, 35);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIniciar(e);
			}
		});
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIniciar.setBounds(72, 456, 113, 35);
		contentPane.add(btnIniciar);
	}
	
	protected void actionPerformedBtnIniciar(ActionEvent e) {
		MyProgressBar.winner = null;
		MyProgressBar.raceInProgress = true;
		MyProgressBar.totalOfBars = 3;
		MyProgressBar.randomIndex = MyProgressBar.getRandomValue();
		
		MyProgressBar p1 = new MyProgressBar("Cajero-1", progressBar01, 0, 5);
		MyProgressBar p2 = new MyProgressBar("Cajero-2", progressBar02, 1, 5);
		MyProgressBar p3 = new MyProgressBar("Cajero-3", progressBar03, 2, 5);
		
		p1.start();
		p2.start();
		p3.start();
	}
}
