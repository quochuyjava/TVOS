package Service;

import java.util.List;

import fachwerte.KanalVerlauf;
import materialien.Kanal;

public class HomeScreenService
{
    private List<Kanal> _kanalListe;
    private KanalVerlauf _kanalVerlauf;
    
    
    /**
     * Konstruktor
     * @param list: Die Liste von Kanal
     */
    public HomeScreenService(List<Kanal> list)
    {
        _kanalListe = list;
        _kanalVerlauf = new KanalVerlauf();
    }

    /**
     * Gibt die Liste der Kanälen zurück
     * @return Liste der Kanälen
     */
    public List<Kanal> get_kanalListe()
    {
        return _kanalListe;
    }

    /**
     * Gibt den letzten Kanal zurückt
     * @return Kanal: der letzten Kanal
     */
	public Kanal geheZuLetztemKanal() {
		return _kanalVerlauf.gibLetzteKanal();
	}
	
	 /**
     * Gibt den nächsten Kanal zurückt
     * @return Kanal: der nächste Kanal
     */
	public Kanal geheZuNaechstemKanal() {
		return _kanalVerlauf.gibNaechsteKanal();
	}
	
	 /**
     * Einen neunen Kanal wird gewählt, dann wird den Verlauf verändert
     */
	public void fuegeZumVerlaufHinzu(Kanal kanal) {
		_kanalVerlauf.einenKanalWirdGewaehlt(kanal);
	}

	/**
	 * Gibt Kanalverlauf zurück
	 * @return Kanal Verlauf
	 */
	public KanalVerlauf get_kanalVerlauf() {
		return _kanalVerlauf;
	}

}
