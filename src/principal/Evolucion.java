package principal;

import java.util.ArrayList;

public class Evolucion {

	public void GenerarPoblacion(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos) {

		Fitness fit = new Fitness();
		int size = permutaciones.size();
		for (int i = 0; i < 25 || i < size; i++) {
			Ciudadano aux = new Ciudadano();
			for (int j = 0; j < permutaciones.get(i).mypermutaciones.size(); j++) {
				if (j % 2 == 0
						&& aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(j)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones.get(j));

				} else if (aux.mypermutaciones
						.contains(permutaciones.get(i+1).mypermutaciones.get(j)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(i + 1).mypermutaciones
									.get(j));

				} else if (j % 2 == 1
						&& aux.mypermutaciones
								.contains(permutaciones.get(i+1).mypermutaciones
										.get(j)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(i+1).mypermutaciones.get(j));

				} else if (aux.mypermutaciones.contains(permutaciones
						.get(i).mypermutaciones.get(j)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones
									.get(j));

				} else {
					boolean encontrado = false;

					for (int k = 0; k < permutaciones.get(i).mypermutaciones
							.size() && encontrado == false; k++) {

						if (aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(k)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i).mypermutaciones
											.get(k));
						} else if (aux.mypermutaciones.contains(permutaciones
								.get(i + 1).mypermutaciones.get(k)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i + 1).mypermutaciones
											.get(k));
						}
					}
				}
			}
			fit.MyFitness(aux, distancias, pesos);
			permutaciones.add(aux);
		}

		int i = 26;
		int j = permutaciones.size() - 1;

		while (i < j) {
			Ciudadano aux = new Ciudadano();
			for (int k = 0; k < permutaciones.get(i).mypermutaciones.size(); k++) {
				if (k % 2 == 0
						&& aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(k)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones.get(k));

				} else if (aux.mypermutaciones
						.contains(permutaciones.get(j).mypermutaciones.get(k)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(j).mypermutaciones
									.get(k));

				} else if (k % 2 == 1
						&& aux.mypermutaciones
								.contains(permutaciones.get(j).mypermutaciones
										.get(k)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(j).mypermutaciones.get(k));

				} else if (aux.mypermutaciones.contains(permutaciones
						.get(i).mypermutaciones.get(k)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones
									.get(k));

				} else {
					boolean encontrado = false;

					for (int l = 0; l < permutaciones.get(i).mypermutaciones
							.size() && encontrado == false; l++) {

						if (aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(l)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i).mypermutaciones
											.get(l));
						} else if (aux.mypermutaciones.contains(permutaciones
								.get(j).mypermutaciones.get(l)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(j).mypermutaciones
											.get(l));
						}
					}
				}
			}
			i++;
			j--;
			fit.MyFitness(aux, distancias, pesos);
			permutaciones.add(aux);
		}

	}
	
	public void GenerarPoblacion2(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos) {

		Greedy greedy = new Greedy();
		Fitness fit = new Fitness();
		int size = permutaciones.size();
		for (int i = 0; i < 25 && i < size; i++) {
			Ciudadano aux = new Ciudadano();
			for (int j = 0; j < permutaciones.get(i).mypermutaciones.size(); j++) {
				if (j % 2 == 0
						&& aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(j)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones.get(j));

				} else if (aux.mypermutaciones
						.contains(permutaciones.get(i+1).mypermutaciones.get(j)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(i + 1).mypermutaciones
									.get(j));

				} else if (j % 2 == 1
						&& aux.mypermutaciones
								.contains(permutaciones.get(i+1).mypermutaciones
										.get(j)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(i+1).mypermutaciones.get(j));

				} else if (aux.mypermutaciones.contains(permutaciones
						.get(i).mypermutaciones.get(j)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones
									.get(j));

				} else {
					boolean encontrado = false;

					for (int k = 0; k < permutaciones.get(i).mypermutaciones
							.size() && encontrado == false; k++) {

						if (aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(k)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i).mypermutaciones
											.get(k));
						} else if (aux.mypermutaciones.contains(permutaciones
								.get(i + 1).mypermutaciones.get(k)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i + 1).mypermutaciones
											.get(k));
						}
					}
				}
			}
			
			fit.MyFitness(aux, distancias, pesos);
			Ciudadano ciu =greedy.Procesar(aux, distancias, pesos);
			aux.myfitness=ciu.myfitness;
			permutaciones.add(aux);
		}

		int i = 26;
		int j = permutaciones.size() - 1;

		while (i < j) {
			Ciudadano aux = new Ciudadano();
			for (int k = 0; k < permutaciones.get(i).mypermutaciones.size(); k++) {
				if (k % 2 == 0
						&& aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(k)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones.get(k));

				} else if (aux.mypermutaciones
						.contains(permutaciones.get(j).mypermutaciones.get(k)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(j).mypermutaciones
									.get(k));

				} else if (k % 2 == 1
						&& aux.mypermutaciones
								.contains(permutaciones.get(j).mypermutaciones
										.get(k)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(j).mypermutaciones.get(k));

				} else if (aux.mypermutaciones.contains(permutaciones
						.get(i).mypermutaciones.get(k)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones
									.get(k));

				} else {
					boolean encontrado = false;

					for (int l = 0; l < permutaciones.get(i).mypermutaciones
							.size() && encontrado == false; l++) {

						if (aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(l)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i).mypermutaciones
											.get(l));
						} else if (aux.mypermutaciones.contains(permutaciones
								.get(j).mypermutaciones.get(l)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(j).mypermutaciones
											.get(l));
						}
					}
				}
			}
			i++;
			j--;
			fit.MyFitness(aux, distancias, pesos);
			Ciudadano ciu =greedy.Procesar(aux, distancias, pesos);
			aux.myfitness=ciu.myfitness;
			permutaciones.add(aux);
		}

	}
	
	public void GenerarPoblacion3(ArrayList<Ciudadano> permutaciones,
			ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos) {
		Greedy greedy = new Greedy();
		Fitness fit = new Fitness();
		int size = permutaciones.size();
		for (int i = 0; i < 25 && i < size; i++) {
			Ciudadano aux = new Ciudadano();
			for (int j = 0; j < permutaciones.get(i).mypermutaciones.size(); j++) {
				if (j % 2 == 0
						&& aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(j)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones.get(j));

				} else if (aux.mypermutaciones
						.contains(permutaciones.get(i+1).mypermutaciones.get(j)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(i + 1).mypermutaciones
									.get(j));

				} else if (j % 2 == 1
						&& aux.mypermutaciones
								.contains(permutaciones.get(i+1).mypermutaciones
										.get(j)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(i+1).mypermutaciones.get(j));

				} else if (aux.mypermutaciones.contains(permutaciones
						.get(i).mypermutaciones.get(j)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones
									.get(j));

				} else {
					boolean encontrado = false;

					for (int k = 0; k < permutaciones.get(i).mypermutaciones
							.size() && encontrado == false; k++) {

						if (aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(k)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i).mypermutaciones
											.get(k));
						} else if (aux.mypermutaciones.contains(permutaciones
								.get(i + 1).mypermutaciones.get(k)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i + 1).mypermutaciones
											.get(k));
						}
					}
				}
			}
			fit.MyFitness(aux, distancias, pesos);
			long time_start, time_end;
			time_start = System.currentTimeMillis();
			System.out.println(i);
			Ciudadano ciu =greedy.Procesar(aux, distancias, pesos);
			permutaciones.add(ciu);
			time_end = System.currentTimeMillis();
			System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		}

		int i = 26;
		int j = permutaciones.size() - 1;

		while (i < j) {
			System.out.println("8");
			Ciudadano aux = new Ciudadano();
			for (int k = 0; k < permutaciones.get(i).mypermutaciones.size(); k++) {
				if (k % 2 == 0
						&& aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(k)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones.get(k));

				} else if (aux.mypermutaciones
						.contains(permutaciones.get(j).mypermutaciones.get(k)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(j).mypermutaciones
									.get(k));

				} else if (k % 2 == 1
						&& aux.mypermutaciones
								.contains(permutaciones.get(j).mypermutaciones
										.get(k)) == false) {
					aux.mypermutaciones
							.add(permutaciones.get(j).mypermutaciones.get(k));

				} else if (aux.mypermutaciones.contains(permutaciones
						.get(i).mypermutaciones.get(k)) == false) {

					aux.mypermutaciones
							.add(permutaciones.get(i).mypermutaciones
									.get(k));

				} else {
					boolean encontrado = false;

					for (int l = 0; l < permutaciones.get(i).mypermutaciones
							.size() && encontrado == false; l++) {

						if (aux.mypermutaciones
								.contains(permutaciones.get(i).mypermutaciones
										.get(l)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(i).mypermutaciones
											.get(l));
						} else if (aux.mypermutaciones.contains(permutaciones
								.get(j).mypermutaciones.get(l)) == false) {
							encontrado = true;
							aux.mypermutaciones
									.add(permutaciones.get(j).mypermutaciones
											.get(l));
						}
					}
				}
			}
			i++;
			j--;
			fit.MyFitness(aux, distancias, pesos);
			Ciudadano ciu =greedy.Procesar(aux, distancias, pesos);
			permutaciones.add(ciu);
			System.out.println("9");
		}

	}

}
