import java.util.*


public class Output{
	
	public string song;
	
	
	public static Process runCommandLine(string output){
		
		Runtime rt = Runtime.getRuntime();
		Return rt.exec(output);
		
		