package mcb.model;

import java.util.Arrays;
import java.util.List;

public class Fehlergruende {

	public static List<String> alleGruende() {
		String[] fehlergruende = { "", //
				"Empf�nger existiert nicht", //
				"Mailbox voll", //
				"Email aus Spamgr�nden nicht akzeptiert" //
		};
		return Arrays.asList(fehlergruende);
	}
}
