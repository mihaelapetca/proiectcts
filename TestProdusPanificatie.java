package testare;

import static org.junit.Assert.*;

import org.junit.Test;

import pack.Brutarie;
import pack.Chifla;
import pack.ChiflaMac;
import pack.ChiflaSusan;
import pack.ProdusPanificatie;
import pack.Produse;

public class TestProdusPanificatie {

	@Test
	public void testCalculTvaGresit(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		assertEquals(0, produs.calculTVA(-0.3), 0.0);
		assertEquals(0, produs.calculTVA(1.5), 0.0);
	}

	@Test
	public void testCalculTva(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		assertEquals(0.23, produs.calculTVA(0.1), 0.01);
		assertEquals(1.15, produs.calculTVA(0.5), 0.01);
	}
	
	@Test
	public void testCalculTvaCrossCheck(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		assertEquals(0.05 * produs.getPret(), produs.calculTVA(0.05), 0.01);
	}
	
	@Test
	public void testCalculTvaInverse(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		double pret = produs.getPret();
		double procentTva = 0.05;
		double tva = produs.calculTVA(procentTva);
		assertEquals(procentTva, tva/pret, 0.01);
	}
	
	@Test
	public void testVerificarePretCalculTva(){
		ProdusPanificatie produs = new Chifla("Chifla", -2.3, 125, 20, 200, 100, 50, 20, 10, 5);
		assertEquals(0, produs.calculTVA(0.1), 0.0);
		assertEquals(0, produs.calculTVA(0.5), 0.0);
	}
	
	@Test
	public void testCalculDiscount(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		assertEquals(1.15, produs.calculDiscount(5, 0.1), 0.01);
		assertEquals(4.6, produs.calculDiscount(10, 0.2), 0.01);
	}
	
	@Test
	public void testCalculDiscountCrossCheck(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		int numarProduse = 10;
		double discount = 0.2;
		double pret = produs.getPret();
		assertEquals(numarProduse * discount * pret, produs.calculDiscount(numarProduse, discount), 0.01);
	}
	
	@Test
	public void testCalculDiscountInverse(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		int numarProduse = 10;
		double discount = 0.2;
		double pret = produs.getPret();
		assertEquals(pret, (produs.calculDiscount(numarProduse, discount)/numarProduse) / discount, 0.01);
	}
	
	@Test
	public void testVerficareNumarProduse(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		assertEquals(0, produs.calculDiscount(0, 0.1), 0.0);
		assertEquals(0, produs.calculDiscount(-6, 0.1), 0.0);
		assertEquals(0, produs.calculDiscount(4, 0.1), 0.0);
	}
	
	@Test
	public void testDiscountGresit(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		assertEquals(0, produs.calculDiscount(6, 0.0), 0.0);
		assertEquals(0, produs.calculDiscount(6, -0.5), 0.0);
		assertEquals(0, produs.calculDiscount(6, 2), 0.0);
	}
	
	@Test
	public void testVerificarePretCalculDiscount(){
		ProdusPanificatie produs = new Chifla("Chifla", -2.3, 125, 20, 200, 100, 50, 20, 10, 5);
		assertEquals(0, produs.calculDiscount(10, 0.1), 0.0);
		assertEquals(0, produs.calculDiscount(5, 0.3), 0.0);
	}
	
	@Test
	public void testPreparare(){
		ProdusPanificatie produs = new Chifla("Chifla", 2.3, 125, 20, 200, -100, -50, -20, -10, -5);
		assertFalse(produs.preparare(Produse.CHIFLA));
		ProdusPanificatie produs1 = new Chifla("Chifla", 2.3, 125, 20, 200, 100, 50, 20, 10, 5);
		assertTrue(produs1.preparare(Produse.CHIFLA));
	}
	
	@Test
	public void testPretChiflaMac(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		ChiflaMac chiflaMac = new ChiflaMac(produs, 2.4);
		assertEquals(4.7, chiflaMac.calculPret(), 0.01);
	}
	
	@Test
	public void testPretChiflaMacInverse(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		double pretProdus = produs.getPret();
		double pretMac = 2.4;
		ChiflaMac chiflaMac = new ChiflaMac(produs, pretMac);
		double pretChiflaMac = chiflaMac.calculPret();
		assertEquals(pretMac, pretChiflaMac - pretProdus, 0.01);
	}
	
	@Test
	public void testPretChiflaMacCrossCheck(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		double pretProdus = produs.getPret();
		double pretMac = 2.4;
		ChiflaMac chiflaMac = new ChiflaMac(produs, pretMac);
		double pretChiflaMac = chiflaMac.calculPret();
		assertEquals(pretProdus + pretMac, pretChiflaMac, 0.01);
	}
	
	@Test
	public void testPretChiflaSusan(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		ChiflaSusan chiflaSusan = new ChiflaSusan(produs, 1.7);
		assertEquals(4, chiflaSusan.calculPret(), 0.01);
	}
	
	@Test
	public void testPretChiflaSusanInverse(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		double pretProdus = produs.getPret();
		double pretSusan = 1.7;
		ChiflaSusan chiflaSusan = new ChiflaSusan(produs, pretSusan);
		double pretChiflaSusan = chiflaSusan.calculPret();
		assertEquals(pretSusan, pretChiflaSusan - pretProdus, 0.01);
	}
	
	@Test
	public void testPretChiflaSusanCrossCheck(){
		ProdusPanificatie produs = Brutarie.getInstance().getProdus(Produse.CHIFLA);
		double pretProdus = produs.getPret();
		double pretSusan = 1.7;
		ChiflaSusan chiflaSusan = new ChiflaSusan(produs, pretSusan);
		double pretChiflaSusan = chiflaSusan.calculPret();
		assertEquals(pretProdus + pretSusan, pretChiflaSusan, 0.01);
	}
}
