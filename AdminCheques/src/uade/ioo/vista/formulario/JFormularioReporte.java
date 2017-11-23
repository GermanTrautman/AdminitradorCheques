package uade.ioo.vista.formulario;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioReporte extends JFormularioBase {

	private static final long serialVersionUID = 1L;

	private JLabel lblMontoTotal = new JLabel("0");

	public JFormularioReporte(AdministradorPagos modelo) {
		super(modelo);
		this.setLayout(new FlowLayout());
		this.getContentPane().add(new JLabel("Monto Total: $"));
		this.getContentPane().add(lblMontoTotal);

		this.actualizar();
	}

	@Override
	public void actualizar() {
		this.lblMontoTotal.setText(Double.toString(this.getModelo().getMontoTotalCheques()));
	}

}
