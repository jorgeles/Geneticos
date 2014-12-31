package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	private static final int MAX_ALLOWED_EVOLUTIONS = 100;

	// private static MyRandom randomGenerator = new MyRandom();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> distancias = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> pesos = new ArrayList<ArrayList<Integer>>();
		int cantidad = 0;
		Fitness fit = new Fitness();
		Evolucion evo = new Evolucion();

		String tipo = "0";
		String pobla = null;
		String itera = null;

		try {
			Scanner sc = new Scanner(new File("tai256c.dat"));
			if (sc.hasNextInt()) {
				cantidad = sc.nextInt();
			}
			for (int i = 0; i < cantidad; i++) {
				distancias.add(new ArrayList<Integer>());
				for (int j = 0; j < cantidad; j++) {
					distancias.get(i).add(sc.nextInt());
				}
			}
			for (int i = 0; i < cantidad; i++) {
				pesos.add(new ArrayList<Integer>());
				for (int j = 0; j < cantidad; j++) {
					pesos.get(i).add(sc.nextInt());
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (!tipo.equals("1") && !tipo.equals("2") && !tipo.equals("3")) {
			System.out
					.println("Introduzca el tipo de algortimo que desea: 1=Estandar; 2=Baldwiniano; 3=Lamarckiano");

			try {
				BufferedReader entrada = new BufferedReader(
						new InputStreamReader(System.in));
				tipo = entrada.readLine();
			} catch (IOException e) {
			}
		}

		System.out.println("Introduzca poblacion maxima par");
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					System.in));
			pobla = entrada.readLine();
		} catch (IOException e) {
		}
		System.out.println("Introduzca Iteraciones maxima");
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					System.in));
			itera = entrada.readLine();
		} catch (IOException e) {
		}

		int max = cantidad - 1;
		int min = 0;
		int poblacion = Integer.parseInt(pobla);
		int iteraciones = Integer.parseInt(itera);
		ArrayList<Ciudadano> permutaciones = new ArrayList<Ciudadano>();
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		/*
		 * Genero los primeros ciudadanos
		 */
		Permutaciones permutacion = new Permutaciones();
		for (int i = 0; i < poblacion; i++) {
			Ciudadano aux = new Ciudadano();
			aux.mypermutaciones = permutacion.Permutacion(max, min, cantidad);
			permutaciones.add(aux);
		}
		

		/*
		 * Descomentar la variación que se desea utilizar
		 */
		if (tipo.equals("1")) {
			fit.CalculoFitness(permutaciones, distancias, pesos, poblacion);// Estandar
		} else if (tipo.equals("2")) {
			fit.CalculoFitnessGreedy(permutaciones, distancias, pesos,
					poblacion); // Baldwiniano
		} else {
			fit.CalculoFitnessGreedyModifica(permutaciones, distancias, pesos,
					poblacion); // Lamarckiano
		}

		/*
		 * Compara los ciudadanos y los odeno en fución de su fitness
		 */
		Collections.sort(permutaciones, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				Ciudadano p1 = (Ciudadano) o1;
				Ciudadano p2 = (Ciudadano) o2;
				return new Integer(p1.myfitness).compareTo(new Integer(
						p2.myfitness));
			}
		});

		for (int i = 0; i < iteraciones; i++) {
			/*
			 * Genero poblacion nueva
			 */

			/*
			 * Descomentar la variación que se desea utilizar
			 */
			if (tipo.equals("1")) {
				evo.GenerarPoblacion(permutaciones, distancias, pesos);// Estandar
			} else if (tipo.equals("2")) {
				evo.GenerarPoblacion2(permutaciones, distancias, pesos);// Baldwiniano
			} else {
				evo.GenerarPoblacion3(permutaciones, distancias, pesos); // Lamarckiano
			}

			/*
			 * Compara los ciudadanos y los odeno en fución de su fitness
			 */
			Collections.sort(permutaciones, new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					Ciudadano p1 = (Ciudadano) o1;
					Ciudadano p2 = (Ciudadano) o2;
					return new Integer(p1.myfitness).compareTo(new Integer(
							p2.myfitness));
				}
			});

			/*
			 * for(int j=0; j<permutaciones.size(); j++){
			 * System.out.println(permutaciones.get(j).myfitness); }
			 */

			for (int j = permutaciones.size() - 1; j >= poblacion; j--) {
				permutaciones.remove(j);

			}

			// Imprimimos el mejor de cada iteración
			System.out.println(permutaciones.get(0).myfitness + " " + i);

		}

		time_end = System.currentTimeMillis();

		System.out.println("the task has taken " + (time_end - time_start)
				+ " milliseconds");

	}
}
