package esameArnaldoAdventureTime;

import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	private HashMap<Integer, Drop> inventory;

	/**Costruttore totale
	 * @param nome
	 * @param vita
	 * @param baseAtk
	 * @param baseDef
	 * @param inventory
	 */
	public Being(String nome, int vita, int baseAtk, int baseDef, HashMap<Integer,Drop> inventory) {
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

	public HashMap<Integer,Drop> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<Integer,Drop> inventory) {
		this.inventory = inventory;
	}
	///////////////////////////////////////////////////fine getters e setters

	/**
	 * prende un drop specifico
	 * @param i
	 * @return
	 */
	public Drop getSpecificDrop(int i) {
		return inventory.get(i);
	}

	/**
	 * imposta un drpo specifico nell'inventario (sostituendo quello presente senza controlli)
	 * @param d
	 * @param i
	 */
	public void setSpecificDrop(Drop d, int i) {
		this.inventory.put(i, d);
	}

	/**
	 * se il Being viene danneggiato DIRETTAMENTE SENZA SCUDO oppure lo scudo non era abbastanza forte per attutire tutto il colpo
	 * @param value
	 */
	private void togliVita(int value) {
		this.vita =this.vita - value;
	}

	/**
	 * 
	 * @param value
	 */
	public String danneggiato(int value) {
		for(int i=0; i<this.inventory.size(); i++) {
			if(this.inventory.get(i).getEffetto().equals(Effect.DEFUP)) { //controllo durabilita scudo

				//se lo scudo si rompe e il giocatore prende danni
				if(this.inventory.get(i).getValue()<value) {
					this.togliVita(value-inventory.get(i).getValue()); //prende danno

					Drop tmp = this.inventory.get(i);
					this.inventory.remove(i);
					return String.format("%s ha subito %d danni dopo che %s si è rotto", this.nome,value -tmp.getValue(), tmp.getNome());
				}

				//se lo scudo non si rompe 
				else if(this.inventory.get(i).getValue()>value) {
					this.inventory.get(i).setValue(this.inventory.get(i).getValue()-value);
					return String.format("%s non ha subito danni ma %s ha perso %d di durabilita", this.nome, this.inventory.get(i).getNome(), value);
				}

				//si rompe lo scudo ma il giocatore non prende danni
				else if(this.inventory.get(i).getValue()>value) {

					Drop tmp = this.inventory.get(i);
					this.inventory.remove(i);
					return String.format("%s di %s è andato distrutto",tmp.getNome(), this.nome);
				}

			}
		}
		return "ERROR";
	}


	/**
	 * se il danno inflitto è superiore alla vita del mostro esso viene ucciso
	 */
	public void morto() {
		this.vita=0;

	}







}
