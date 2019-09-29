package materialien;

public class Kanal
{
    private int _kanalID;
    private String _verkürzung;
    private String _name;
    private String _sprache;
    private String _zone;
    private String _mediaDateiLink;
    
    private static int anzahlKanal;
    
    /**
     * Konstruktor
     * @param verkürzung: Verkürzung des Kanals
     * @param name: Der vollstängiger Name des Kanals
     * @param sprache: Die Sprache, die von dem Kanal präsentiert werden
     * @param zone: in welchen Ländern kann den Kanals gefangt werden
     * @param mediaDateiLink: der Link zu Medien Datei
     */
    public Kanal(String verkürzung, String name, String sprache, String zone, String mediaDateiLink)
    {
        _kanalID = anzahlKanal++;
        _verkürzung = verkürzung;
        _name = name;
        _sprache = sprache;
        _zone = zone;
        _mediaDateiLink = mediaDateiLink;
    }

    /**
     * 
     * @return String: welcher Kanal, in welchem Land und welcher Sprache präsentiert
     */
    public String getFormartierteString()
    {
        return _name + " wird in " +_zone+ " auf " +_sprache+ " präsentiert";
    }
    
    /**
     * @return String: Verkürzung und voll. Name des Kanals
     */
    public String toString()
    {
        return _verkürzung + " - " + _name  ;
    }

    /**
     * Gibt den Link von Medien Datei des Kanals zurück
     * @return Link von dem Media Datei
     */
	public String get_mediaDateiLink() {
		return _mediaDateiLink;
	}

	/**
	 * Gibt Verkürzung zurück
	 * @return die Verkurzung des Kanals
	 */
	public String get_verkürzung() {
		return _verkürzung;
	}
    

}
