package fachwerte;

import materialien.Kanal;

/**
 * Ein Typ, der speichert den Verlauf von allen Kanälen, die gewählt werden
 * @author quochuy
 *
 */

public class KanalVerlauf {
	final int defaultSize = 10;
	int _size;
	Kanal[] _kanalVerlauf;
	int _aktuelleKanalImVerlauf;	//0 bis size-1
	
	/**
	 * Konstruktor ohne Parameter
	 */
	public KanalVerlauf ()
	{
		_kanalVerlauf = new Kanal[defaultSize];
		_size = defaultSize;
	}
	
	/**
	 * Konstruktor mit size Parameter
	 * @param size : Wie viele gewählte Kanäle, die gespeichert werden dürfen
	 */
	public KanalVerlauf (int size)
	{
		_kanalVerlauf = new Kanal[size];
		_size = size;
	}
	
	/**
	 * Gibt den letzten Kanal zurück
	 * Der nächste Kanal im Array wird zurück gegeben, wenn es schon der letzte ist, dann gibt den aktuellen Kanal Zurück
	 * @return der letzte Kanal
	 */
	public Kanal gibLetzteKanal()
	{
		if (_aktuelleKanalImVerlauf != _size-1)
		{
			if (_kanalVerlauf[_aktuelleKanalImVerlauf +1] != null )
			{
				_aktuelleKanalImVerlauf++;
				return _kanalVerlauf[_aktuelleKanalImVerlauf];
			}
		}
		return _kanalVerlauf[_aktuelleKanalImVerlauf];
	}
	
	/**
	 * Gibt den näschten Kanal zurück
	 * Der vorherige Kanal im Array wird zurück gegeben
	 * @return der letzte Kanal
	 */
	public Kanal gibNaechsteKanal()
	{
		if (istNaechsteKanalVerfuegbar())
		{
			_aktuelleKanalImVerlauf--;
			 return _kanalVerlauf[_aktuelleKanalImVerlauf];
		}
		else return _kanalVerlauf[_aktuelleKanalImVerlauf];
	}
	
	/**
	 * gibt zurück, ob es einen nächsten Kanal gibt
	 * @return true, wenn es gibt
	 */
	public boolean istLetzteKanalVerfuegbar()
	{
		return (_kanalVerlauf[_aktuelleKanalImVerlauf+1] != null)? true:false;
	}
	
	/**
	 * gibt zurück, ob es einen nächsten Kanal gibt
	 * @return true, wenn es gibt
	 */
	public boolean istNaechsteKanalVerfuegbar()
	{
		return (_aktuelleKanalImVerlauf != 0)? true:false;
	}
	
	public void einenKanalWirdGewaehlt(Kanal ausgewaehlteKanal)
	{
		Kanal[] tempKanalArray = new Kanal[_size];
		int zaehler = 0;
		for (int i = _aktuelleKanalImVerlauf; i< _size; i++)
			{
			if (zaehler+1 < 10)tempKanalArray[zaehler+1] = _kanalVerlauf[i];
			zaehler++;
			}
		_kanalVerlauf = tempKanalArray;
		
		//setze den neunen Kanal auf dem Platz 0
		_kanalVerlauf[0] = ausgewaehlteKanal;
		_aktuelleKanalImVerlauf = 0;
	}

	/**
	 * TEST
	 * 
	 * @return
	 */
	public Kanal[] get_kanalVerlaufArray() {
		return _kanalVerlauf;
	}
}

