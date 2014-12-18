package principal;

import java.util.ArrayList;

public class Fitness {

	public void CalculoFitness(
			ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {

		ArrayList<Integer> fitness = new ArrayList<Integer>();

		for (int i = 0; i < cantidad; i++) {
			fitness.add(i, 0);
			for (int k = 0; k < permutaciones.get(i).mypermutaciones.size(); k++) {
				for (int l = k + 1; l < permutaciones.get(i).mypermutaciones.size(); l++) {
					int fabrica1 = permutaciones.get(i).mypermutaciones.get(k);
					int fabrica2 = permutaciones.get(i).mypermutaciones.get(l);
					permutaciones.get(i).myfitness = permutaciones.get(i).myfitness + (distancias.get(k).get(l) * pesos.get(fabrica1)
							.get(fabrica2));
				}
			}
		}
	}
}
