package mcb.persistenz.filter;

import mcb.model.Adresse;
import mcb.panel.McbAction;

public class AuslandFilter implements AdresseFilter {

	public int getKeyMask() {
		return McbAction.AUSLAND;
	}

	public String getLabel() {
		return "Nur Ausl�ndische";
	}

	public boolean matches(Adresse adresse) {
		return !adresse.getLand().equals("D");
	}

}
