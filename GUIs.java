package xCR;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIs extends JFrame {	
	/**
	 * 
	 */
	private JPanel panel;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JPanel panelDown;
	private JPanel panelCenter;
	
	private JLabel inputLabel;
	private JTextField inputTextFieldCmpd;
	private JTextField inputTextFieldHBD;
	private JButton inputButton;
	
	private JScrollPane outputBasicInfo;
	private JScrollPane outputSpecificInfo;
	private JScrollPane outputHBD;
	private JLabel inputHBD;
	private JButton creditButton;
	private JLabel basicLabel;
	private JLabel specificLabel;
	private JLabel inputHBDlabel;
	private JLabel HBDlabel;
	private JPanel namePanel;
	private JPanel namePanel2;
	private JPanel namePanel3;
	private JButton clearButton;
	//private JLabel info;
	private JScrollPane info;
	
	JTextArea textArea;
	JTextArea textArea2;
	JTextArea textArea3;
	JTextArea textArea4;
	

	GUIs() {}
	public void start() {
	//JFrame alpha = new JFrame();
    setTitle("Aditya Gupta's Chemistry Database and Calculator of Simple Binary Compounds");
	setSize(1920/2, 1080/2);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	buildInputPanel();
	add(panel, BorderLayout.NORTH);
	//add(namePanel, BorderLayout.NORTH);
	//add(namePanel2, BorderLayout.NORTH);
	//add(namePanel3, BorderLayout.NORTH);
	add(panelLeft, BorderLayout.WEST);
	add(panelCenter, BorderLayout.CENTER);
	add(panelRight, BorderLayout.EAST);
	add(panelDown, BorderLayout.SOUTH);
	
	pack();
	
	setVisible(true);

	}
	
	public void buildInputPanel() {
		
		setLayout(new BorderLayout());
		
	inputLabel = new JLabel ("Enter your Binary Compound:");
	inputTextFieldCmpd = new JTextField(10);
	inputButton = new JButton("Enter!");
		inputButton.addActionListener(new inputButtonListener());
	panel = new JPanel();
	panelLeft = new JPanel();
	panelRight = new JPanel();
	panelDown = new JPanel();
	panelCenter = new JPanel();
	namePanel = new JPanel();
	
	 textArea = new JTextArea(30, 45);
	 textArea2 = new JTextArea(30, 45);
	 textArea3 = new JTextArea(30, 45);
	 textArea4 = new JTextArea(5, 70);
	textArea.setEditable(false);
	textArea2.setEditable(false);
	textArea3.setEditable(false);
	textArea4.setEditable(false);
    textArea.setLineWrap(false);
    textArea2.setLineWrap(false);
    textArea3.setLineWrap(false);
    
    //outputBasicInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    //outputSpecificInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    //outputHBD.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
	outputBasicInfo = new JScrollPane(textArea);
	outputSpecificInfo = new JScrollPane(textArea2);
	outputHBD = new JScrollPane(textArea3);
	creditButton = new JButton("Credits & References");
	   creditButton.addActionListener(new inputButtonListener());
	basicLabel = new JLabel ("Basic Element Info:");
	specificLabel = new JLabel ("Compound-Specific Info:");
	HBDlabel = new JLabel ("Hybridization Info:");
	inputHBDlabel = new JLabel ("Enter binary compound to find Hybridization of here \n(must be binary; only one central atom):");
	clearButton = new JButton("Clear all text!");
		clearButton.addActionListener(new inputButtonListener());
	/*info = new JLabel("Welcome to my simple binary chemistry calculator! This calculator finds various informations of both the separate elements"
			         + "\nas well as the compound itself. Make sure you only input a binary compound - if the total number of elements exceed their max"
			         + "\nvalence shell electron pair quantity, then that means it's not a binary compound! (And of course, only two elements). When inputting"
			         + "\nthe compound, it must be in the format Xx#Yy#. For example, NaCl, CaCl2, BF3, etc."); 
	*/
		
	info = new JScrollPane(textArea4);
		
	panel.add(inputLabel);
	panel.add(inputTextFieldCmpd);
	panel.add(inputButton);
	//panelDown.add(info);
	
	
	panelLeft.add(basicLabel);
	panelLeft.add(outputBasicInfo);
	//outputBasicInfo.setEditable(false);
	
	panelCenter.add(specificLabel);
	panelCenter.add(outputSpecificInfo);
	//outputSpecificInfo.setEditable(false);
	
	panelRight.add(HBDlabel);
	panelRight.add(outputHBD);
	//outputHBD.setEditable(false);
	panelDown.add(creditButton);
	panelDown.add(info);
	panelDown.add(clearButton);
	
	
	
	textArea4.setText("Welcome to Aditya Gupta's simple binary chemistry calculator! This calculator finds various informations of both the separate elements"
	         + "\nas well as the compound itself. Make sure you only input a binary compound - if the total number of elements exceed their max"
	         + "\nvalence shell quantity, then that means it's not a binary compound! (And of course, only two elements and only one central atom). \nWhen inputting"
	         + " the compound, it must be in the format Xx#Yy#. For example, NaCl, CaCl2, BF3, etc."
	         + "\nFor single elements, a placeholder atom H is used as the second element"
	         + "\nPlease go to this link: https://goo.gl/forms/vW5sl71gCuAJZaJa2 and complete a short survey for feedback!");
	
	}
	private String message = ("By Aditya Gupta, Chemistry/Computer Science (SCH4U/ICS4U) Cross Curricular. Refer to README document for further details");
	private class inputButtonListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 if (e.getActionCommand().equals("Enter!")) {
			String input = inputTextFieldCmpd.getText();
			Algorithms alg = new Algorithms(PTable.names, PTable.map, new Element (input));
			textArea.append(alg.getBasicInfo());
			     if(PTable.map.get(alg.getFirstElement()).getBondingType().equalsIgnoreCase("metallic")) {
			         textArea2.append(alg.getIonicInfo());
			         textArea3.append("\n\nThis compound is an ionic structure!\n\n");
			      }
			     else {
			    	// if(input.length() > 2) {
			    	 textArea2.append(alg.getCovalentInfo());
			    	 textArea3.append(alg.getHBDInfo());
			    	// } else {
			    		// textArea2.append(alg.getCovalentInfo());
			    		// textArea3.append("\n\n-/-\n\n");
			    	//}
			     }
		  }
		 
		 else if(e.getActionCommand().equals("Credits & References")) {
			 JOptionPane.showMessageDialog(null, message);
		 }
		 else if (e.getActionCommand().equals("Clear all text!")) {
			 textArea.setText("");
			 textArea2.setText("");
			 textArea3.setText("");
		 }
	 }
	}
}
