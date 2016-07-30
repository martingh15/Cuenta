package negocio;

import java.util.ArrayList;
import entidades.Cuenta;
import util.ApplicationException;


public class CtrlABMCCuenta {


		private ArrayList<Cuenta> cuentas;
		
		public CtrlABMCCuenta(){
			cuentas = new ArrayList<>();
		}
		
		public void add(Cuenta c){
			cuentas.add(c);
			
		}
		
		public void ingreso(Cuenta c,Double cantidad) {
		
			c.setSaldo(c.getSaldo() + cantidad);
			
		}
		
		public void reintegro(Cuenta c,Double cantidad) {
			if(cantidad>=0)
			{
				
				if(c.getSaldo()>=cantidad)
				{
					c.setSaldo(c.getSaldo() - cantidad);
					
				}
				else {
					// Avisar que no tiene dinero suficiente para pagar el reintegro
					
				}
				
			
			}
			else {
				
				//Avisar que la cantidad ingresada es negativa
			}
		}
		
		public void transferencia(Cuenta cuentaO, Cuenta cuentaD, Double importe){
			if(cuentaO.getSaldo()>=importe)
			{
				cuentaO.setSaldo(cuentaO.getSaldo() - importe);
				cuentaD.setSaldo( cuentaD.getSaldo() + importe);
			
			}
			else {
				//Avisar que el saldo es insuficiente
			}
			
		}
		
		public void update(Cuenta c) throws ApplicationException {
			if(cuentas.contains(c)){
				Cuenta cuen=this.getCuenta(c);
				cuen.setNombreCli(c.getNombreCli());
				cuen.setNroCuenta(c.getNroCuenta());
				cuen.setTipoInteres(c.getTipoInteres());
				cuen.setSaldo(c.getSaldo());

			}else{
				throw new ApplicationException("La persona no existe");
			}
			
		}
		
		public Cuenta getCuenta(Cuenta c) throws ApplicationException {
			Cuenta cuen=null;
			int i=cuentas.indexOf(c);
			if(i>=0){
				cuen=cuentas.get(i);
			} else {
				throw new ApplicationException("La persona no existe");
			}
			return cuen;
			
		}
		public void delete(Cuenta c){
			cuentas.remove(c);
		}
		
		/*sc = new Scanner(System.in);
		int op;		
		
		do{
			System.out.println("Ingrese 1-Crear Cuenta\n2-Ingreso\n3-Reintegro\n4-Transferencia\n5-Salir");
			op = Integer.parseInt(sc.nextLine());
			switch(op){
			case 1:
				Cuenta c = new Cuenta();
				cargaDatosCuenta(c);
				cuentas.add(c);
				break;
			case 2: cantidad debe ser mayor que cero
				break;
			case 3: cantidad debe ser mayor que cero y el saldo debe ser suficiente para el reintegro
				break;
			case 4: cantidad debe ser mayor que cero y el saldo debe ser suficiente para el reintegro
				break;
			case 5: System.out.println("Saliendo");
				break;
			default: System.out.println("Opcion Incorrecta");
					break;
			
			}
		}
		while(op!=5);
		

	
	
	public static void cargaDatosCuenta(Cuenta c) {
		
		System.out.print("Nombre de Cliente: ");
		c.setNombreCli(sc.nextLine());
		
		System.out.print("Numero de Cuenta: ");
		c.setNroCuenta(sc.nextLine());
		
		System.out.print("Tipo Interes: ");
		c.setTipoInteres(Double.parseDouble(sc.nextLine()));
		
		System.out.print("Saldo: ");
		c.setSaldo(Double.parseDouble(sc.nextLine()));
	}
	
	public static void buscarCuenta(String nombre) {
		
		
	}*/

}
