public class Supermercado { 
   public void notificarPedido(long nroPedido, Cliente cliente) { 
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido 
su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, 
cliente.getDireccionFormateada() }); 
 
     // lo imprimimos en pantalla, podría ser un mail, SMS, etc.. 
    System.out.println(notificacion); 
  } 
} 
 
public class Cliente { 
   public String getDireccionFormateada() { 
    Direccion direccion;
    //contructor
    public String getDireccionFormateada(){
      return this.direccion.datosDireccion();
    }
}
public class Direccion{
  //atributos
  public String datosDireccion() { 
    return  
      this.direccion.getLocalidad() + “, ” + 
      this.direccion.getCalle() + “, ” + 
      this.direccion.getNumero() + “, ” + 
      this.direccion.getDepartamento(); 
    
  }
}

Bad smells
Feature envy: cliente se encarga de formatear la direccion cuando el encargado de eso deberia ser la propia direccion
Comments: Se deben usar comentarios para explicar que hace el choclo de codigo del metodo

Refactoring
Move Method: Pasar el metodo getDireccionFormateada() a la clase direccion
Extract Method: Hacer que la creacion del mensaje se separe de informar el mismo para generar autoexplicacion.