package esameArnaldoAdventureTime;

public class Boss extends Mostro {


	public static final Boss DIJKSTRA = new Boss("Il grandissimo e unico  ArciDemone Dijkstra", 40, 10, 10, DROP_LIST.FINAL_BOSS_WEAPON);
	
	
	/**
	 * creazione boss casuale
	 */
	public Boss() {
		super();
		this.setNome("il grande" + Mostro.nomeDemone(permArray));
		this.setVita(30);
		this.setBaseAtk(7);
		this.setBaseDef(7);
		this.setSpecificDrop(DROP_LIST.scegliArma(), 0);
	}
	
	/**costruttore
	 * per Dijkstra
	 * @param _nome
	 * @param _vita
	 * @param _atk
	 * @param _def
	 * @param d
	 */
	public Boss(String _nome, int _vita, int _atk, int _def, Drop d) {
		this.setNome(_nome);
		this.setVita(_vita);
		this.setBaseAtk(_atk);
		this.setBaseDef(_def);
		this.setSpecificDrop(d, 0);
	}
	

}
