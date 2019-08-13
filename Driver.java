import java.util.*
import java.awt.*
import java.swing.*


public class DectalkUI{
	
	JFrame frame = new JFrame();
		
	DectalkUI(){
		
		buildUI();
		
	}
	
	
	public void buildUI(){
		
		frame.setTitle("Dectalk UI");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setBounds(200,200,400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton button = new JButton("Sample Text");
		button.setBounds(130,200,100,40);
		
		frame.add(button);
		
	}
	
	
}

public class Driver {
	
	public static void main(String[] args){
		
		new DectalkUI();
		
	}
	
	
}
		