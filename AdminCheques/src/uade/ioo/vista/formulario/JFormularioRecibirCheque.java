package uade.ioo.vista.formulario;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.util.Util;
import uade.ioo.vista.comportamiento.IVistaAgregarChequeTercero;
import uade.ioo.vista.controlador.AgregarChequeTerceroController;

public class JFormularioRecibirCheque extends JFormularioBase implements IVistaAgregarChequeTercero {

	private static final long serialVersionUID = 1L;

	private JTextField txtMonto = new JTextField();
	private JTextField txtNumero = new JTextField();
	private JTextField txtFecha = new JTextField();
	private JButton btnAgregarCheque = new JButton("Agregar Cheque");

	public JFormularioRecibirCheque(AdministradorPagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.getContentPane().add(new JLabel("Numero :"));
		this.getContentPane().add(txtNumero);
		this.getContentPane().add(new JLabel("Monto :"));
		this.getContentPane().add(txtMonto);
		this.getContentPane().add(new JLabel("Fecha :"));
		this.getContentPane().add(txtFecha);
		this.getContentPane().add(btnAgregarCheque);

		this.btnAgregarCheque.addActionListener(new AgregarChequeTerceroController(this.getModelo(), this));

		btnAgregarCheque.setMaximumSize(getMaximumSize());
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	public int getNumero() {
		if (Util.isInteger(this.txtNumero.getText())) {
			return Integer.parseInt(this.txtNumero.getText());
		}
		return 0;
	}

	public double getMonto() {
		if (Util.isDouble(this.txtMonto.getText())) {
			return Double.parseDouble(this.txtMonto.getText());
		}
		return 0;
	}
	
	public Calendar getFecha() {
		String strFecha[] = this.txtFecha.getText().split("/|-");
		return new GregorianCalendar(Integer.valueOf(strFecha[2]), Integer.valueOf(strFecha[1]), Integer.valueOf(strFecha[0]));
	}

	@Override
	public void reset() {

		this.txtMonto.setText("");
		this.txtNumero.setText("");
	}

}
