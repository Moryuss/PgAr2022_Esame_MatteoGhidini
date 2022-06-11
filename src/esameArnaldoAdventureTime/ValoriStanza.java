package esameArnaldoAdventureTime;

public enum ValoriStanza {
	VUOTO("."), MURO("#"), MOSTRO(""), GIOCATORE("O"), CHEST("C"), PRINCESS("K"), DIJKSTRA("D"), SCALE_SU("T"), SCALE_GIU("t"), BOSS("B");
	
	public final String value;
	
	ValoriStanza(String _value) {
		this.value = _value;
	}

}
