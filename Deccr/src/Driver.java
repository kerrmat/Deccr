import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DectalkUI{
	
	JFrame frame = new JFrame();
	JButton[] buttonarray = new JButton[5];
	PhyteHandler ph = new PhyteHandler();
		
	public DectalkUI(){
		
		buildUI();
		
	}
	
	
	public void buildUI(){
		
		frame.setTitle("Dectalk UI");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setBounds(200,200,400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Sample Text");
		buttonarray[0] = button;
		
		buttonarray[0].setBounds(130,200,150,40); //x,y,width,height
		buttonarray[0].addMouseListener(new ExpandButton(ph));
		
		frame.add(buttonarray[0]);
		
	}
}

class ExpandButton implements MouseListener{
	public boolean pressed = false;
	int oldx = 0;
	int oldy = 0;
	int newx;
	int newy;
	PhyteHandler ph;
	
	public ExpandButton(PhyteHandler p){
		
		ph = p;
	}
	
	public void mousePressed(MouseEvent e){
		oldx = (int)MouseInfo.getPointerInfo().getLocation().getX();
		oldy = (int)MouseInfo.getPointerInfo().getLocation().getY();
		pressed = true;
		
		JButton btn = (JButton)e.getSource();
		btn.setText(ph.testPhyteHandler());
	}
	public void mouseReleased(MouseEvent e){
		newx = (int)MouseInfo.getPointerInfo().getLocation().getX();
		newy = (int)MouseInfo.getPointerInfo().getLocation().getY();
		pressed = false;
		setButtonSize(e);
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	
	public void setButtonSize(MouseEvent e){
		
		JComponent btn = (JComponent)e.getSource();
		
		int width = btn.getWidth() + newx - oldx;
		int height = btn.getHeight() - newy + oldy;
		int y = btn.getY() + newy - oldy;
		btn.setBounds(btn.getX(),y,Math.max(width,0),Math.max(height,0));
	}
}
	
	


public class Driver {
	
	public static void main(String[] args){
		
		new DectalkUI();
		
	}
	
	
}