package test;

import junit.framework.TestCase;
import linguistic.types_gestion.*;

public class TypeTest extends TestCase{
	
	public void testType() {
		String nameType1 = "ReussirMatch";
		TypeImpl surType1 = new TypeImpl("Reussir");
		
		TypeImpl type1 = new TypeImpl(nameType1, surType1);
		
		assertEquals(nameType1, type1.getName());
		assertEquals(nameType1, type1.toString());
		assertEquals(surType1, type1.getSurtype());					
	}
}
