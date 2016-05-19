package testare;

import static org.junit.Assert.*;

import org.junit.Test;

import pack.Angajat;
import pack.Brutar;
import pack.ComandaClient;
import pack.Manager;
import pack.Vanzator;

public class TestAngajat {

	@Test
	public void testSalariuNet() {
		Angajat a = new Manager("man001", "Popa", "Marius", 3400);
		assertEquals(2439.0, a.getSalariuNet(), 0.0);
	}
	
	@Test
	public void testSalariuNegativ(){
		Angajat a = new Manager("man001", "Popa", "Marius", -2000);
		assertEquals(0, a.getSalariuNet(), 0.0);
	}

	@Test
	public void testVanzatorPrimesteComanda(){
		Vanzator v = new Vanzator("van001", "Andreescu", "Stefania", 2500);
		Brutar b = new Brutar("bru001", "Marinescu", "Ana", 2800);
		assertTrue(v.primesteComanda(new ComandaClient(b)));
		assertTrue(v.primesteComanda(new ComandaClient(b)));
		assertEquals(2, v.getComenzi().size());
	}
	
	@Test
	public void testComandaNula(){
		Vanzator v = new Vanzator("van001", "Andreescu", "Stefania", 2500);
		Brutar b = new Brutar("bru001", "Marinescu", "Ana", 2800);
		assertFalse(v.primesteComanda(null));
	}
}
