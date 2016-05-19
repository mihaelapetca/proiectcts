package testare;

import static org.junit.Assert.*;

import org.junit.Test;

import pack.Brutarie;
import pack.Produse;

public class TestBrutarie {

	@Test
	public void testInstantaBrutarie() {
		Brutarie br1 = Brutarie.getInstance();
		Brutarie br2 = Brutarie.getInstance();
		assertSame(br1, br2);
	}
	
	@Test
	public void testGetProdus(){
		Brutarie brutarie = Brutarie.getInstance();
		assertNotNull(brutarie.getProdus(Produse.BAGHETA));
		assertNull(brutarie.getProdus(Produse.PAINE));
		assertNotNull(brutarie.getProdus(Produse.CHIFLA));
	}

}
