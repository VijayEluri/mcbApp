package mcb.frame;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import mcb.frame.actions.EmailAction;
import mcb.frame.actions.ExcelExportAction;
import mcb.frame.actions.OpenTreffenAction;
import mcb.mail.SendCompleteListener;
import mcb.model.Adresse;
import mcb.panel.AdresseMitListePanel;
import mcb.persistenz.ApplicationData;
import mcb.persistenz.filter.AuslandFilter;
import mcb.persistenz.filter.DeutschlandFilter;
import mcb.persistenz.filter.EinladungEmailFilter;
import mcb.persistenz.filter.EinladungPostFilter;
import mcb.persistenz.filter.EmailKaputtFilter;
import mcb.persistenz.filter.GemeldeteFilter;
import mcb.persistenz.filter.KeineEinladungFilter;
import mcb.persistenz.filter.MatchesAlleListener;
import mcb.persistenz.filter.MatchesSucheListener;
import mcb.persistenz.filter.NichtGemeldeteFilter;

public class AdresseFrame extends SimpleFrame<Adresse> implements MatchesAlleListener, MatchesSucheListener, SendCompleteListener {

	private static final long serialVersionUID = -4920258782523646842L;
	private JCheckBoxMenuItem alle;
	private JCheckBoxMenuItem suche;

	public AdresseFrame() {
		super("MCB");
	}

	@Override
	protected void addExtraMenu(JMenuBar bar) {
		bar.add(this.createAdminMenu());
		bar.add(this.createFilterMenu());
	}

	private JMenu createAdminMenu() {
		JMenu admin = new JMenu("Administration");
		admin.add(new ExcelExportAction(this, "Export Auswahl nach Excel"));
		admin.add(new EmailAction(this, "Verschicke Emails..."));
		admin.addSeparator();
		admin.add(new OpenTreffenAction("Treffen bearbeiten..."));
		return admin;
	}

	private JMenu createFilterMenu() {
		JMenu filter = new JMenu("Filter");
		this.alle = this.radioForFilter(ApplicationData.ALLE_FILTER);
		filter.add(this.alle);
		this.suche = this.radioForFilter(ApplicationData.SUCHE_FILTER);
		filter.add(this.suche);
		filter.addSeparator();
		filter.add(this.radioForFilter(new DeutschlandFilter()));
		filter.add(this.radioForFilter(new AuslandFilter()));
		filter.addSeparator();
		filter.add(this.radioForFilter(new EmailKaputtFilter()));
		filter.addSeparator();
		filter.add(this.radioForFilter(new GemeldeteFilter()));
		filter.add(this.radioForFilter(new NichtGemeldeteFilter()));
		filter.addSeparator();
		filter.add(this.radioForFilter(new EinladungEmailFilter()));
		filter.add(this.radioForFilter(new EinladungPostFilter()));
		filter.add(this.radioForFilter(new KeineEinladungFilter()));

		ApplicationData.ALLE_FILTER.setMatchesListener(this);
		ApplicationData.SUCHE_FILTER.setMatchesListener(this);

		this.alle.setSelected(true);
		return filter;
	}

	@Override
	protected AdresseMitListePanel createPanel() {
		return new AdresseMitListePanel();
	}

	public void matchesAllePerformed() {
		this.alle.setSelected(true);
	}

	public void matchesSuchePerformed() {
		this.suche.setSelected(true);
	}

	@Override
	public void messagesSent() {
		JOptionPane.showMessageDialog(this, "Mails wurden gesendet.");
	}

}
