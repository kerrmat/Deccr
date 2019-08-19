package dectalkUI;

import java.io.IOException;

public class SayTester {
	public static void main(String[] args) throws IOException {
		SayHandler sh = new SayHandler();
		sh.writePhoneme("lez do this");
		System.out.println(sh.readPhonemes());
	}
}
