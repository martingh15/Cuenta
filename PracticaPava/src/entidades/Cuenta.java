package entidades;

public class Cuenta {
	String nombreCli, nroCuenta;
	Double tipoInteres, saldo;
	
	public String getNombreCli() {
		return nombreCli;
	}
	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}
	public String getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public Double getTipoInteres() {
		return tipoInteres;
	}
	public void setTipoInteres(Double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Cuenta(){
			
	}
	
	public Cuenta(String nombre, String numero, Double saldo, Double tipo){
		this.nombreCli = nombre;
		this.nroCuenta = numero;
		this.saldo = saldo;
		this.tipoInteres = tipo;
	}
	
	@Override
	public boolean equals(Object cuen){
		return cuen instanceof Cuenta&& ((Cuenta)cuen).getNombreCli() == this.getNombreCli();
	}
	
	/*public boolean ingreso(Double cantidad) {
		if(cantidad>=0)
		{
			saldo = saldo + cantidad;
			return true;
		}
		else {
			return false;
		}
		
	}*/
	
/*	public boolean reintegro(Double cantidad) {
		if(cantidad>=0)
		{
			boolean rta; 
			if(saldo>=cantidad)
			{
				saldo = saldo - cantidad;
				rta = true;
			}
			else {
				rta = false;
			}
			
			return rta;
		}
		else {
			
			return false;
		}
	}*/
	
	/*public void transferencia(Cuenta cuentaO, Cuenta cuentaD, Double importe){
		if(saldo>=importe)
		{
			cuentaO.setSaldo(cuentaO.getSaldo() - importe);
			cuentaD.setSaldo( cuentaD.getSaldo() + importe);
		
		}
		else {
			
		}
		
	}*/
	
	
	

}
