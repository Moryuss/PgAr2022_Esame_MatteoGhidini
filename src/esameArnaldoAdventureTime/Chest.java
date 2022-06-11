package esameArnaldoAdventureTime;

public class Chest {

	private Drop contenuto;

	/**
	 * Viene creato scegliendo uno tra i tanti drop disponibili
	 * @param contenuto
	 */
	public Chest() {
		super();
		this.contenuto=DROP_LIST.scegliDropPerChest();
	}
	
	
}
