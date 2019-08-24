package dectalkUI;
import java.util.*;

import javax.swing.JButton;

public class PhyteHandler  {
	
	final int PHO_ON = -10;
	final int DEFAULT_VOICE = -1;
	public ArrayList<Phyte> PhyteList;
	
	public PhyteHandler() {
		
		 PhyteList = new ArrayList<Phyte>();
		 
	}
	
	public PhyteHandler(ArrayList<String> phonemes) {
		PhyteList = new ArrayList<Phyte>();
		PhyteList.add(new Phyte(PHO_ON));//enables [:phoneme on]
		PhyteList.add(new Phyte(DEFAULT_VOICE));//sets default voice
		for (int i = 0; i < phonemes.size(); i++) {
			PhyteList.add(new Phyte(phonemes.get(i)));
		}
	}
	
	public void changeVoice(int index, int voice) {
		PhyteList.add(index, new Phyte(voice));
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
	
	/**
	 * default constructor
	 */
	public Phyte(){
		phoneme = "aa";
		duration = 1000;
		pitch = 15;
	}
	
	/**
	 * Constructs phyte with default pitch and duration
	 * @param pho specified phoneme
	 */
	public Phyte(String pho) {
		phoneme = pho;
		duration = 1000;
		pitch = 10;
	}
	
	/**
	 * Fully specified constructor
	 * @param pho String for instance variable phoneme
	 * @param dur int for instance variable duration
	 * @param pit int for instance variable pitch
	 */
	public Phyte(String pho, int dur, int pit) {
		phoneme = pho;
		duration = dur;
		pitch = pit;
	}
	
	/**
	 * Constructor for voice change phoneme
	 * Also handles initializing phoneme mode in dectalk with voice = -10
	 * @param voice desired DECTalk voice, range [-1,-9], use -10 to create [:phoneme on]
	 */
	public Phyte(int voice) {
		phoneme = "";
		duration = voice;
		pitch = 0;
	}
	
	public String toString() {
		//normal case: prints a phoneme 
		if (duration >= 0)
			return "[" + phoneme + "<" + duration + "," + pitch + ">]";
		//voice change: print a voice change command (of 9 total voices)
		String voice = "";
		switch (duration) {
		case -1:
			voice = "p";
			break;
		case -2:
			voice = "h";
			break;
		case -3:
			voice = "f";
			break;
		case -4:
			voice = "d";
			break;
		case -5:
			voice = "b";
			break;
		case -6:
			voice = "u";
			break;
		case -7:
			voice = "w";
			break;
		case -8:
			voice = "r";
			break;
		case -9:
			voice = "k";
			break;
		case -10:
			return "[:phoneme on]";
		}
		return "[:n" + voice + "]";
		
	}
	
}
