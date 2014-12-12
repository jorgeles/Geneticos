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
import java.util.Scanner;

public class Main {

	private static final int MAX_ALLOWED_EVOLUTIONS = 100;
	private static MyRandom randomGenerator = new MyRandom();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ArrayList<Integer> primeros = new ArrayList<Integer>();
		 * ArrayList<Integer> segundos = new ArrayList<Integer>(); int cantidad
		 * = 0;
		 * 
		 * try { Scanner sc = new Scanner(new File("bur26a.dat")); if
		 * (sc.hasNextInt()) { cantidad = sc.nextInt(); cantidad = cantidad *
		 * cantidad; } for (int i = 0; i < cantidad; i++) {
		 * primeros.add(sc.nextInt()); }
		 * 
		 * for (int i = 0; i < cantidad; i++) { segundos.add(sc.nextInt()); }
		 * sc.close(); } catch (FileNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// Start with a DefaultConfiguration, which comes setup with the
		// most common settings.
		// -------------------------------------------------------------
		Configuration conf = new DefaultConfiguration();
		try {
			conf.setRandomGenerator(randomGenerator);
		} catch (InvalidConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// Set the fitness function we want to use, which is our
		// MinimizingMakeChangeFitnessFunction that we created earlier.
		// We construct it with the target amount of change provided
		// by the user.
		// ------------------------------------------------------------
		int targetAmount = Integer.parseInt("20");
		FitnessFunction myFunc = new MinimizingMakeChangeFitnessFunction(
				targetAmount);

		try {
			conf.setFitnessFunction(myFunc);
		} catch (InvalidConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Now we need to tell the Configuration object how we want our
		// Chromosomes to be setup. We do that by actually creating a
		// sample Chromosome and then setting it on the Configuration
		// object. As mentioned earlier, we want our Chromosomes to
		// each have four genes, one for each of the coin types. We
		// want the values of those genes to be integers, which represent
		// how many coins of that type we have. We therefore use the
		// IntegerGene class to represent each of the genes. That class
		// also lets us specify a lower and upper bound, which we set
		// to sensible values for each coin type.
		// --------------------------------------------------------------
		Gene[] sampleGenes = new Gene[4];

		try {
			sampleGenes[0] = new IntegerGene(conf, 0, 4);
			sampleGenes[1] = new IntegerGene(conf, 0, 4); // Dimes
			sampleGenes[2] = new IntegerGene(conf, 0, 4); // Nickels
			sampleGenes[3] = new IntegerGene(conf, 0, 4); // Pennies
			

			Chromosome sampleChromosome = new Chromosome(conf, sampleGenes);

			conf.setSampleChromosome(sampleChromosome);

			// Finally, we need to tell the Configuration object how many
			// Chromosomes we want in our population. The more Chromosomes,
			// the larger the number of potential solutions (which is good
			// for finding the answer), but the longer it will take to evolve
			// the population each round. We'll set the population size to
			// 500 here.
			// --------------------------------------------------------------
			conf.setPopulationSize(500);
			Genotype population = Genotype.randomInitialGenotype( conf );
			IChromosome bestSolutionSoFar = population.getFittestChromosome();
			
			for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
				population.evolve();
			}

			System.out.println("The best solution contained the following: ");

			System.out.println(MinimizingMakeChangeFitnessFunction
					.getNumberOfCoinsAtGene(bestSolutionSoFar, 0) + " quarters.");

			System.out.println(MinimizingMakeChangeFitnessFunction
					.getNumberOfCoinsAtGene(bestSolutionSoFar, 1) + " dimes.");

			System.out.println(MinimizingMakeChangeFitnessFunction
					.getNumberOfCoinsAtGene(bestSolutionSoFar, 2) + " nickels.");

			System.out.println(MinimizingMakeChangeFitnessFunction
					.getNumberOfCoinsAtGene(bestSolutionSoFar, 3) + " pennies.");

			System.out.println("For a total of "
					+ MinimizingMakeChangeFitnessFunction
							.amountOfChange(bestSolutionSoFar)
					+ " cents in "
					+ MinimizingMakeChangeFitnessFunction
							.getTotalNumberOfCoins(bestSolutionSoFar) + " coins.");
			
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Quarters
		

	}

}
