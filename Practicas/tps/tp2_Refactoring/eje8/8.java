Ejercicio 8 - Documentos y estadísticas 



Dado el siguiente código implementado en la clase Document y que calcula algunas 
estadísticas del mismo: 
 
public class Document { 
    List<String> words; 
   
    public long characterCount() { 
      return = this.words.stream() 
                .mapToLong(w -> w.length()) 
                .sum(); 
    
  } 
    public long calculateAvg() { 
      return this.characterCount() / this.words.size(); 

  } 
// Resto del código que no importa 
} 
 
 
Tareas: 
1.  Enumere los code smell y que refactorings utilizará para solucionarlos. 
2.  Aplique los refactorings encontrados, mostrando el código refactorizado luego de 
aplicar cada uno. 
3.  Analice el código original y detecte si existe un problema al calcular las estadísticas. 
Explique cuál es el error y en qué casos se da ¿El error identificado sigue presente 
luego de realizar los refactorings? En caso de que no esté presente, ¿en qué 
momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto 
un refactoring?
Bad smells
Duplicate code:
this.words.stream().mapToLong(w -> w.length()).sum()
Long method: se usa una variable en vez de retornar el valor directamente
Refactoring
Extract method
Inline temp

4
"No corresponde considerar este error en el refactoring ya que el mismo no arregla codigo sino que 
lo "pule", si esa division sobre 0 nos daba error, debe seguir pasando luego del refactoring. 
Es algo que debera arreglarse en algun bug fix, pero no en un refactoring

"