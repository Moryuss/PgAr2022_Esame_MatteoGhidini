package esameArnaldoAdventureTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	public static final HashSet<String> permutazioni = getPermutation("dijkstra");
	public static ArrayList<String> tmp = new ArrayList<String>(permutazioni);

	public static String[] permArray =  tmp.toArray(new String[tmp.size()]);


	/**
	 * costruttore del mostro
	 */
	public Mostro() {
		super(nomeDemone(permArray), EstrazioniCasuali.estraiIntero(MIN_VITA_MOSTRO,MAX_VITA_MOSTRO) , ATK_MOSTRO, DEF_MOSTRO);
		this.setInventory(creaInv());
	}


	private static HashMap<Integer,Drop> creaInv(){
		HashMap<Integer,Drop> invent = new HashMap<Integer,Drop>();
		invent.put(0,DROP_LIST.scegliArma());
		return invent;
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


	/**
	 * estrae nome demone
	 * @param perm
	 * @return
	 */
	public static String nomeDemone(String [] perm) {
		return perm[EstrazioniCasuali.estraiIntero(0,perm.length-1)];

	}
}

