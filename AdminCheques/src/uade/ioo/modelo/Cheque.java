package uade.ioo.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Cheque {
	
	private int numero;
	private double monto;
	private Calendar calendar = new GregorianCalendar();
	private boolean isActive;

	public Cheque(int numero, double monto) {
		super();
		this.numero = numero;
		this.monto = monto;
		isActive = true;
	}

	public int getNumero() {
		return numero;
	}

	public double getMonto() {
		return monto;
	}

	public String getDate() {

		return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 2) + "-"
				+ calendar.get(Calendar.DATE);
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
