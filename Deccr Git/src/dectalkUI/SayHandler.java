package dectalkUI;
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
			if (tempPath.substring(i,i+8).equals("temp.txt")) {
				tempPath = tempPath.substring(0,i);
				break;
			}
		}
		phoLog = new File(tempPath + "\\src\\Us\\phoneme_log.txt");
		System.out.println(phoLog.getAbsolutePath());
		
	}
	
	public void writePhoneme(String usrText) throws IOException {
		//Runtime.getRuntime().exec("cmd /c start dir");
		String s = "cmd /c cd \"" + phoLog.getParent() + "\" && say.exe -lp \"" + phoLog.getAbsolutePath() + "\" " + usrText + " && mkdir \"" + phoLog.getParent() + "\\temp\"";
		
		System.out.println(s);
		Runtime.getRuntime().exec(s);
	}
	
	public ArrayList<String> readPhonemes() throws IOException {

		//int e = 0;
		while (!(new File(phoLog.getParent() + "\\temp").exists())) {/*e++; System.out.println(e);*/}
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
		//System.out.println(phoLog.getParent());
		Runtime.getRuntime().exec("cmd start /c rmdir \"" + phoLog.getParent() + "\\temp\" && exit");
		return ret;
	}
	
}
