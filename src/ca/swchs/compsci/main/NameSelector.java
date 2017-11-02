package ca.swchs.compsci.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import java.awt.BorderLayout;

public class NameSelector {

	private JFrame frmRandomNameSelector;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameSelector window = new NameSelector();
					window.frmRandomNameSelector.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NameSelector() {
		initialize();
	}

	private void initialize() {
		frmRandomNameSelector = new JFrame();
		frmRandomNameSelector.setResizable(false);
		frmRandomNameSelector.setTitle("Random Name Selector");
		frmRandomNameSelector.setBounds(100, 100, 250, 500);
		frmRandomNameSelector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandomNameSelector.getContentPane().setLayout(new BoxLayout(frmRandomNameSelector.getContentPane(), BoxLayout.Y_AXIS));
		
		Component spacerTitleLbl = Box.createVerticalStrut(10);
		frmRandomNameSelector.getContentPane().add(spacerTitleLbl);
		
		JLabel lblInstructions = new JLabel("Please enter student names:");
		lblInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
		frmRandomNameSelector.getContentPane().add(lblInstructions);
		
		JLabel lblInstructions2 = new JLabel("(each on separate lines)");
		lblInstructions2.setAlignmentX(Component.CENTER_ALIGNMENT);
		frmRandomNameSelector.getContentPane().add(lblInstructions2);
		
		Component spacerLblTxtr = Box.createVerticalStrut(10);
		frmRandomNameSelector.getContentPane().add(spacerLblTxtr);
		
		JPanel panelInputText = new JPanel();
		frmRandomNameSelector.getContentPane().add(panelInputText);
		panelInputText.setLayout(new BoxLayout(panelInputText, BoxLayout.X_AXIS));
		
		JScrollPane scrollpInputText = new JScrollPane();
		panelInputText.add(scrollpInputText);
		scrollpInputText.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JTextArea txtrInputText = new JTextArea();
		txtrInputText.setColumns(20);
		txtrInputText.setRows(22);
		scrollpInputText.setViewportView(txtrInputText);
		
		JPanel panelButtons = new JPanel();
		frmRandomNameSelector.getContentPane().add(panelButtons);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSelectRandom = new JButton("Select Random");
		panelButtons.add(btnSelectRandom);
		
		JPanel panelOutputText = new JPanel();
		frmRandomNameSelector.getContentPane().add(panelOutputText);
		panelOutputText.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollpOutputText = new JScrollPane();
		scrollpOutputText.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelOutputText.add(scrollpOutputText);
		
		JTextArea txtrOutputText = new JTextArea();
		txtrOutputText.setEditable(false);
		txtrOutputText.setColumns(20);
		panelOutputText.add(scrollpOutputText);
		scrollpOutputText.setViewportView(txtrOutputText);
		
		btnSelectRandom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RandomSelection rs = new RandomSelection();
				txtrOutputText.setText(rs.selectRandom(txtrInputText.getText().split("\n")));
			}
		});
		
	}

}
