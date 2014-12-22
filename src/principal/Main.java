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
		int poblacion = 10;
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
		//fit.CalculoFitness(permutaciones, distancias, pesos, poblacion);
		//fit.CalculoFitnessGreedy(permutaciones, distancias, pesos, poblacion);
		fit.CalculoFitnessGreedyModifica(permutaciones, distancias, pesos, poblacion);
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
			evo.GenerarPoblacion3(permutaciones, distancias, pesos);

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
			
			/*Collections.sort(permutaciones2, new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					Ciudadano p1 = (Ciudadano) o1;
					Ciudadano p2 = (Ciudadano) o2;
					return new Integer(p1.myfitness).compareTo(new Integer(
							p2.myfitness));
				}
			});
			
			Collections.sort(permutaciones3, new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					Ciudadano p1 = (Ciudadano) o1;
					Ciudadano p2 = (Ciudadano) o2;
					return new Integer(p1.myfitness).compareTo(new Integer(
							p2.myfitness));
				}
			});*/
			
			for(int j=permutaciones.size()-1; j>=poblacion; j--){
				permutaciones.remove(j);
	
			}
			/*for(int j=permutaciones2.size()-1; j>=poblacion; j--){
				permutaciones2.remove(j);
			}
			for(int j=permutaciones3.size()-1; j>=poblacion; j--){
				permutaciones3.remove(j);
			}*/
		}
		
		time_end = System.currentTimeMillis();
		

		
		for (int i = 0; i < permutaciones.size(); i++) {
			System.out.println(permutaciones.get(i).myfitness);
		}
		
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");

	}
}
