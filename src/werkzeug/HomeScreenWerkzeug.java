package werkzeug;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
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
}
