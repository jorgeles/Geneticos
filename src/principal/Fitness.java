package principal;

import java.util.ArrayList;

/*
 * Clase que calcula el fitness de un individuo o una poblacion
 * con distintas variantes
 */
public class Fitness {

	/*
	 * Calcula el fitness de una poblacion entera. Fitness estandar
	 */
	public void CalculoFitness(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			permutaciones.get(i).myfitness = 0;
			MyFitness(permutaciones.get(i), distancias, pesos);
		}

	}

	/*
	 * Calcula el fitness de un individuo que ha sido entrenado con un algorimo
	 * greedy. El individuo original no se modifica
	 */
	public void CalculoFitnessGreedy(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {

		CalculoFitness(permutaciones, distancias, pesos, cantidad);
		for (int i = 0; i < cantidad; i++) {
			Greedy alg = new Greedy();
			Ciudadano aux = alg.Procesar(permutaciones.get(i), distancias,
					pesos);
			if (aux.myfitness < permutaciones.get(i).myfitness) {
				permutaciones.get(i).myfitness = aux.myfitness;
			}
		}
	}

	/*
	 * Calcula el fitness de un individuo que ha sido entrenado con un algorimo
	 * greedy. El individuo original se modifica
	 */
	@SuppressWarnings("unchecked")
	public void CalculoFitnessGreedyModifica(
			ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos, int cantidad) {

		CalculoFitness(permutaciones, distancias, pesos, cantidad);

		for (int i = 0; i < cantidad; i++) {
			Greedy alg = new Greedy();
			Ciudadano aux = alg.Procesar(permutaciones.get(i), distancias,
					pesos);
			if (aux.myfitness < permutaciones.get(i).myfitness) {
				permutaciones.get(i).myfitness = aux.myfitness;
				permutaciones.get(i).mypermutaciones = (ArrayList<Integer>) aux.mypermutaciones
						.clone();
			}
		}
	}

	/*
	 * Calcula el fitness estandar de un solo individuo
	 */
	public void MyFitness(Ciudadano ciudadano,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos) {
		ciudadano.myfitness = 0;
		for (int i = 0; i < ciudadano.mypermutaciones.size(); i++) {
			for (int l = 0; l < ciudadano.mypermutaciones.size(); l++) {
				if (i != l) {
					int fabrica1 = ciudadano.mypermutaciones.get(i);
					int fabrica2 = ciudadano.mypermutaciones.get(l);
					ciudadano.myfitness = ciudadano.myfitness
							+ (distancias.get(i).get(l) * pesos.get(fabrica1)
									.get(fabrica2));
				}
			}
			
		}

	}
}
