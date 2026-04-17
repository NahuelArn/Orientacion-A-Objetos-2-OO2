 1  public class CharRing extends Object { 
 2      char[] source; 
 3      int idx; 
 4   
 5      public CharRing(String srcString) { 
 6          char result; 
 7          source = new char[srcString.length()]; 
 8          srcString.getChars(0, srcString.length(), source, 0); 
 9          result = 0; 
10          idx = result; 
11      } 
12   
13      public char next() { 
14          int result; 
15          if (idx >= source.length) {
16              idx = 0; }
17          result = idx++; 
18          return source[result]; 
19      } 
20  }

Como quedaria 

 1  public class CharRing extends Object { 
 2      char[] source; 
 3      int idx; 
 4   
 5      public CharRing(String srcString) { 
 6          char result; 
 7          source = new char[srcString.length()]; 
 8          srcString.getChars(0, srcString.length(), source, 0); 
 9          result = 0; 
10          idx = result; 
11      } 
12   
13      public char next() { 
14          int currentPosition; 
15          if (idx >= source.length) {
16              idx = 0; }
17          currentPosition = idx++; 
18          return source[currentPosition]; 
19      } 
20  }

rTAS

2: Al cambiar un nombre de una variable, se tendria que cambiar el nombre a todas las partes dentro del scope
que estaba esa variable..