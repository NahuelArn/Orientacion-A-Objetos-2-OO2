public class Usuario { 
    TipoSubscripcion tipoSubscripcion; 
    // ... 
 
    public void setTipoSubscripcion(String unTipo) { 
      this.tipoSubscripcion = unTipo; 
    } 
     
    public double calcularCostoPelicula(Pelicula pelicula) { 
      return this.unTipo.calcularCostoPelicula(pelicula);
    } 
} 

public class TipoSubscripcion{
  double costo = 0;
  public double calcularCostoPelicula(Pelicula pelicula){
      return this.costo;
  }
}

public class Basico extends TipoSubscripcion{
  public double calcularCostoPelicula(Pelicula pelicula){
    return super.calcularCostoPelicula() + pelicula.calcularCargoExtraPorEstreno(); 
  }
}

public class Familia extends TipoSubscripcion{
  protected static final double CARGOEXTRA = 0.90;
  
  public double calcularCostoPelicula(Pelicula pelicula){
    return super.calcularCostoPelicula() + pelicula.calcularCargoExtraPorEstreno()* CARGOEXTRA; 
  }
}

public class Plus extends TipoSubscripcion{
  public double calcularCostoPelicula(Pelicula pelicula){
    return super.calcularCostoPelicula(); 
  }
}

public class Premium extends TipoSubscripcion{
    protected static final double CARGOEXTRA = 0.75;
  public double calcularCostoPelicula(Pelicula pelicula){
    return super.calcularCostoPelicula() + pelicula.calcularCargoExtraPorEstreno(); 
  }
}
 
public class Pelicula {
	private static final double CARGO_ESTRENO = 300.0;
    LocalDate fechaEstreno;
    // ...

    public double getCosto() {
	    return this.costo;
	}

	public double calcularCargoExtraPorEstreno(){
		return esEstreno()? 0 : CARGO_ESTRENO;
    }
    
    private boolean esEstreno(){
	    return ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) > 30;
    }
}
 
 
Bad Smells
Switch Statement: Hay una cadena muy grande de if - else if que hacen el codigo dificil de seguir
Comments: El codigo no es auto explicativo, por lo que hace uso de comentarios
Magic Numbers: 30, 0 y 300
Primitive Obsession: Quiere representar el tipo de suscripcion con un string cuando este tiene comportamiento propio


Refactorings
Replace Data value with Object
Replace Conditional with Polymorphism
Replace Magic number with Symbolic constant
Extract method: Para la parte de ChronoUnit.DAYS. ...
Move method