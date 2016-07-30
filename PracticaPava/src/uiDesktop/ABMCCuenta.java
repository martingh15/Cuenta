package uiDesktop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.Cuenta;
import negocio.CtrlABMCCuenta;
import util.ApplicationException;

import javax.swing.JButton;

public class ABMCCuenta {
	
	private CtrlABMCCuenta ctrl;

	private JFrame frame;
	private JTextField textNombreCli;
	private JTextField textNroCuenta;
	private JTextField textTipoInteres;
	private JTextField textSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCCuenta window = new ABMCCuenta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMCCuenta() {
		initialize();
		ctrl = new CtrlABMCCuenta();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setBounds(21, 26, 84, 14);
		frame.getContentPane().add(lblNombreCliente);
		
		JLabel lblNumeroCuenta = new JLabel("Numero Cuenta");
		lblNumeroCuenta.setBounds(21, 54, 84, 14);
		frame.getContentPane().add(lblNumeroCuenta);
		
		JLabel lblTipoDeInteres = new JLabel("Tipo de Interes");
		lblTipoDeInteres.setBounds(21, 85, 84, 14);
		frame.getContentPane().add(lblTipoDeInteres);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(21, 116, 84, 14);
		frame.getContentPane().add(lblSaldo);
		
		textNombreCli = new JTextField();
		textNombreCli.setBounds(111, 23, 86, 20);
		frame.getContentPane().add(textNombreCli);
		textNombreCli.setColumns(10);
		
		textNroCuenta = new JTextField();
		textNroCuenta.setBounds(111, 51, 86, 20);
		frame.getContentPane().add(textNroCuenta);
		textNroCuenta.setColumns(10);
		
		textTipoInteres = new JTextField();
		textTipoInteres.setBounds(111, 82, 86, 20);
		frame.getContentPane().add(textTipoInteres);
		textTipoInteres.setColumns(10);
		
		textSaldo = new JTextField();
		textSaldo.setBounds(111, 113, 86, 20);
		frame.getContentPane().add(textSaldo);
		textSaldo.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				agregar();
			}
		});
		btnAgregar.setBounds(290, 22, 89, 23);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener( new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				try {
					buscar();
				} catch (ApplicationException aeb2) {
					notifyUser(aeb2.getMessage());
				}
			}
		});
		btnBuscar.setBounds(290, 67, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modificar();
				} catch (ApplicationException aem2) {
					notifyUser(aem2.getMessage());
				}
			}
		});
		btnModificar.setBounds(290, 112, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				borrar();
			}
		});
		btnBorrar.setBounds(290, 159, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnIngreso = new JButton("Ingreso");		
		btnIngreso.setBounds(21, 159, 89, 23);
		frame.getContentPane().add(btnIngreso);
		
		JButton btnGasto = new JButton("Gasto");
		btnGasto.setBounds(21, 194, 89, 23);
		frame.getContentPane().add(btnGasto);
		
		JButton btnTransferencia = new JButton("Transferencia");
		btnTransferencia.setBounds(127, 159, 117, 23);
		frame.getContentPane().add(btnTransferencia);
	}
	
	public void agregar() {
		if(datosValidos()) {
			ctrl.add(MapearDeFormulario());
			limpiarCampos();			
		}
	}

	private boolean datosValidos() {
		boolean valido = true;
		if(textNombreCli.getText().trim().length()==0
				|| textNroCuenta.getText().trim().length()==0
				|| textTipoInteres.getText().trim().length()==0
				|| textSaldo.getText().trim().length()==0){
			valido = false;
			notifyUser("Complete todos los campos");
		}
		return valido;
	}
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
	
	public Cuenta MapearDeFormulario(){
		Cuenta c = new Cuenta();
		c.setNombreCli(textNombreCli.getText());
		c.setNroCuenta(textNroCuenta.getText());
		String cadena;
		cadena = textTipoInteres.getText();
		Double a = Double.parseDouble(cadena.trim());		
		c.setTipoInteres(a);
		String cadena2;
		cadena2 = textTipoInteres.getText();
		Double a2 = Double.parseDouble(cadena.trim());		
		c.setTipoInteres(a2);
		c.setSaldo(a2);		
		return c;
	}
	
	public void limpiarCampos(){
		textNombreCli.setText("");
		textNroCuenta.setText("");
		textTipoInteres.setText("");
		textSaldo.setText("");
	}
	
	public void modificar() throws ApplicationException{
		try{
			ctrl.update(MapearDeFormulario());
			limpiarCampos();
		}
		catch(ApplicationException aem){
			notifyUser(aem.getMessage());
		}
				
	}
	
	public void buscar() throws ApplicationException{
		try{
				Cuenta c = ctrl.getCuenta(MapearDeFormulario());
				if(c!=null){
				MapearDeFormulario(c);
				}
		   }
			catch(ApplicationException aeb) {
				notifyUser(aeb.getMessage());
				}
			}
		
		
	
	public void MapearDeFormulario(Cuenta c){
		textNombreCli.setText(String.valueOf(c.getNombreCli()).trim());
		textNroCuenta.setText(String.valueOf(c.getNroCuenta()).trim());
		textTipoInteres.setText(String.valueOf(c.getTipoInteres()).trim());
		textSaldo.setText(String.valueOf(c.getSaldo()).trim());

	}
	
	public void borrar(){
		ctrl.delete(MapearDeFormulario());
		limpiarCampos();
	}
	
}
