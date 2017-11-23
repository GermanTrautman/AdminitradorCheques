package uade.ioo.vista.formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioPrincipal extends JFormularioBase {

	private static final long serialVersionUID = 1L;

	public JFormularioPrincipal(AdministradorPagos modelo) {
		super(modelo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu items = new JMenu("Formularios");
		menu.add(items);
		
		JMenuItem opcAgregarCheque = new JMenuItem("Agregar Cheque Terceros");		
		items.add(opcAgregarCheque);
		opcAgregarCheque.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFormularioRecibirCheque(getModelo());
				f.setVisible(true);				
			}		
		});
		
		JMenuItem opcReporte = new JMenuItem("Reporte");
		items.add(opcReporte);
		opcReporte.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFormularioReporte(getModelo());
				f.setVisible(true);				
			}		
		});
		
		JMenuItem opcPago = new JMenuItem("Pagar...");
		items.add(opcPago);
		opcPago.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFormularioPago(getModelo());
				f.setVisible(true);				
			}
		
		});
		
		JMenuItem opcProxAVencer = new JMenuItem("Cheques proximos a vencer");
		items.add(opcProxAVencer);
		opcProxAVencer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFormularioChequesPorVencer(getModelo());
				f.setVisible(true);
				
			}
		});
		
		this.setJMenuBar(menu);
	}

	@Override
	public void actualizar() {
		// No hago nada		
	}

}
