package ca.swchs.compsci.main;

import java.util.Random;

public class RandomSelection {
	
	public String selectRandom(String in[]) {
		Random rand = new Random();
		return in[rand.nextInt(in.length-1 - 0 + 1)];
	}
	
}
