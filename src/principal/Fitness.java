package principal;

import java.util.ArrayList;

public class Fitness {

	public void CalculoFitness(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			for (int k = 0; k < permutaciones.get(i).mypermutaciones.size(); k++) {
				for (int l = k + 1; l < permutaciones.get(i).mypermutaciones
						.size(); l++) {
					int fabrica1 = permutaciones.get(i).mypermutaciones.get(k);
					int fabrica2 = permutaciones.get(i).mypermutaciones.get(l);
					permutaciones.get(i).myfitness = permutaciones.get(i).myfitness
							+ (distancias.get(k).get(l) * pesos.get(fabrica1)
									.get(fabrica2));
				}
			}
		}
	}

	public void MyFitness(Ciudadano ciudadano,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos) {

		for (int k = 0; k < ciudadano.mypermutaciones.size(); k++) {
			for (int l = k + 1; l < ciudadano.mypermutaciones.size(); l++) {
				int fabrica1 = ciudadano.mypermutaciones.get(k);
				int fabrica2 = ciudadano.mypermutaciones.get(l);
				ciudadano.myfitness = ciudadano.myfitness
						+ (distancias.get(k).get(l) * pesos.get(fabrica1).get(
								fabrica2));
			}
		}

	}
}
