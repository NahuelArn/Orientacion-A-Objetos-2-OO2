
abstract class Etiqueta { 
    protected String nombreProducto; 
    protected double precio; 
 
    public Etiqueta(String nombre, double precio) { 
        this.nombreProducto = nombre; 
        this.precio = precio; 
    } 
} 
 
class EtiquetaSimple extends Etiqueta { 
    public EtiquetaSimple(String nombre, double precio) { 
        super(nombre, precio); 
    } 
 
    public void generar() { 
        System.out.println("--- ETIQUETA BÁSICA ---"); 
        System.out.println("Producto: " + nombreProducto); 
        System.out.println("Precio: $" + precio); 
        System.out.println("-----------------------"); 
    } 
} 
 
class EtiquetaDetalle extends Etiqueta { 
    public EtiquetaDetalle(String nombre, double precio) { 
        super(nombre, precio); 
    } 
 
    public void generar() { 
        System.out.println("--- ETIQUETA DETALLE ---"); 
        System.out.println("Producto: " + nombreProducto); 
        System.out.println("Precio sin imp.: $" + (precio * 0.79)); 
        System.out.println("Precio final: $" + precio); 
        System.out.println("-----------------------"); 
    } 
}

Tareas: 
1.  ¿Hay código duplicado? Indique claramente en qué líneas se encuentra. 
2.  Se quiere aplicar el refactoring Pull Up Method para subir el método generar() a la 
superclase Etiqueta. ¿Es posible hacerlo en el código anterior? Justifique su 
respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el 
libro de Refactoring de Martin Fowler. 
3.  Mencione los refactorings previos necesarios para que sea posible aplicar Pull Up 
Method. 
4.  Aplique Pull Up Method para subir el método generar() a la superclase Etiqueta.

1:Si hay codigo duplicado en la parte del sysout... Producto + nombreProducto y en (PrecioFinal/Precio ... --> esto no va Precio != Precio Final)
Esas 2 cosas se hacen de la misma forma para ambos casos
2:si es posible usando polimorfismo
3: hay que hacer un Extract method y Form Templeate Method... 
4: si.
abstract class Etiqueta { 
    protected String nombreProducto; 
    protected double precio; 
 
    public Etiqueta(String nombre, double precio) { 
        this.nombreProducto = nombre; 
        this.precio = precio; 
    } 
    protected void nombre(){
     System.out.println( "Producto: "+ this.nombreProducto);
    }
    protected void separador(){
     System.out.println( "-----------------------");
    }

    protected abstract void imprimirInformacionEspecifica();
    protected abstract void cabecera();

    public void generar(){
        this.cabecera();    
        this.nombre();
        this.imprimirInformacionEspecifica(); //precio
        this.separador();
    }
}   
 
class EtiquetaSimple extends Etiqueta { 
    public EtiquetaSimple(String nombre, double precio) { 
        super(nombre, precio); 
    } 
    private void cabecera(){
       System.out.println("--- ETIQUETA BÁSICA ---");
    }
    private void imprimirInformacionEspecifica(){
      System.out.println("Precio: $" + this.precio); 
    }

} 
 
class EtiquetaDetalle extends Etiqueta { 
    protected static final double impuesto = 0.79;
    public EtiquetaDetalle(String nombre, double precio) { 
        super(nombre, precio); 
    } 

    private void cabecera(){
       System.out.println("--- ETIQUETA DETALLE ---");
    }
    private void imprimirInformacionEspecifica(){
      System.out.println("Precio sin imp.: $" + (this.precio * this.impuesto)); 
      System.out.println("Precio final: $" + this.precio); 
    }


}

smalls -> Magic numbers, Duplicate code,