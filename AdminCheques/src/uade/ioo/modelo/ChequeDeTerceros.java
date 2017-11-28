package uade.ioo.modelo;

public class ChequeDeTerceros extends Cheque {
	
	private EstadoChequeEnum estadoCheque;

	public ChequeDeTerceros(int numero, double monto) {
		super(numero, monto);
		estadoCheque = EstadoChequeEnum.RECIBIDO;
	}
	
	public EstadoChequeEnum getEstadoCheque() {
		return estadoCheque;
	}

	public void setEstadoCheque(EstadoChequeEnum estadoCheque) {
		this.estadoCheque = estadoCheque;
	}

}
