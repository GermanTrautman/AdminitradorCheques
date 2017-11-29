package uade.ioo.vista.formulario;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPagoConCheque;

public class JFormularioReporte extends JFormularioBase  implements IVistaPagoConCheque {

	private static final long serialVersionUID = 1L;

	//private JLabel lblMontoTotal = new JLabel();
	private JLabel lblMontoDisponible = new JLabel();
	private JLabel lblMontoPagado = new JLabel();
	private JLabel lblMontoDepositado = new JLabel();
	private JLabel lblMontoEmitido = new JLabel();
	private JLabel lblMontoAVencer = new JLabel();
	JTable tabla;

	public JFormularioReporte(AdministradorPagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		//this.getContentPane().add(new JLabel("Monto Total"));
		//this.getContentPane().add(lblMontoTotal);
		this.getContentPane().add(new JLabel("Monto disponible para realizar pagos de cheques de terceros"));
		this.getContentPane().add(lblMontoDisponible);
		this.getContentPane().add(new JLabel("Monto pagado"));
		this.getContentPane().add(lblMontoPagado);
		this.getContentPane().add(new JLabel("Monto depositado en el banco"));
		this.getContentPane().add(lblMontoDepositado);
		this.getContentPane().add(new JLabel("Monto de dinero emitido en cheques"));
		this.getContentPane().add(lblMontoEmitido);
		this.getContentPane().add(new JLabel("Monto de cheques próximos a vencer"));
		this.getContentPane().add(lblMontoAVencer);

		this.actualizar();
	}

	@Override
	public void actualizar() {
		//this.lblMontoTotal.setText(Double.toString(this.getModelo().getMontoTotalCheques()));
		this.lblMontoDisponible.setText(Double.toString(this.getModelo().getMontoDisponible()));
		this.lblMontoPagado.setText(Double.toString(this.getModelo().getMontoPagado()));
		this.lblMontoDepositado.setText(Double.toString(this.getModelo().getMontoDepositado()));
		this.lblMontoEmitido.setText(Double.toString(this.getModelo().getMontoEmitido()));
		this.lblMontoAVencer.setText(Double.toString(this.getModelo().getMontoAVencer()));
	}

	@Override
	public double getMontoAPagar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JTable getTabla() {
		// TODO Auto-generated method stub
		return null;
	}

}
