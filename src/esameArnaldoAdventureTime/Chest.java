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

	///getter e setter
	public Drop getContenuto() {
		return contenuto;
	}

	public void setContenuto(Drop contenuto) {
		this.contenuto = contenuto;
	}
	///fine getter e setter
	
	
	
}
