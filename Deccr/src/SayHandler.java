import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SayHandler {

	File phoLog;
	
	public SayHandler() {
		File helper = new File("temp.txt");
		String tempPath = helper.getAbsolutePath();
		helper.delete();
		for (int i = 0; i < tempPath.length()-5; i++) {
			if (tempPath.substring(i,i+5).equals("Deccr")) {
				tempPath = tempPath.substring(0,i+5);
				break;
			}
		}
		phoLog = new File(tempPath + "\\say\\phoneme_log.txt");
		
	}
	
	public void writePhoneme(String usrText) throws IOException {
		Runtime.getRuntime().exec("cmd /c say.exe -lp \"" + phoLog.getAbsolutePath() + "\" " + usrText + " && mkdir \"" + phoLog.getParent() + "\\temp\"");
		//System.out.println("\"" + phoLog.getParent() + "\\temp\"");
	}
	
	public ArrayList<String> readPhonemes() throws IOException {
		//int e = 0;
		//System.out.println("\"" + phoLog.getParent() + "\\temp\"");
		while (!(new File(phoLog.getParent() + "\\temp").exists())) {
			//System.out.println(e);
			
		}
		Scanner sc = new Scanner(phoLog);
		
		ArrayList<String> ret = new ArrayList<String>();
		
		String lineHandler = "";
		int phoTracker = 0;
		boolean readingPho = false;
		String nextPho = "";
		
	
		while (sc.hasNextLine()) { 
			lineHandler = sc.nextLine();
			for (int i = 0; i < lineHandler.length(); i++) {
				if (!readingPho && Character.isLetter(lineHandler.charAt(i))) {
					readingPho = true;
					phoTracker = i;
				}
				if(readingPho && !Character.isLetter(lineHandler.charAt(i))) {
					readingPho = false;
					nextPho = lineHandler.substring(phoTracker,i);
					ret.add(nextPho);
					nextPho = "";
				}
			}
		}
		Runtime.getRuntime().exec("cmd start /c rmdir \"" + phoLog.getParent() + "\\temp\" && exit");
		return ret;
	}
	
}
