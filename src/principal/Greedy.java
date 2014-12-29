package principal;

import java.util.ArrayList;

public class Greedy {

	private Ciudadano miciudadano;
	private Ciudadano miciudadano2;

	/*
	 * Implmentación de un algortimo tipo Greedy
	 */
	@SuppressWarnings("unchecked")
	public Ciudadano Procesar(Ciudadano ciudadano,ArrayList<ArrayList<Integer>> distancias,
			ArrayList<ArrayList<Integer>> pesos) {
		Fitness fit = new Fitness();
		miciudadano = new Ciudadano();
		miciudadano2 = new Ciudadano();
		miciudadano.myfitness = ciudadano.myfitness;
		miciudadano.mypermutaciones = (ArrayList<Integer>) ciudadano.mypermutaciones
				.clone();
		miciudadano2.myfitness = ciudadano.myfitness;

		for (int i = 0; i < miciudadano.mypermutaciones.size(); i++) {

			miciudadano2.mypermutaciones = (ArrayList<Integer>) miciudadano.mypermutaciones
					.clone();
			for (int j = i + 1; j < miciudadano.mypermutaciones.size(); j++) {
				int aux = miciudadano2.mypermutaciones.get(i);
				miciudadano2.mypermutaciones.remove(i);
				miciudadano2.mypermutaciones.add(i, miciudadano2.mypermutaciones.get(j-1));
				miciudadano2.mypermutaciones.remove(j);
				miciudadano2.mypermutaciones.add(j, aux);
				fit.MyFitness(miciudadano2, distancias, pesos);
				if(miciudadano2.myfitness<miciudadano.myfitness){
					miciudadano.myfitness=miciudadano2.myfitness;
					miciudadano.mypermutaciones = (ArrayList<Integer>) miciudadano2.mypermutaciones
							.clone();
				}

			}
		}
		return miciudadano;

	}
}
