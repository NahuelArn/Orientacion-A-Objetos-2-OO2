package eje3.eje33;

public class EmpleadoPasante extends Empleado{
	private static final double COSTOExamenR = 2000;
	private int cantidadDeExamenesRindio;
	
	public double basico() {
		return COSTOExamenR;
	}
	public double adicional() {
		return cantidadDeExamenesRindio * COSTOExamenR;
	}
}
