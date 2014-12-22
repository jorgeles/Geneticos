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
		int iteraciones = 5;
		ArrayList<Ciudadano> permutaciones = new ArrayList<Ciudadano>();
		ArrayList<Ciudadano> permutaciones2 = new ArrayList<Ciudadano>();
		ArrayList<Ciudadano> permutaciones3 = new ArrayList<Ciudadano>();
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		/*
		 * Genero los primeros ciudadanos
		 */
		Permutaciones permutacion = new Permutaciones();
		for (int i = 0; i < poblacion; i++) {
			Ciudadano aux = new Ciudadano();
			aux.mypermutaciones = permutacion.Permutacion(max, min, cantidad);
			permutaciones2.add(aux);
		}
		/*for(int i=0; i<permutaciones.size(); i++){
			Ciudadano aux2 = new Ciudadano();
			aux2.myfitness = permutaciones.get(i).myfitness;
			aux2.mypermutaciones = (ArrayList<Integer>) permutaciones.get(i).mypermutaciones
					.clone();
			Ciudadano aux3 = new Ciudadano();
			aux3.myfitness = permutaciones.get(i).myfitness;
			aux3.mypermutaciones = (ArrayList<Integer>) permutaciones.get(i).mypermutaciones
					.clone();
			permutaciones2.add(aux2);
			permutaciones3.add(aux3);
		}*/
		//fit.CalculoFitness(permutaciones, distancias, pesos, poblacion);
		fit.CalculoFitnessGreedy(permutaciones2, distancias, pesos, poblacion);
		//fit.CalculoFitnessGreedyModifica(permutaciones3, distancias, pesos, poblacion);

		/*
		 * Compara los ciudadanos y los odeno en fución de su fitness
		 */
		Collections.sort(permutaciones2, new Comparator<Object>() {
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
		
		for (int i = 0; i < iteraciones; i++) {
			System.out.println("H");
			/*
			 * Genero poblacion nueva
			 */
			//evo.GenerarPoblacion(permutaciones, distancias, pesos);
			evo.GenerarPoblacion2(permutaciones2, distancias, pesos);
			//evo.GenerarPoblacion3(permutaciones3, distancias, pesos);
			/*for (int p = 0; p < permutaciones.size(); p++) {
				System.out.println(permutaciones2.get(p).myfitness+" AAA   "+permutaciones3.get(p).myfitness);
			}*/
			/*
			 * Compara los ciudadanos y los odeno en fución de su fitness
			 */
			Collections.sort(permutaciones2, new Comparator<Object>() {
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
			
			for(int j=permutaciones2.size()-1; j>=poblacion; j--){
				permutaciones2.remove(j);
	
			}
			/*for(int j=permutaciones2.size()-1; j>=poblacion; j--){
				permutaciones2.remove(j);
			}
			for(int j=permutaciones3.size()-1; j>=poblacion; j--){
				permutaciones3.remove(j);
			}*/
		}
		
		time_end = System.currentTimeMillis();
		

		
		for (int i = 0; i < permutaciones2.size(); i++) {
			System.out.println(permutaciones2.get(i).myfitness);
		}
		
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");

	}
}
