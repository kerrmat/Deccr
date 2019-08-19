package dectalkUI;

import java.io.IOException;

public class SayTester {
	public static void main(String[] args) throws IOException {
		SayHandler sh = new SayHandler();
		sh.writePhoneme("super brudda smash");
		System.out.println(new PhyteHandler(sh.readPhonemes()).toString());
	}
}
