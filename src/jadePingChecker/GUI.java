package jadePingChecker;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jadePingChecker.JadePingChecker.State;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private static JadePingChecker pingChecker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					pingChecker = new JadePingChecker();
					pingChecker.setState(State.IDLE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Title Label
		JLabel lblTitle = new JLabel("JadePingChecker");
		lblTitle.setBounds(0, 25, 434, 19);
		lblTitle.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);

		// Status Label
		JLabel lblStatus = new JLabel("Healthy");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(138, 55, 156, 66);
		contentPane.add(lblStatus);

		// Ping Label
		JLabel lblPing = new JLabel("100ms");
		lblPing.setForeground(Color.BLACK);
		lblPing.setHorizontalAlignment(SwingConstants.CENTER);
		lblPing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPing.setBounds(172, 132, 89, 19);
		contentPane.add(lblPing);

		// Start Button
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pingChecker.toggleState();
			}
		});
		btnStart.setBounds(172, 198, 89, 23);
		contentPane.add(btnStart);

	}
}
