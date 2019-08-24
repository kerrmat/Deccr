package dectalkUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.imageio.*;

public class InterfaceWindowTest extends JFrame {
	
	ArrayList<PhyteHandler> trackList = new ArrayList<PhyteHandler>();  //Main list of tracks in progress
	ArrayList<TrackPanel> trackPanels = new ArrayList<TrackPanel>();
	ArrayList<JPanel> containerList = new ArrayList<JPanel>();  //Main list of JPanels for Component Spacing
	int activeTrack = -1;
	SayHandler sh = new SayHandler();  //Say Handler
	JMenuBar mainMenuBar = new JMenuBar();
	JPanel p;
	JTextField inputField;
	
	public InterfaceWindowTest() {
		
		buildMenu();
		buildJPanels();
		buildSettings();
	}
	
	public void buildJPanels() {
		
		
		p = new JPanel(new FlowLayout());
		p.setPreferredSize(new Dimension(800,200));
		
		inputField = new JTextField(30);
		inputField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		JTextArea textArea = new JTextArea(40,40);
		textArea.setEditable(false);
		
		JButton testButton = new JButton("Add to Track");
		testButton.setPreferredSize(new Dimension(200,40));
		
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleClick(e);
			}
		});		
		
		
		p.add(inputField);
		p.add(testButton);
		//p.add(inputField2, c);
		//p.add(inputField3, c);
		//p.add(textArea, c);
		
		add(p);
		
		
		
		
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
				newBaby();
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
		
		pack();
		setVisible(true);
		//setLocationRelativeTo(null);
	}
	
	public void displayGif() {
		
		ImageIcon babyIcon = new ImageIcon("/src/resources/baby.gif");
		JLabel babyLabel = new JLabel(babyIcon);
		
		add(babyLabel);
		
	}
	
	public void handleClick(ActionEvent e) {
		
		System.out.println(e.getSource().getClass().toString());
		if(e.getSource().getClass().toString().equals("class javax.swing.JButton")) {
			try {
				makePhyteButtons(inputField.getText());
				inputField.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void newBaby() {
		
		String babyPath = (new File("temp.txt")).getAbsolutePath();
		babyPath = babyPath.substring(0,babyPath.length()-8) + "src\\dectalkUI\\Desktop\\baby.gif";
		System.out.println(babyPath);
		//myImage = myImage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
	    ImageIcon myImageIcon = new ImageIcon(babyPath);
				
		JLabel baby = new JLabel(myImageIcon);
		
		containerList.add(new JPanel(new FlowLayout()));
		containerList.get(0).setPreferredSize(new Dimension(200,200));
		containerList.get(0).setBorder(BorderFactory.createLineBorder(Color.black));
		containerList.get(0).add(baby);
		add(containerList.get(0), BorderLayout.PAGE_END);
		pack();
	}
	
	
	public void makePhyteButtons(String input) throws IOException {
		
		//If there are no Tracks, create one
		if(activeTrack == -1) {
			System.out.println(input);
			trackPanels.add(new TrackPanel());
			add(trackPanels.get(0), BorderLayout.PAGE_END);
			activeTrack = 0;
		}
		
		//Write the Phoneme to the Say Handler
		sh.writePhoneme(input);
		
		//Add Phytes to the Active Track
		trackPanels.get(activeTrack).ph.addPhytes(sh.readPhonemes());
		
		//Update the 		
		trackPanels.get(activeTrack).refresh();
		pack();
		for (int i = 0; i < trackPanels.size(); i++) {
			System.out.println(trackPanels.get(i).ph.toString());
		}
		
		
	}
}

class TrackPanel extends JPanel{
	
	PhyteHandler ph;
	
	public TrackPanel() {
		
		ph = new PhyteHandler();
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(600,200));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
	
	public void refresh(){
		
		removeAll();
		for(int i = 2; i <  ph.PhyteList.size(); i++) {
			add(ph.PhyteList.get(i));
		}
		
	}
	
}