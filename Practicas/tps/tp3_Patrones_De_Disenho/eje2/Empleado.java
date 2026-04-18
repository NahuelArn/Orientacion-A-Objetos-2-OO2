package eje3.eje33;

public abstract class Empleado {
	private double sueldo;
	protected static final double casado = 5000;
	protected static final double hijo = 2000;

	
	public abstract double basico();
	public abstract double adicional();
	public double descuento () {
		return this.basico() *0.13 + this.adicional() *0.5;
	}
	public double sueldo() {
		return this.basico() + this.adicional() - this.descuento();
	}
	
}
