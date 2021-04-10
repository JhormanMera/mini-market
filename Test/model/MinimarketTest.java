package model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import exception.AgeException;
import exception.DayException;


public class MinimarketTest {
	private Minimarket m;
	
	public void setupScenary1() {
		m = new Minimarket();		
	}	
	public void setupScenary2() throws AgeException, DayException, ParseException {
		m = new Minimarket();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		Date pDate1 =d.parse("13-10-2020");
		Date pDate2 =d.parse("02-03-2021");
		Date pDate3 =d.parse("06-01-2021");
		m.addPerson(pDate1, "CC",16896987);
		m.addPerson(pDate2, "CE",10101599);
		m.addPerson(pDate3, "PP",10347395);		
	}
	@Test
	public void testAddPerson1() throws AgeException, DayException, ParseException {
		setupScenary2();
		String type="CE";
		int id =1113519385;
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		Date pDate =d.parse("13-02-2020");
		boolean added=m.addPerson(pDate, type, id);
		assertTrue(added);
		assertNotNull(m.getPeople());
		assertEquals(type, m.getPeople().get(m.getPeople().size()-1).getIdType().toString());
		assertEquals(id, m.getPeople().get(m.getPeople().size()-1).getId());
		assertTrue(m.getPeople().size()==4);
		assertEquals(0,m.getAttempsNum());
	}
	@Test
	public void testAddPerson2() throws ParseException {
		setupScenary1();
		String type="TI";
		int id =51646773;
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		Date pDate =d.parse("01-03-2021");
		try {
			m.addPerson(pDate, type, id);
			fail("No deberia añadir el registro, tiene que fallar por documento de identidad");
		} catch (AgeException e) {
			assertTrue(m.getPeople().isEmpty());
			assertEquals(1,m.getAttempsNum());
		} catch (DayException e) {
			fail("Deberia fallar por documento de identidad, no por dia del mes");
		}				
	}

	@Test
	public void testAddPerson3() throws ParseException {
		setupScenary1();
		String type="CC";
		int id =998456956;
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		Date pDate =d.parse("01-03-2021");
		try {
			m.addPerson(pDate, type, id);
			fail("No deberia añadir el registro, tiene que fallar por fecha");
		} catch (AgeException e) {
			fail("Deberia fallar por día del mes, no por documento de identidad");			
		} catch (DayException e) {
			assertTrue(m.getPeople().isEmpty());
			assertEquals(1,m.getAttempsNum());
		}	
	}
}
