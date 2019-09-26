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
    
    public HomeScreenWerkzeug(HomeScreenService homeSreenService)
    {
        _homeScreenUI = new HomeScreenUI();
        _homeSreenService = homeSreenService;
        showUI();
        showChanelListe();
        
        registriereKanalListeAktion();
    }

    /**
     * Zeigt das Homescreen Fenster
     */
    private void showUI()
    {
        _homeScreenUI.setVisible(true);
        
    }
    
    private List<Kanal> getKanalListe()
    {
        return _homeSreenService.get_kanalListe();
    }
    
    private void showChanelListe()
    {
        List<Kanal> kanalListe = getKanalListe();
        
        JList<String> kanalJList = _homeScreenUI.get_kanalListe();
        DefaultListModel model = (DefaultListModel) kanalJList.getModel();
        int zähler = 0;
        for (Kanal kanal : kanalListe )
        {
            model.add(zähler, kanal.getFormartierteString());
            zähler++;
        }
        
    }
    
    private void showAktuelleInhalt(Kanal aktuelleKanal)
    {
    			//resize
    			int hoehe = _homeScreenUI.get_hoeheVon_aktuelleInhalt();
    			int breite = _homeScreenUI.get_breiteVon_aktuelleInhalt();
    			String medienDateiLink = aktuelleKanal.get_mediaDateiLink();
    			ImageIcon imageIcon = new ImageIcon(medienDateiLink); // transform it 
    			Image image = imageIcon.getImage();
    			Image newimg = image.getScaledInstance(breite, hoehe,  java.awt.Image.SCALE_SMOOTH); 	// scale it the smooth way  
    			imageIcon = new ImageIcon(newimg);  // transform it back
    			
    			JLabel label = new JLabel(imageIcon);
    			_homeScreenUI.get_aktuelleInhalt().add(label);
    			_homeScreenUI.get_aktuelleInhalt().revalidate();
    			_homeScreenUI.get_aktuelleInhalt().repaint();
    }
    
    private Kanal getAktuelleKanal()
    {
    	JList list = _homeScreenUI.get_kanalListe();
    	DefaultListModel model = (DefaultListModel) list.getModel();
    	int selectedIndex = list.getSelectedIndex();
    	System.out.println(list.getSelectedValue() instanceof Kanal);
    	Object obj = model.get(selectedIndex);
    	Kanal aktuelleKanal = (Kanal) model.get(selectedIndex);
//    	Kanal aktuelleKanal = (Kanal) list.getSelectedValue();
    	return aktuelleKanal;
    }
    
    private void registriereUIAktionen()
    {
    	registriereKanalListeAktion();
    	
    }
    
    private void registriereKanalListeAktion() 
    {
    	JList list = _homeScreenUI.get_kanalListe();
    	list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				reagiereAufDieKanalListe();
			}
		});
    }
    
    private void reagiereAufDieKanalListe()
    {
    	showAktuelleInhalt(getAktuelleKanal());
    }
    
}
