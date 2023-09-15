package myForms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRace extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btnStart;
	private JButton btnReset;
	private final int MAX = 800;
	
	MyButton b1, b2, b3, b4;
	
	void initRace() {
		// Reset the winner and the raceInProgress flag
        MyButton.winner = null;
        MyButton.raceInProgress = true;

		b1 = new MyButton(30, btn1.getY(), MAX, btn1, "1");
		b2 = new MyButton(30, btn2.getY(), MAX, btn2, "2");
		b3 = new MyButton(30, btn3.getY(), MAX, btn3, "3");
		b4 = new MyButton(30, btn4.getY(), MAX, btn4, "4");
		
        b1.resetButton();
        b2.resetButton();
        b3.resetButton();
        b4.resetButton();
		
		b1.start();
		b2.start();
		b3.start();
		b4.start();
	}
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("CARRERA DE BOTONES");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel.setBounds(336, 11, 287, 29);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("PARTIDA");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_1.setBounds(31, 45, 93, 25);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("LLEGADA");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_2.setBounds(804, 45, 92, 25);
			contentPane.add(lblNewLabel_2);
		}
		{
			btn1 = new JButton("1");
			btn1.setBackground(Color.RED);
			btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
			btn1.setBounds(30, 81, 50, 50);
			contentPane.add(btn1);
		}
		{
			btn2 = new JButton("2");
			btn2.setBackground(Color.BLUE);
			btn2.setFont(new Font("Tahoma", Font.BOLD, 16));
			btn2.setBounds(30, 196, 50, 50);
			contentPane.add(btn2);
		}
		{
			btn3 = new JButton("3");
			btn3.setBackground(Color.GREEN);
			btn3.setFont(new Font("Tahoma", Font.BOLD, 16));
			btn3.setBounds(30, 311, 50, 50);
			contentPane.add(btn3);
		}
		{
			btn4 = new JButton("4");
			btn4.setBackground(Color.ORANGE);
			btn4.setFont(new Font("Tahoma", Font.BOLD, 16));
			btn4.setBounds(30, 426, 50, 50);
			contentPane.add(btn4);
		}
		{
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnStart(e);
				}
			});
			btnStart.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnStart.setBounds(271, 497, 144, 36);
			contentPane.add(btnStart);
		}
		{
			btnReset = new JButton("Reset");
			btnReset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    actionPerformedBtnReset(e);
                }
            });
			btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnReset.setBounds(545, 497, 144, 36);
			contentPane.add(btnReset);
		}
	}
	
	// Start button
	protected void actionPerformedBtnStart(ActionEvent e) {
		initRace();
	}
	
	// Reset button
    protected void actionPerformedBtnReset(ActionEvent e) {
        // Stop the running threads
        if (b1 != null) b1.stopThread();
        if (b2 != null) b2.stopThread();
        if (b3 != null) b3.stopThread();
        if (b4 != null) b4.stopThread();

        // Reset the buttons to their initial position
        btn1.setLocation(30, btn1.getY());
        btn2.setLocation(30, btn2.getY());
        btn3.setLocation(30, btn3.getY());
        btn4.setLocation(30, btn4.getY());

        // Reset the winner and the raceInProgress flag
        MyButton.winner = null;
        MyButton.raceInProgress = false;
    }
}
