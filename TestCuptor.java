package testare;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pack.Cuptor;

public class TestCuptor {
	private Cuptor cuptor;
	
	@Before
	public void setUp(){
		cuptor = new Cuptor();
	}

	@Test
	public void testOcupaCuptor() {
		assertTrue(cuptor.ocupaCuptor(20));
		assertFalse(cuptor.ocupaCuptor(10));
	}

	@Test
	public void testScoateProdus(){
		cuptor.scoateProdus();
		assertFalse(cuptor.isCuptorOcupat());
	}
	
	@Test
	public void testTemperaturaCuptor(){
		assertEquals("Temperatura nepotrivita", cuptor.preincalzireCuptor(-30));
		assertEquals("Temperatura nepotrivita", cuptor.preincalzireCuptor(230));
		assertEquals("Cuptor preincalzit la 180 de grade", cuptor.preincalzireCuptor(180));
	}
	
	@Test
	public void testTimpCoacere(){
		assertFalse(cuptor.ocupaCuptor(-20));
		assertTrue(cuptor.ocupaCuptor(20));
		assertFalse(cuptor.ocupaCuptor(-50));
	}
}
