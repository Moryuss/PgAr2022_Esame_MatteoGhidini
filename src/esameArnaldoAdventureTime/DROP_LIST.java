package esameArnaldoAdventureTime;

import java.util.HashMap;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class DROP_LIST {

	//numero totale oggetti
	private static HashMap<Integer, Drop> listaDrop = new HashMap<Integer, Drop>();

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

	//numero di oggetti
	private static Integer i = 0;

	/////////////FINE DROP////////////////////////




	/**
	 * sceglie tra i possibili drop uno a caso
	 * @return
	 */
	public static Drop scegliDropPerChest() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Drop scegliArma() {
		return null;
	}

	public static HashMap<Integer, Drop> getListaDrop() {
		return listaDrop;
	}

	public static void setListaDrop(HashMap<Integer, Drop> listaDrop) {
		DROP_LIST.listaDrop = listaDrop;
	}

	/**
	 * per aggiungere alla lista tutti i drop.
	 * @param d
	 */
	public static void setDropListaDrop(Drop d) {
		DROP_LIST.listaDrop.put(DROP_LIST.i, d);
		i++;
	}


}

// public static final Drop nomeDrop = new Drop();