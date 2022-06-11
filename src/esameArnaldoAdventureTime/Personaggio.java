package esameArnaldoAdventureTime;

/**
 * classe rapprensentante il giocatore
 * @author Matteo Ghidini
 *
 */
public class Personaggio extends Being {

	public static final int MAX_VITA = 20;
	public static final int ATK = 5;
	public static final int DEF = 5;
	
	/*private int vita = MAX_VITA;
	private int baseAtk = ATK; 
	private int baseDef= DEF;
	*/	
	

	/**Costruttore assoluto NEL CASO SERVA MA NON DOVREBBE
	 * @param nome
	 * @param vita
	 * @param baseAtk
	 * @param baseDef
	 * @param inventory
	 */
	public Personaggio(String nome, int vita, int baseAtk, int baseDef, Drop[] inventory) {
		super(nome, vita, baseAtk, baseDef, inventory);
		// TODO Auto-generated constructor stub
	}

	/**costruttore senza inventario
	 * @param nome
	 * @param vita
	 * @param baseAtk
	 * @param baseDef
	 */
	public Personaggio(String nome, int vita, int baseAtk, int baseDef) {
		super(nome, vita, baseAtk, baseDef);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * costruttore  con limitazioni iniziali, impostato il nome il resto si fa da solo (quello che userò prob)
	 * @param nome
	 */
	public Personaggio(String nome) {
		super(nome, MAX_VITA, ATK, DEF);
		// TODO Auto-generated constructor stub
	}

	}


