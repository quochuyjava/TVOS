package materialien;

public class Kanal
{
    private int _kanalID;
    private String _verkürzung;
    private String _name;
    private String _sprache;
    private String _zone;
    
    private static int anzahlKanal;
    
    public Kanal(String verkürzung, String name, String sprache, String zone)
    {
        _kanalID = anzahlKanal++;
        _verkürzung = verkürzung;
        _name = name;
        _sprache = sprache;
        _zone = zone;
    }

    public String getFormartierteString()
    {
        return _name + " wird in " +_zone+ " auf " +_sprache+ " präsentiert";
    }
    

}
