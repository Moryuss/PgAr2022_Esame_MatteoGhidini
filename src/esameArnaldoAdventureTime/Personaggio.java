package esameArnaldoAdventureTime;

import java.util.HashMap;

/**
 * classe rapprensentante il giocatore
 * @author Matteo Ghidini
 *
 */
public class Personaggio extends Being {

	public static final int MAX_VITA = 20;
	public static final int ATK = 5;
	public static final int DEF = 5;

	
	/**
	 * costruttore  con limitazioni iniziali, impostato il nome il resto si fa da solo (quello che userò prob)
	 * @param nome
	 */
	public Personaggio(String nome) {
		super(nome, MAX_VITA, ATK, DEF);
		// TODO Auto-generated constructor stub
	}
	
}


