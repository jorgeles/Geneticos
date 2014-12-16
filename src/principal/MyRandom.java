package principal;
import java.util.Random;

import org.jgap.*;

public class MyRandom implements RandomGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int Max;
	int Min;
	
	public MyRandom(int max, int min){
		Max = max;
		Min = min;
	}

	@Override
	public boolean nextBoolean() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double nextDouble() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public float nextFloat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextInt() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		int number = rnd.nextInt((Max - Min) + 1) + Min;
		return number;
		
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
