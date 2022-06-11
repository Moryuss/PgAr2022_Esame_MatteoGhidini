package esameArnaldoAdventureTime;

/**
 * Classe per rappresentare ogni tipo di mob vivente nel gioco (no principessa Kibo)
 * @author Matteo Ghidini
 *
 */
public class Being {

	private String nome;
	private int vita;
	private int baseAtk; 
	private int baseDef;
	private Drop[] inventory;
	
	/**Costruttore totale
	 * @param nome
	 * @param vita
	 * @param baseAtk
	 * @param baseDef
	 * @param inventory
	 */
	public Being(String nome, int vita, int baseAtk, int baseDef, Drop[] inventory) {
		super();
		this.nome = nome;
		this.vita = vita;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.inventory = inventory;
	}

	/**Costruttore solo con nome
	 * @param nome
	 */
	public Being(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * costruttore senza inventario
	 * @param nome
	 * @param vita
	 * @param baseAtk
	 * @param baseDef
	 */
	public Being(String nome, int vita, int baseAtk, int baseDef) {
		super();
		this.nome = nome;
		this.vita = vita;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
	}

	///////////////////////////////////////////inizio getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getBaseAtk() {
		return baseAtk;
	}

	public void setBaseAtk(int baseAtk) {
		this.baseAtk = baseAtk;
	}

	public int getBaseDef() {
		return baseDef;
	}

	public void setBaseDef(int baseDef) {
		this.baseDef = baseDef;
	}

	public Drop[] getInventory() {
		return inventory;
	}

	public void setInventory(Drop[] inventory) {
		this.inventory = inventory;
	}
	///////////////////////////////////////////////////fine getters e setters
	
	/**
	 * prende un drop specifico
	 * @param i
	 * @return
	 */
	public Drop getSpecificDrop(int i) {
		return inventory[i];
	}
	
	/**
	 * imposta un drpo specifico nell'inventario (sostituendo quello presente senza controlli)
	 * @param d
	 * @param i
	 */
	public void setSpecificDrop(Drop d, int i) {
		this.inventory[i] = d;
	}
	
	
	
	
	
}
