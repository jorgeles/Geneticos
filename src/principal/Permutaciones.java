package principal;

import java.util.ArrayList;

public class Permutaciones {
	
	public ArrayList<Integer> Permutacion(int max, int min,int size){
		MyRandom random = new MyRandom(max,min);
		ArrayList<Integer> permutacion = new ArrayList<Integer>();
		for(int i=0; i<size; i++){
			int next = random.nextInt();
			while(permutacion.contains(next)){
				next = random.nextInt();
			}
			permutacion.add(next);
		}
		return permutacion;
	}

}
