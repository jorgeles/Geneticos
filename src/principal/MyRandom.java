package principal;
import java.util.Random;

import org.jgap.*;

public class MyRandom implements RandomGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean nextBoolean() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double nextDouble() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		Double number = (double) (rnd.nextInt((4 - 0) + 1) + 0);
		double p = number/4.0;
		return p;
	}

	@Override
	public float nextFloat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextInt(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long nextLong() {
		// TODO Auto-generated method stub
		return 0;
	}

}
