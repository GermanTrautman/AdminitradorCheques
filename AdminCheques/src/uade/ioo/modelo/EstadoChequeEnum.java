package uade.ioo.modelo;

public enum EstadoChequeEnum {

	
	VENCIDO(1,"Vencido"),
	RECIBIDO(2,"Recibido"),
	ENTREGADO(3,"Entregado"),
	DEPOSITADO(4,"Depositado");
	
	Integer key;
	String value;
	
	EstadoChequeEnum(Integer key,String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
