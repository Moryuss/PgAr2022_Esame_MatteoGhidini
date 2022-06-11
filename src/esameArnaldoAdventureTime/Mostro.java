package esameArnaldoAdventureTime;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Mostro extends Being {

	//	vita minima e massima del mostro
	private static final int MIN_VITA_MOSTRO = 15;
	private static final int MAX_VITA_MOSTRO = 25;
	
	//	difesa base del moasto
	private static final int DEF_MOSTRO = 5;
	//attacco base del mostro
	private static final int ATK_MOSTRO = 5;


	//permutazioni del nome del boss finale : Dijkstra
	public static final HashSet<String> permutazioni = getPermutation("Dijkstra");
	public static String[] permArray= (String[]) permutazioni.toArray();


	/**
	 * costruttore del mostro
	 */
	public Mostro() {
		super(permArray[EstrazioniCasuali.estraiIntero(0,permArray.length-1)], EstrazioniCasuali.estraiIntero(MIN_VITA_MOSTRO,MAX_VITA_MOSTRO) , ATK_MOSTRO, DEF_MOSTRO);
		this.setSpecificDrop(DROP_LIST.scegliArma(),0);
		// TODO Auto-generated constructor stub
	}



	/**
	 * ritorna tutte le permutazioni di una parola
	 * @param str
	 * @return
	 */
	public static HashSet<String> getPermutation(String str) {

		// create a set to avoid duplicate permutation
		HashSet<String> permutations = new HashSet<String>();

		// check if string is null
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			// terminating condition for recursion
			permutations.add("");
			return permutations;
		}

		// get the first character
		char first = str.charAt(0);

		// get the remaining substring
		String sub = str.substring(1);

		// make recursive call to getPermutation()
		Set<String> words = getPermutation(sub);

		// access each element from words
		for (String strNew : words) {
			for (int i = 0;i<=strNew.length();i++){

				// insert the permutation to the set
				permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
			}
		}
		return permutations;
	}
}


