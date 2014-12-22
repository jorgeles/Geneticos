package principal;

import java.util.ArrayList;

public class Fitness {

	public void CalculoFitness(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			permutaciones.get(i).myfitness=0;
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
	
	public void CalculoFitnessGreedy(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {
		
		CalculoFitness(permutaciones, distancias, pesos, cantidad);
		for (int i = 0; i < cantidad; i++) {
			Greedy alg = new Greedy();
			Ciudadano aux = alg.Procesar(permutaciones.get(i), distancias, pesos);
			if(aux.myfitness<permutaciones.get(i).myfitness){
				permutaciones.get(i).myfitness=aux.myfitness;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void CalculoFitnessGreedyModifica(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {
		
		CalculoFitness(permutaciones, distancias, pesos, cantidad);

		for (int i = 0; i < cantidad; i++) {
			Greedy alg = new Greedy();
			Ciudadano aux = alg.Procesar(permutaciones.get(i), distancias, pesos);
			if(aux.myfitness<permutaciones.get(i).myfitness){
				permutaciones.get(i).myfitness=aux.myfitness;
				permutaciones.get(i).mypermutaciones = (ArrayList<Integer>) aux.mypermutaciones
						.clone();
			}
		}
	}

	public void MyFitness(Ciudadano ciudadano,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos) {
		
		ciudadano.myfitness=0;
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
