package esameArnaldoAdventureTime;

/**
 * Ogni tipo di drop che i Being possono avere sono Drop; <br>
 * I comsumabili hanno un timeLimit pari al numero di turni; i non consumabili pari a -1 (per indicare infinito).
 * @author Matteo Ghidini
 *
 */
public class Drop {

	private Effect effetto;
	private String nome;
	private int value;
	private String descrizione;
	private int timeLimit;

	@Override
	/**
	 * toString che ritorna tutte le info di un drop con differenza tra consumabile o meno
	 */
	public String toString() {
		if(this.timeLimit == -1)
			return "Drop : \n\tnome del drop :" + nome + 
					"\n\t effetto :" + effetto +
					"\n\tValore :" + value +
					"\n\tdescrizione :" + descrizione;
		else return "Drop : \n\tnome del drop :" + nome + 
				"\n\t effetto :" + effetto +
				"\n\tValore :" + value +
				"\n\tDurata consumabile : " + this.timeLimit + " turni"+
				"\n\tdescrizione :" + descrizione;
	}

	
	
	/**Costruttore di Drop totale
	 * @param effetto
	 * @param nome
	 * @param value
	 * @param descrizione
	 * @param timeLimit
	 */
	public Drop(Effect effetto, String nome, int value, String descrizione, int timeLimit) {
		super();
		this.effetto = effetto;
		this.nome = nome;
		this.value = value;
		this.descrizione = descrizione;
		this.timeLimit = timeLimit;
	}



	


}
