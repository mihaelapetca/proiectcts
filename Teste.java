package testare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAngajat.class, TestBrutarie.class, TestComanda.class,
		TestCuptor.class, TestProdusPanificatie.class })
public class Teste {

}
