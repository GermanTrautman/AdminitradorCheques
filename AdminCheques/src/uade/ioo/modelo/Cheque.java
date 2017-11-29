package uade.ioo.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Cheque {

	private int numero;
	private double monto;
	private Calendar calendar;
	private boolean isActive;

	public Cheque(int numero, double monto, Calendar fecha) {
		super();
		this.numero = numero;
		this.monto = monto;
		calendar = fecha;
		isActive = true;
	}

	public int getNumero() {
		return numero;
	}

	public double getMonto() {
		return monto;
	}

	public String getDate() {

		return calendar.get(Calendar.DATE) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
