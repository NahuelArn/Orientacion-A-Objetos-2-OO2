
//Clase 1
public class CharRing { 
    private char[] source; 
    private int idx; 
 
    public CharRing(String src) { 
        source = src.toCharArray(); 
        idx = 0; 
    } 
 
    public char next() { 
        if (idx >= source.length) 
            idx = 0; 
        return source[idx++];
        } 
}

public class CharRingTest {
	private CharRing ring;

    @BeforeEach
    void setUp() {
        ring = new CharRing("ABC");
    }

    @Test
    void testNextReturnsPrimerCaracter() {
        assertEquals('A', ring.next());
    }

    @Test
    void testNextRecorreCaracteresEnOrden() {
        assertEquals('A', ring.next());
        assertEquals('B', ring.next());
        assertEquals('C', ring.next());
    }

    @Test
    void testNextVuelveAlInicioAlLlegarAlFinal() {
        ring.next(); // A
        ring.next(); // B
        ring.next(); // C
        assertEquals('A', ring.next()); // vuelve al inicio
    }

    @Test
    void testNextCiclaVariasVeces() {
        for (int i = 0; i < 6; i++) ring.next();
        assertEquals('A', ring.next()); // 7ma llamada → índice 0
    }

    @Test
    void testConUnSoloCaracterSiempreRetornaElMismo() {
        CharRing single = new CharRing("Z");
        assertEquals('Z', single.next());
        assertEquals('Z', single.next());
        assertEquals('Z', single.next());
    }

    @Test
    void testConDosCaracteresAlterna() {
        CharRing pair = new CharRing("XY");
        assertEquals('X', pair.next());
        assertEquals('Y', pair.next());
        assertEquals('X', pair.next());
        assertEquals('Y', pair.next());
    }

    @Test
    void testConStringConEspacios() {
        CharRing spaced = new CharRing("A B");
        assertEquals('A', spaced.next());
        assertEquals(' ', spaced.next());
        assertEquals('B', spaced.next());
        assertEquals('A', spaced.next());
    }
}



//Clase 2
public class IntRing {
	  private int[] source; 
    private int idx; 
 
    public IntRing(int[] src) { 
        source = src; 
        idx = 0; 
    } 
 
    public int next() { 
        if (idx >= source.length) {
            idx = 0; 
        }
        return source[idx++]; 
    } 
}


public class IntRingTest {
	int[] v1;
	IntRing intRing;
	private IntRing ring;
	@BeforeEach
	void setUp() throws Exception {
		v1 = new int[10];
		for(int i=0; i < 10;i++) {
			v1[i] = i;
		}
		intRing = new IntRing(v1);
		
		ring = new IntRing(new int[]{1, 2, 3});
	}
	
	@Test
    public void prueba() {
		assertEquals(0, intRing.next());
	}
	 @Test
	    void testNextRecorreElementosEnOrden() {
	        assertEquals(1, ring.next());
	        assertEquals(2, ring.next());
	        assertEquals(3, ring.next());
	    }

	    @Test
	    void testNextVuelveAlInicioAlLlegarAlFinal() {
	        ring.next(); // 1
	        ring.next(); // 2
	        ring.next(); // 3
	        assertEquals(1, ring.next());
	    }

	    @Test
	    void testNextCiclaVariasVeces() {
	        for (int i = 0; i < 6; i++) ring.next();
	        assertEquals(1, ring.next());
	    }

	    @Test
	    void testConUnSoloElementoSiempreRetornaElMismo() {
	        IntRing single = new IntRing(new int[]{42});
	        assertEquals(42, single.next());
	        assertEquals(42, single.next());
	        assertEquals(42, single.next());
	    }

	    @Test
	    void testConDosElementosAlterna() {
	        IntRing pair = new IntRing(new int[]{10, 20});
	        assertEquals(10, pair.next());
	        assertEquals(20, pair.next());
	        assertEquals(10, pair.next());
	        assertEquals(20, pair.next());
	    }
}

Tareas:  
1)  Diseñe e implemente Test de Unidad para las clases CharRing e IntRing. Asegúrese 
de que los test pasen. 
2)  Aplique el refactoring Extract Superclass. Detalle cada uno de los pasos 
intermedios que son necesarios para poder aplicar correctamente este refactoring. 
3)  Verifique que los tests definidos en el paso 1 sigan funcionando correctamente. 
4)  Realice un diagrama de clases UML con el diseño refactorizado.