package mcb.persistenz.filter;

import mcb.panel.McbAction;
import mcb.persistenz.Adresse;

public class DeutschlandFilter implements AdresseFilter {

	public int getKeyMask() {
		return McbAction.DEUTSCHLAND;
	}

	public String getLabel() {
		return "Nur Deutsche";
	}

	public boolean matches(Adresse adresse) {
		return adresse.getLand().equals("D");
	}

}
