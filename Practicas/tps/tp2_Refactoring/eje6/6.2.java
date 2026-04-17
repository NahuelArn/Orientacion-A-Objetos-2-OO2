public class Juego { 
    // ...... 
    public void incrementar(Jugador j) { 
        j.puntuacion = j.puntuacion + 100; 
    } 
    public void decrementar(Jugador j) { 
        j.puntuacion = j.puntuacion - 50; 
    } 
 
public class Jugador { 
    public String nombre; 
    public String apellido; 
    public int puntuacion = 0; 
} 
 
} 

i) atributos publicos "Public Fields" rompe el encapsulamiento, cambiar a privados
ii)


public class Juego { 
    // ...... 
    public void incrementar(Jugador j) { 
        j.incrementar();
    } 
    public void decrementar(Jugador j) { 
        j.decrementar();
    } 
 
public class Jugador { 

    protected static final double incremento = 100;
    protected static final double decremento = 50;
    //hacer construcotr
    private String nombre; 
    private String apellido; 
    private int puntuacion = 0;

    public void incrementar() { 
        this.puntuacion += incremento; 
    } 
    public void decrementar(Jugador j) { 
        this.puntuacion -= decremento0; 
    }


} 