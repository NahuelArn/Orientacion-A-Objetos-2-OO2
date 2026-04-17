/** 
* Retorna los últimos N posts que no pertenecen al usuario user 
*/ 
public List<Post> ultimosPosts(Usuario user, int cantidad) { 
         
    List<Post> postsOtrosUsuarios = new ArrayList<Post>(); 
    for (Post post : this.posts) { 
        if (!post.getUsuario().equals(user)) { 
            postsOtrosUsuarios.add(post); 
        } 
    } 
         
   // ordena los posts por fecha 
   for (int i = 0; i < postsOtrosUsuarios.size(); i++) { 
       int masNuevo = i; 
       for(int j= i +1; j < postsOtrosUsuarios.size(); j++) { 
           if (postsOtrosUsuarios.get(j).getFecha().isAfter( 
     postsOtrosUsuarios.get(masNuevo).getFecha())) { 
              masNuevo = j; 
           }     
       } 
      Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo)); 
      postsOtrosUsuarios.set(masNuevo, unPost);     
   } 
         
    List<Post> ultimosPosts = new ArrayList<Post>(); 
    int index = 0; 
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator(); 
    while (postIterator.hasNext() &&  index < cantidad) { 
        ultimosPosts.add(postIterator.next()); 
    } 
    return ultimosPosts; 
}

Small -> 
Imperative Loops -> uso de fors tradicionales para procesar colecciones en lugar de usar la api de 
de Streams, generendo codigo mas extenso y poco autoexplicativo...

Refactor -> 
Replace Loop With Pipeline: se genera codigo mas limpio, reduce la cantidad de lineas de codigo significativamente


public List<Post> ultimoPost(Usuario user, int cantidad){

    return post.stream()
                .filter(p -> !p.getUser().equals(user)) //filtra a los post que no sean de X usuario
                .sorted(Comparator.comparing(Persona::getFecha() //ordena por fecha
                .reversed()) //retorna los ultimos N post
                .limit(cantidad) //limitar la cantidad  a retornar en la lista
                .toList(); //convertir a lista
}
