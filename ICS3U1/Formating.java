import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class TempleGUILab {
	/**
	 * Launch the application.
	 */
	private JFrame frmGUI;
	
	private JButton btnClick_Me;
	private JButton btnExit;
	private JButton btnRed;
	private JButton btnBlue;
	private JButton btnGreen;
	private JButton btnDefault;
	
	private JLabel lblLabel;
	private JLabel lblProvinces;
	private JLabel lblImage;
	
	private JTextField textArea_Zero;
	
	private JComboBox cboProvinces;
	
	private JCheckBox chckbxComputerScience;
	private JCheckBox chckbxComputerAnimation;
	private JCheckBox chckbxComputerEngineering;

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempleGUILab window = new TempleGUILab();
					window.frmGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TempleGUILab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGUI = new JFrame();
		frmGUI.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		frmGUI.getContentPane().setBackground(new Color(217, 176, 213));
		frmGUI.setBounds(100, 100, 450, 300);
		frmGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGUI.getContentPane().setLayout(null);
		
		btnClick_Me = new JButton("Click ME!!");
		btnClick_Me.setForeground(new Color(115, 34, 99));
		btnClick_Me.setToolTipText("This button clearly just wants you to click it");
		btnClick_Me.setBackground(new Color(188, 107, 190));
		btnClick_Me.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello World!");
			}
		});
		btnClick_Me.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnClick_Me.setBounds(345, 238, 89, 23);
		frmGUI.getContentPane().add(btnClick_Me);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(115, 34, 99));
		btnExit.setToolTipText("This button ends the program");
		btnExit.setBackground(new Color(188, 107, 190));
		btnExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(0, 238, 89, 23);
		frmGUI.getContentPane().add(btnExit);
		
		lblLabel = new JLabel("My first label!!!!");
		lblLabel.setForeground(new Color(115, 34, 99));
		lblLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel.setBounds(250, 11, 174, 23);
		frmGUI.getContentPane().add(lblLabel);
		
		textArea_Zero = new JTextField();
		textArea_Zero.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textArea_Zero.setHorizontalAlignment(SwingConstants.CENTER);
		textArea_Zero.setText("input a text or box");
		textArea_Zero.setBackground(new Color(224, 209, 223));
		textArea_Zero.setBounds(250, 45, 174, 46);
		frmGUI.getContentPane().add(textArea_Zero);
		textArea_Zero.setColumns(10);
		
		cboProvinces = new JComboBox();
		cboProvinces.setBackground(new Color(203, 211, 220));
		cboProvinces.setModel(new DefaultComboBoxModel(new String[] {"{Choose Province or Territory}", "British Colombia", "Alberta", "Saskatchewan", "Manitoba", "Ontaio", "Quebec", "Newfoundland & Labrador", "Prince Edward Island", "New Brunswick", "Nova Scotia", "Yukon", "Northwest Territories", "Nunavut"}));
		cboProvinces.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		cboProvinces.setBounds(191, 132, 233, 46);
		frmGUI.getContentPane().add(cboProvinces);
		
		lblProvinces = new JLabel("Provinces");
		lblProvinces.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvinces.setForeground(new Color(115, 34, 99));
		lblProvinces.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblProvinces.setBounds(250, 98, 174, 23);
		frmGUI.getContentPane().add(lblProvinces);
		
		chckbxComputerEngineering = new JCheckBox("Computer Engineering\r\n");
		chckbxComputerEngineering.setBackground(new Color(111, 179, 122));
		chckbxComputerEngineering.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		chckbxComputerEngineering.setBounds(6, 83, 144, 23);
		frmGUI.getContentPane().add(chckbxComputerEngineering);
		
		chckbxComputerAnimation = new JCheckBox("Computer Animation");
		chckbxComputerAnimation.setBackground(new Color(111, 179, 122));
		chckbxComputerAnimation.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		chckbxComputerAnimation.setBounds(6, 31, 144, 23);
		frmGUI.getContentPane().add(chckbxComputerAnimation);
		
		chckbxComputerScience = new JCheckBox("Computer Science");
		chckbxComputerScience.setBackground(new Color(111, 179, 122));
		chckbxComputerScience.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		chckbxComputerScience.setBounds(6, 57, 144, 23);
		frmGUI.getContentPane().add(chckbxComputerScience);
		
		lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setForeground(new Color(115, 34, 99));
		lblImage.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblImage.setBounds(6, 125, 174, 23);
		frmGUI.getContentPane().add(lblImage);
		
		btnRed = new JButton("\r\n");
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGUI.getContentPane().setBackground(new Color(255, 0, 0));
			}
		});
		btnRed.setBackground(new Color(255, 0, 0));
		btnRed.setBounds(212, 189, 35, 23);
		frmGUI.getContentPane().add(btnRed);
		
		btnBlue = new JButton("\r\n");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGUI.getContentPane().setBackground(new Color(0, 255, 0));
			}
		});
		btnBlue.setBackground(new Color(0, 0, 255));
		btnBlue.setBounds(268, 189, 35, 23);
		frmGUI.getContentPane().add(btnBlue);
		
		btnGreen = new JButton("");
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGUI.getContentPane().setBackground(new Color(0, 0, 255));
			}
		});
		btnGreen.setBackground(new Color(0, 255, 0));
		btnGreen.setBounds(331, 189, 35, 23);
		frmGUI.getContentPane().add(btnGreen);
		
		btnDefault = new JButton("");
		btnDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGUI.getContentPane().setBackground(new Color(217, 176, 213));
			}
		});
		btnDefault.setBackground(new Color(217, 176, 213));
		btnDefault.setBounds(389, 189, 35, 23);
		frmGUI.getContentPane().add(btnDefault);
	}
}
