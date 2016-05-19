package testare;

import static org.junit.Assert.*;

import org.junit.Test;

import pack.Brutar;
import pack.ComandaClient;
import pack.Produse;

public class TestComanda {	

	@Test
	public void testSumaTotala() {
		ComandaClient comanda = new ComandaClient(new Brutar("bru003", "Marin", "Sorin", 2800));
		comanda.adaugaProdus(Produse.CHIFLA, 10);
		comanda.adaugaProdus(Produse.PAINE_GRAHAM, 5);
		assertEquals(41.5, comanda.calculTotalComada(0.05, 0.05), 0.0);
	}

}
