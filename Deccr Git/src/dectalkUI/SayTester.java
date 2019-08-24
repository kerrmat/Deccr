package dectalkUI;

import java.io.IOException;

public class SayTester {
	public static void main(String[] args) throws IOException {
		SayHandler sh = new SayHandler();
		sh.writePhoneme("I hate my life my dick is too small");
		System.out.println(new PhyteHandler(sh.readPhonemes()).toString());
	}
}
