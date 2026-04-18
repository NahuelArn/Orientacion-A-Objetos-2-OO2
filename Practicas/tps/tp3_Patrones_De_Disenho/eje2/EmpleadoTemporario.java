package eje3.eje33;

public class EmpleadoTemporario extends Empleado{
	private static final double COSTO = 20000;
	private int cantidad_horas_trabajo;
	private boolean estaCasado;
	private int cantHijos;
	
	public double basico() {
		return COSTO + cantidad_horas_trabajo *300;
	}
	public double adicional() {
		return estaCasado? casado+ cantHijos*hijo: cantHijos * hijo;
		
	}
	
}
