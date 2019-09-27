package Service;

import java.util.List;
import materialien.Kanal;

public class HomeScreenService
{
    private List<Kanal> _kanalListe;
    
    /**
     * Konstruktor
     * @param list: Die Liste von Kanal
     */
    public HomeScreenService(List<Kanal> list)
    {
        _kanalListe = list;
    }

    /**
     * Gibt die Liste der Kanälen zurück
     * @return Liste der Kanälen
     */
    public List<Kanal> get_kanalListe()
    {
        return _kanalListe;
    }

}
