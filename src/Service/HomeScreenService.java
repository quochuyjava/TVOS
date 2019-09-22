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
    public HomeScreenService(List list)
    {
        _kanalListe = list;
    }

    public List<Kanal> get_kanalListe()
    {
        return _kanalListe;
    }

}
