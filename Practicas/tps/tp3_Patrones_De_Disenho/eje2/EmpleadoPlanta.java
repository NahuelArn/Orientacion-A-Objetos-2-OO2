package eje3.eje33;

public class EmpleadoPlanta extends Empleado{
	private static final double COSTO = 50000;
	private static final double costoAntiguedad = 2000;

	private boolean estaCasado;
	private int cantHijos;
	private int cantAnhosAntiguedad;
	
	public double basico() {
		return COSTO;
	}
	public double adicional() {
		return estaCasado? casado + (cantHijos * hijo) + (costoAntiguedad*cantAnhosAntiguedad):(cantHijos * hijo) + (costoAntiguedad*cantAnhosAntiguedad);
	}
}
