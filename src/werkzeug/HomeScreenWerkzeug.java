package werkzeug;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Service.HomeScreenService;
import fachwerte.KanalVerlauf;
import materialien.Kanal;

public class HomeScreenWerkzeug
{
    private HomeScreenUI _homeScreenUI;
    private HomeScreenService _homeSreenService;
    
    /**
     * Konstruktor
     * @param homeSreenService Die Service von HomeSreen
     */
    public HomeScreenWerkzeug(HomeScreenService homeSreenService)
    {
        _homeScreenUI = new HomeScreenUI();
        _homeSreenService = homeSreenService;
        showUI();
        addKanälenZuJList();
        
        //Zeigt AktuelleInhalt von dem ersten Kanal auf dem Bildschirm
        showAktuelleInhalt(_homeSreenService.get_kanalListe().get(0));
        
        registriereUIAktionen();
    }

    /**
     * Zeigt das Homescreen Fenster
     */
    private void showUI()
    {
        _homeScreenUI.setVisible(true);
    }
    
    /**
     * Fügt die Datei von der Kanälenliste zu JList hinzu
     */
    private void addKanälenZuJList()
    {
        List<Kanal> kanalListe = getKanalListe();
        
        JList<Kanal> kanalJList = _homeScreenUI.get_kanalListe();
        DefaultListModel<Kanal> model = (DefaultListModel<Kanal>) kanalJList.getModel();
        int zähler = 0;
        for (Kanal kanal : kanalListe )
        {
            model.add(zähler, kanal);
            zähler++;
        }
    }
    
    /**
     * Zeige Mediadatei auf den Bildschirm
     * @param aktuelleKanal: Der Kanal, den in der Liste gewählt wird
     */
    private void showAktuelleInhalt(Kanal aktuelleKanal)
    {
    			//Resize das Bild
    			int hoehe = _homeScreenUI.get_hoeheVon_aktuelleInhalt();
    			int breite = _homeScreenUI.get_breiteVon_aktuelleInhalt();
    			String medienDateiLink = aktuelleKanal.get_mediaDateiLink();
    			ImageIcon imageIcon = new ImageIcon(medienDateiLink); // Photo Datei -> ImageIcon -> Image, damit man Resize machen kann
    			Image image = imageIcon.getImage();
    			Image newimg = image.getScaledInstance(breite, hoehe,  java.awt.Image.SCALE_SMOOTH); 	// scale it the smooth way  
    			imageIcon = new ImageIcon(newimg);  // Image -> ImageIcon damit man in JLabel hinzufügen kann
    			
    			JLabel label = new JLabel(imageIcon);
    			if(_homeScreenUI.get_bildSchirmJPanel().getComponentCount() != 0)
    			{
    				_homeScreenUI.get_bildSchirmJPanel().remove(0);
    			}
    			_homeScreenUI.get_bildSchirmJPanel().add(label);
    			_homeScreenUI.get_bildSchirmJPanel().revalidate();
    }
    
    /**
     * Registriere die Listener für die UI
     */
    private void registriereUIAktionen()
    {
    	registriereKanalJListeAktion();
    	registriereBackButtonAktion();
    	registriereNextButtonAktion();
    	
    }
    
    /**
     * Registriert die Listener für die BackButton
     */
    private void registriereBackButtonAktion() {
		JButton backbutton = _homeScreenUI.get_backButton();
		backbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reagiereAufDenBackButton();
				_homeScreenUI.get_nextButton().setEnabled(true);
			}
		});
		
	}
    
    /**
     * Registriert die Listener für die NextButton
     */
    private void registriereNextButtonAktion() {
		JButton backbutton = _homeScreenUI.get_nextButton();
		backbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reagiereAufDenNextButton();
				
			}
		});
		
	}
    
    /**
     * Zeigt den letzten Kanal, wenn der BackButton gedrückt wird
     */
    private void reagiereAufDenBackButton()
    {
    	Kanal letzterKanal = _homeSreenService.get_kanalVerlauf().gibLetzteKanal();
    	JList<Kanal> list = _homeScreenUI.get_kanalListe();
    	list.setSelectedValue(letzterKanal, true);
    	showAktuelleInhalt(letzterKanal);
    }
    
    /**
     * Zeigt den nächsten Kanal, wenn der Nextbutton gedrückt wird
     */
    private void reagiereAufDenNextButton()
    {
    	Kanal naechsteKanal = _homeSreenService.get_kanalVerlauf().gibNaechsteKanal();
    	JList<Kanal> list = _homeScreenUI.get_kanalListe();
    	list.setSelectedValue(naechsteKanal, true);
    	showAktuelleInhalt(naechsteKanal);
    }

	/**
     * Registriert die Listener für die KanalJList
     */
    private void registriereKanalJListeAktion() 
    {
    	JList<Kanal> list = _homeScreenUI.get_kanalListe();
    	list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//if Value changed to ANOTHER Value (not the same)
				if (list.getValueIsAdjusting())
				{
					reagiereAufDieKanalListe();
					
					_homeScreenUI.get_backButton().setEnabled(true);
				}
			}
		});
    }
    
    /**
     * Zeigt das neue Inhalt von dem ausgewählten Kanal
     */
    private void reagiereAufDieKanalListe()
    {
    	showAktuelleInhalt(getAktuelleKanal());
    	
    	//den neuen Kanal wird in den Verlauf hinzufügen
    	KanalVerlauf verlauf = _homeSreenService.get_kanalVerlauf();
    	verlauf.einenKanalWirdGewaehlt(getAktuelleKanal());
    	
    	//Test in ra noi dung Verlauf
    	System.out.println("============Verlauf============");
    	Kanal[] array =verlauf.get_kanalVerlaufArray();
    	for (int i = 0; i< 10; i++)
    	{
    		if (array[i] != null)System.out.println("Kanal " +i +"ist " + array[i]);
    	}
    }

    /**
     * Gibt die ausgewählte Kanal
     * @return
     */
	private Kanal getAktuelleKanal()
	{
		JList<Kanal> list = _homeScreenUI.get_kanalListe();
		Kanal kanalTest = list.getSelectedValue();
		return kanalTest;
	}

	/**
	 * Gibt die Liste von allen Kanälen zurück
	 * @return Liste von Kanälen
	 */
	private List<Kanal> getKanalListe()
	{
	    return _homeSreenService.get_kanalListe();
	}
    
}
