package esameArnaldoAdventureTime;

import java.util.HashMap;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class DROP_LIST {

	//numero totale oggetti
	private static HashMap<Integer, Drop> listaDrop = new HashMap<Integer, Drop>();
	private static HashMap<Integer, Drop> dropAtk = new HashMap<Integer, Drop>();
	private static HashMap<Integer, Drop> dropDef = new HashMap<Integer, Drop>();
	private static HashMap<Integer, Drop> dropHealing = new HashMap<Integer, Drop>();
	//vita che ha lo scudo
	private static final int DEFUP_VALUE = 5;

	//vslori minimi e massimo per un atkup effect 
	private static final int MIN_DMG_UP = 35;
	private static final int MAX_DMG_UP = 55;

	///////////////DROP////////////////////
	//////////	Effect effetto, String nome, int value, String descrizione, int timeLimit


	public static final Drop spada = new Drop(Effect.ATKUP,  "spada", EstrazioniCasuali.estraiIntero(MIN_DMG_UP, MAX_DMG_UP), "una spada comune senza alcun valore", -1);
	public static final Drop scudo = new Drop(Effect.DEFUP, "scudo", DEFUP_VALUE, "uno scudo comune senza alcun valore", -1);
	public static final Drop pozione = new Drop(Effect.HEALING, "pozione", Personaggio.MAX_VITA/2, "una pozione di un alchimista fallito", 1);



	/////////////FINE DROP////////////////////////


	/**
	 * sceglie tra i possibili drop uno a caso <br> NB per cambiare le probabilità si deve cambiare il metodo 
	 * @return
	 */
	public static Drop scegliDropPerChest() {
		int scelta = EstrazioniCasuali.estraiIntero(1, 100);
	
		if(scelta<=40) return DROP_LIST.scegliArma();
		else if(scelta>40 && scelta<=75) return DROP_LIST.scegliDifesa();
		else if(scelta>75) return DROP_LIST.scegliHealing();
		else return null;	 //non dovrebbe mai capitare
	}

	/**
	 * Metodo che restituisce un arma casuale dall'hasmap dell' atk
	 * @return
	 */
	public static Drop scegliArma() {
		return DROP_LIST.dropAtk.get(EstrazioniCasuali.estraiIntero(0,DROP_LIST.dropAtk.size()-1));
	}

	/**
	 * Metodo che restituisce uno  scudo casuale dall'hashmap della def
	 * @return
	 */
	public static Drop scegliDifesa() {
		return DROP_LIST.dropDef.get(EstrazioniCasuali.estraiIntero(0,DROP_LIST.dropDef.size()-1));
	}

	/**
	 * Metodo che restituisce una pozione dall'hashmap dell'Healing
	 * @return
	 */
	public static Drop scegliHealing() {
		return DROP_LIST.dropHealing.get(EstrazioniCasuali.estraiIntero(0,DROP_LIST.dropHealing.size()-1));
	}



	//numero di oggetti
	private static Integer i = 0;
	/**
	 * per aggiungere alle liste tutti i drop. manulamente...
	 * @param d
	 */
	public static void setDropListaDrop() {

		DROP_LIST.listaDrop.put(DROP_LIST.i, spada);

		DROP_LIST.dropAtk.put(DROP_LIST.i, spada );
		DROP_LIST.dropDef.put(DROP_LIST.i, scudo );
		DROP_LIST.dropHealing.put(DROP_LIST.i, pozione );
		i++;
		////////////////////////////////////////////////
		DROP_LIST.listaDrop.put(i,scudo);

		i++;
		////////////////////////////////////////////////
		DROP_LIST.listaDrop.put(i,pozione);
	}


}

// public static final Drop nomeDrop = new Drop();