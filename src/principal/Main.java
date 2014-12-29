package principal;

import java.io.File;

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
		
		int max = cantidad - 1;
		int min = 0;
		int poblacion = 100;
		int iteraciones = 10;
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
		//fit.CalculoFitness(permutaciones, distancias, pesos, poblacion);//Estandar
		//fit.CalculoFitnessGreedy(permutaciones, distancias, pesos, poblacion); //Baldwiniano
		fit.CalculoFitnessGreedyModifica(permutaciones, distancias, pesos, poblacion); //Lamarckiano

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
			//evo.GenerarPoblacion(permutaciones, distancias, pesos);//Estandar
			//evo.GenerarPoblacion2(permutaciones, distancias, pesos);//Baldwiniano
			evo.GenerarPoblacion3(permutaciones, distancias, pesos); //Lamarckiano

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

			
			for(int j=permutaciones.size()-1; j>=poblacion; j--){
				permutaciones.remove(j);
	
			}
		
			//Imprimimos el mejor de cada iteración
			System.out.println(permutaciones.get(0).myfitness+" "+i);

		}
		
		time_end = System.currentTimeMillis();
		
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");

	}
}
