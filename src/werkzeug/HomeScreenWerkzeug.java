package werkzeug;

import java.awt.Image;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Service.HomeScreenService;
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
    			//_homeScreenUI.get_aktuelleInhalt().repaint();
    }
    
    /**
     * Registriere die Listener für die UI
     */
    private void registriereUIAktionen()
    {
    	registriereKanalJListeAktion();
    	
    }
    
    /**
     * Registriere die Listener für die KanalJList
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
