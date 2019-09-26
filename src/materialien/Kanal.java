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
    
    public Kanal(String verkürzung, String name, String sprache, String zone, String mediaDateiLink)
    {
        _kanalID = anzahlKanal++;
        _verkürzung = verkürzung;
        _name = name;
        _sprache = sprache;
        _zone = zone;
        _mediaDateiLink = mediaDateiLink;
    }

    public String getFormartierteString()
    {
        return _name + " wird in " +_zone+ " auf " +_sprache+ " präsentiert";
    }
    
    public String toString()
    {
        return _verkürzung + " - " + _name  ;
    }

	public String get_mediaDateiLink() {
		return _mediaDateiLink;
	}
    

}
