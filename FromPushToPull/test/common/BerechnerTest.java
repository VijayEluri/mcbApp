package common;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Test;

public abstract class BerechnerTest
{
	private static final LocalDate APRIL_ULTIMO = new LocalDate(2010, 4, 30);
	private static final LocalDate MAI_ULTIMO = new LocalDate(2010, 5, 31);
	private final List<Monatsdaten> monatsdaten = new ArrayList<Monatsdaten>();

	protected final List<Umsatz> umsaetze = new ArrayList<Umsatz>();
	protected MonatsdatenBerechner berechner;

	@Test
	public void einUmsatzAmErstenGibtBestandUndDurchschnitt()
	{
		umsaetze.add(new Umsatz(new LocalDate(2010, 4, 1), 100));
		monatsdaten.add(new Monatsdaten(APRIL_ULTIMO));

		berechner.fillData(monatsdaten);

		Monatsdaten aprilData = monatsdaten.get(0);
		assertEquals(100, aprilData.getBestand());
		assertEquals(100, aprilData.getDurchschnittsBestand());
	}

	@Test
	public void zweiUmsaetzeAmErstenUndSechzehntenErgebenHalbenDurchschnittVonBestand()
	{
		umsaetze.add(new Umsatz(new LocalDate(2010, 4, 1), 100));
		umsaetze.add(new Umsatz(new LocalDate(2010, 4, 16), 200));
		monatsdaten.add(new Monatsdaten(APRIL_ULTIMO));

		berechner.fillData(monatsdaten);

		Monatsdaten aprilData = monatsdaten.get(0);
		assertEquals(300, aprilData.getBestand());
		assertEquals(200, aprilData.getDurchschnittsBestand());
	}

	@Test
	public void vormonatsBestandWirdMitberuecksichtigt()
	{
		umsaetze.add(new Umsatz(new LocalDate(2010, 4, 16), 100));
		umsaetze.add(new Umsatz(new LocalDate(2010, 5, 16), 200));
		monatsdaten.add(new Monatsdaten(APRIL_ULTIMO));
		monatsdaten.add(new Monatsdaten(MAI_ULTIMO));

		berechner.fillData(monatsdaten);

		Monatsdaten aprilData = monatsdaten.get(0);
		Monatsdaten maiData = monatsdaten.get(1);
		assertEquals(100, aprilData.getBestand());
		assertEquals(50, aprilData.getDurchschnittsBestand());
		assertEquals(300, maiData.getBestand());
		assertEquals(203, maiData.getDurchschnittsBestand());
	}
}
