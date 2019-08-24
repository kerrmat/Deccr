package dectalkUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class InterfaceWindow extends JFrame {
	
	ArrayList<JButton> phyteButton = new ArrayList<JButton>();
	SayHandler sh = new SayHandler();
	ArrayList<PhyteHandler> ph = new ArrayList<PhyteHandler>();
	JTextField inputField;
	JMenuBar mainMenuBar = new JMenuBar();
	JPanel p;
	
	public InterfaceWindow() {
		
		buildMenu();
		buildJPanel();
		buildSettings();
				
	}
	
	public void buildJPanel() {
		
		p = new JPanel(new GridBagLayout());
		
		inputField = new JTextField(20);

		//JTextField inputField2 = new JTextField(20);
		//JTextField inputField3 = new JTextField(20);
		
		JTextArea textArea = new JTextArea(20,20);
		textArea.setEditable(false);
		
		JButton testButton = new JButton();
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					makePhyteButtons(inputField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		p.setPreferredSize(new Dimension(640, 480));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 100;
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		p.add(inputField, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		p.add(testButton, c);
		//p.add(inputField2, c);
		c.gridx = 2;
		//p.add(inputField3, c);
		//p.add(textArea, c);
		
		
		
	}
	
	public void buildMenu() {
		//Create File Menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		//Create New Song Menu Item
		ImageIcon newSongIcon = new ImageIcon("src/resources/new.png");
		JMenuItem newSongMenuItem = new JMenuItem("New Song", newSongIcon);
		newSongMenuItem.setMnemonic(KeyEvent.VK_N);
		newSongMenuItem.setToolTipText("Create a new song");
		
		//Create Edit Menu
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		
		//Create Sonogram Menu
		JMenu sonogramMenu = new JMenu("Sonogram");
		JMenuItem newBabyMenuItem = new JMenuItem("New Baby");
		newBabyMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				displayGif();
			}
		}); 
		sonogramMenu.add(newBabyMenuItem);
		
		//Add Components to Menu Bar
		fileMenu.add(newSongMenuItem);
		fileMenu.add(sonogramMenu);
		mainMenuBar.add(fileMenu);
		mainMenuBar.add(editMenu);
		setJMenuBar(mainMenuBar);
	
	}
	
	public void buildSettings() {
		
		setTitle("Dectalk UI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(p);
		pack();
		setVisible(true);
		//setLocationRelativeTo(null);
	}
	
	public void displayGif() {
		
		ImageIcon babyIcon = new ImageIcon("/src/resources/baby.gif");
		JLabel babyLabel = new JLabel(babyIcon);
		
		add(babyLabel);
		
	}
	
	public void makePhyteButtons(String input) throws IOException {
		
		sh.writePhoneme(input);
		ph.add(new PhyteHandler(sh.readPhonemes()));
		for (int i = 0; i < ph.size(); i++) {
			System.out.println(ph.get(i).toString());
		}
		
		
	}
}

class mainPanel extends JPanel{
	
	
	
	public mainPanel() {
		
		
	}
	
	
	
	
	
	
	
}
