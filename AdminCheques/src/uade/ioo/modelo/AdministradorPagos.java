package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uade.ioo.observer.Observado;

public class AdministradorPagos extends Observado {

	private List<Cheque> cheques;
	private Chequera chequera;

	public AdministradorPagos() {
		cheques = new ArrayList<Cheque>();
		chequera = new Chequera();
	}

	public void registrarChequeTerceros(ChequeDeTerceros cheque) {
		this.cheques.add(cheque);
		this.notificarObservadores();
	}

	// Por cada cálculo que me solicitan en el enunciado
	// voy a agregar un métido del administrador que lo realice.
	public double getMontoTotalCheques() {
		double result = 0;
		for (Cheque c : cheques) {
			result += c.getMonto();
		}
		for (Cheque c : chequera.getCheques()) {
			result += c.getMonto();
		}
		return result;
	}

	public double getMontoDisponible() {
		double result = 0;
		for (Cheque c : cheques) {
			ChequeDeTerceros c2 = (ChequeDeTerceros) c;
			if (c2.getEstadoCheque() == EstadoChequeEnum.RECIBIDO) {
				result += c2.getMonto();
			}
		}
		return result;
	}

	public double getMontoPagado() {
		double result = 0;
		for (Cheque c : cheques) {
			ChequeDeTerceros c2 = (ChequeDeTerceros) c;
			if (c2.getEstadoCheque() == EstadoChequeEnum.ENTREGADO) {
				result += c2.getMonto();
			}
		}
		for (Cheque c : chequera.getCheques()) {
			result += c.getMonto();
		}
		return result;
	}

	public double getMontoDepositado() {
		double result = 0;
		for (Cheque c : cheques) {
			ChequeDeTerceros c2 = (ChequeDeTerceros) c;
			if (c2.getEstadoCheque() == EstadoChequeEnum.DEPOSITADO) {
				result += c2.getMonto();
			}
		}
		return result;
	}

	public double getMontoEmitido() {
		double result = 0;
		for (Cheque c : chequera.getCheques()) {
			result += c.getMonto();
		}
		return result;
	}

	public double getMontoAVencer() {
		double result = 0;
		for (Cheque c : cheques) {
			long segundos = (c.getCalendar().getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) / 1000;
			int horas = (int) (segundos / 3600);
			if (horas >= 0 && horas <= 48) {
				result += c.getMonto();
			}
		}
		return result;
	}

	public List<Cheque> getListaDeCheques() {
		return this.cheques;

	}

	public Chequera getChequera() {
		return chequera;
	}

	public void setChequera(Chequera chequera) {
		this.chequera = chequera;
	}

	public List<Cheque> getListaChequeParaPagarMonto(Double monto) {
		List<Cheque> chequesTemp = new ArrayList<Cheque>();
		for (int i = 0; i < cheques.size(); i++) {
			if (cheques.get(i).getMonto() > monto) {
				chequesTemp.add(cheques.get(i));
			}
		}
		return chequesTemp;
	}

	public void actualizarEstadoCheque(int idCheque, double monto) {

		boolean buscar = true;
		for (int i = 0; i < cheques.size() && buscar; i++) {
			if (cheques.get(i).getNumero() == idCheque) {
				double diferencia = monto - cheques.get(i).getMonto();
				if (diferencia > 0) { // si se paga con un cheque de monto inferior, se emite uno propio
					ChequePropio c = new ChequePropio(chequera.getCheques().size() + 1, diferencia);
					chequera.getCheques().add(c);
				}
				((ChequeDeTerceros) cheques.get(i)).setEstadoCheque(EstadoChequeEnum.ENTREGADO);
				cheques.get(i).setActive(false);
				buscar = false;
			}
		}
	}

	public void depositarCheque(int idCheque) {
		boolean buscar = true;
		for (int i = 0; i < cheques.size() && buscar; i++) {
			if (cheques.get(i).getNumero() == idCheque) {
				((ChequeDeTerceros) cheques.get(i)).setEstadoCheque(EstadoChequeEnum.DEPOSITADO);
				buscar = false;
			}
		}
	}

}
