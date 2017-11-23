package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPagoConCheque;
import uade.ioo.vista.modeloVista.MiModeloChequesDisponibles;

public class PagarChequeController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaPagoConCheque vista;
	
	public PagarChequeController(AdministradorPagos modelo, IVistaPagoConCheque vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		vista.getTabla().setModel(new MiModeloChequesDisponibles(modelo, vista.getMontoAPagar()));
	}
}

