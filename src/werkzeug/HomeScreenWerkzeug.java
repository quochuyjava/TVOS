package werkzeug;

import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
//        zeigeAktuelleInhalt();
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
    
//  private void zeigeAktuelleInhalt()
//  {
//  	JPanel aktuelleFrame = _homeScreenUI.get_aktuelleInhalt();
//  	
//  	File file = new File("Users/quochuy/Downloads/maxresdefault.jpg");
//  	ImageIcon imageIcon = new ImageIcon(file.getName());
//  	JLabel label = new JLabel(imageIcon);
//  	
//  	aktuelleFrame.add(label);
//  	System.out.println("da show hinh");
//  	
//  	_homeScreenUI.set_aktuelleInhalt(aktuelleFrame);
//  	
//  }
}
