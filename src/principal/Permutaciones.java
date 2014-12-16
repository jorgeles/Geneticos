package principal;

import java.util.ArrayList;

public class Permutaciones {

	public static void main(String[] args) {
		// String[] elementos = "a,b,c,d,e".split(",");

		ArrayList<Integer> solucion = new ArrayList<Integer>();
		int size = 150;
		int max = 4;
		int min = 0;
		int creadas = 0;
		while (max <= size) {
			creadas ++;
			ArrayList<Integer> elementos = new ArrayList<Integer>();
			for (int i = min; i < max; i++) {
				Integer e = i;
				elementos.add(e);
			}
			int n = elementos.size(); // Tipos para escoger
			int r = elementos.size(); // Elementos elegidos
			Perm2(elementos, solucion, n, r);
			if (max < size) {
				min=max;
				max = max + 4;
				if (max > size) {
					max = size;
				}
			} else if (max == size) {
				max = max + 1;
			}

		}

	}

	private static void Perm2(ArrayList<Integer> elem, ArrayList<Integer> act,
			int n, int r) {
		if (n == 0) {
			System.out.println(act);
		} else {
			for (int i = 0; i < r; i++) {
				if (!act.contains(elem.get(i))) { // Controla que no haya
													// repeticiones
					ArrayList<Integer> act2 = (ArrayList<Integer>) act.clone();
					act2.add(elem.get(i));
					Perm2(elem, act2, n - 1, r);
				}
			}
		}
	}
}
