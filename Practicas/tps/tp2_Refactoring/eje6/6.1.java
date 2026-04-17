public class EmpleadoTemporario { 
    public String nombre; 
    public String apellido; 
    public double sueldoBasico = 0; 
    public double horasTrabajadas = 0; 
    public int cantidadHijos = 0; 
    // ...... 
     
public double sueldo() { 
  return this.sueldoBasico 
    +  (this.horasTrabajadas * 500)  
    +  (this.cantidadHijos * 1000)  
    -  (this.sueldoBasico * 0.13); 
  } 
} 
 
 
public class EmpleadoPlanta { 
    public String nombre; 
    public String apellido; 
    public double sueldoBasico = 0; 
    public int cantidadHijos = 0; 
    // ...... 
     
    public double sueldo() { 
        return this.sueldoBasico  
          + (this.cantidadHijos * 2000) 
          - (this.sueldoBasico * 0.13); 
    } 
} 
 
public class EmpleadoPasante { 
    public String nombre; 
    public String apellido; 
    public double sueldoBasico = 0; 
    // ...... 
     
    public double sueldo() { 
        return this.sueldoBasico - (this.sueldoBasico * 0.13); 
    } 
}

i) 
- Primero que nada para todas las clases los atributos estan con visibilidad publica,
Deberian estar con visibilidad privada 
- Hacer una Jerarquia... Codigo repetido/atributos

Explicacion mas legible 
"
Bad smells
    Public fields: Las v.i. estan todas publicas, esto rompe el encapsulamiento
    Duplicate Code: nombre, apellido y sueldo basico esta en las 3 clases
    Alternative Classes with Different Interfaces: No se puede aplicar polimorfismo a empleado
    Magic numbers: 0.13, 500, 1000, etc.
Refactoring
    Encapsulate field: Hacer privados las v.i.
    Pull-up Fields: Subir a una superclase las v.i. repetidas
    Pull-up Method: Subir a una superclase los metodos repetidos
    Form template method: Hacer un metodo con la logica general y separar lo especifico
    Replace magic numbers with symbolic constants: Hacer constantes los numeros q no se entiende de donde vienen

"

Codigo implementando

Public class abstract Empleado{
  // Encapsulate Field + Pull-up Fields
  Private String Apellido;
  Private String Nombre;
  Private Double SueldoBasico;

  //replace magic numbers with symbolic constants
  protected static final double PORCENTAJE_DESCUENTO = 0.13;

  public Empleado(String apellido, String nombre, String sueldoBasico){
    this.Apellido = apellido; this.Nombre = nombre; this.sueldoBasico = sueldoBasico;
  }

  public double sueldo(){
    return this.SueldoBasico + this.calcularAdicional() - this.calcularDescuento();
  }
  public abstract double calcularAdicionales();
  
  private double calcularDescuento(){
    return this.sueldoBasico * PORCENTAJE_DESCUENTO;
  }
}

public class EmpleadoTemporario extends Empleado{
  private double horasTrabajadas = 0; 
  private int cantidadHijos = 0;
  
  private static final double VALOR_HORA = 500;
  private static final double ADICIONAL_POR_HIJO = 1000;

  public EmpleadoTemporario(String apellido, String nombre, String sueldoBasico, double hsTrab, int cantHij){
      super(apellido, nombre, sueldoBasico);
      this.horasTrabajadas = hsTrab; this.cantidadHijos.cantHij;
  }
  @Override
  protected double calcularAdicionales(){
    return (this.horasTrabajadas * VALOR_HORA)  + (this.cantidadHijos * ADICIONAL_POR_HIJO) ;
  } 
 
 
  }
public class EmpleadoPlanta extends Empleado{
  private int cantidadHijos = 0;
  //hacer constructor
  private static final double ADICIONAL_POR_HIJO = 2000;
  @Override
  protected double calcularAdicionales(){
    return (this.cantidadHijos * ADICIONAL_POR_HIJO);
  }

  }
  
}
public class EmpleadoPasante{
  //hacer constructor
  @Override
  protected double calcularAdicionales(){return 0;}
  
}
