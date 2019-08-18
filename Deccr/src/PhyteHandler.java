import java.util.*;

public class PhyteHandler {
	
	public ArrayList<Phyte> PhyteList;
	
	public PhyteHandler() {
		
		 PhyteList = new ArrayList<Phyte>();
		
	}
	
	public String toString() {
		String ret = "";
		for (int i=0; i < PhyteList.size(); i++) {
			
			ret += PhyteList.get(i).toString();
			
		}
		
		return ret;
		
		
	}
	
	
}

class Phyte {
	
	public String phoneme;
	public int duration;
	public int pitch;
	
	public Phyte(){
		phoneme = "aa";
		duration = 1000;
		pitch = 15;
	}
	
	public Phyte(String pho, int dur, int pit) {
		phoneme = pho;
		duration = dur;
		pitch = pit;
	}
	
	public String toString() {
		return "[" + phoneme + "<" + duration + "," + pitch + ">]";
	}
	
}
