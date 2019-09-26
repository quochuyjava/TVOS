package startup;


import java.util.ArrayList;
import java.util.List;

import Service.HomeScreenService;
import materialien.Kanal;
import werkzeug.HomeScreenUI;
import werkzeug.HomeScreenWerkzeug;

public class StartUp
{

    public static void main(String[] args)
    {
        System.out.println("show console");
        HomeScreenService homeScreenService = erzeugeHomeScreenService();
        HomeScreenWerkzeug homescreen = new HomeScreenWerkzeug(homeScreenService);

    }
    
    private static HomeScreenService erzeugeHomeScreenService()
    {
        HomeScreenService homeScreenService = new HomeScreenService(erzeugeBeispielKanal());
        
        return homeScreenService;
        
    }

    private static List<Kanal> erzeugeBeispielKanal()
    {
        List<Kanal> kanalListe = new ArrayList<Kanal>();
        kanalListe.add(new Kanal ("VTV", "VTV", "Vietnamese", "Vietnam", "Inhalt/vtv.jpg"));
        kanalListe.add(new Kanal ("VTC", "VTC", "Vietnamese", "Vietnam", "Inhalt/vtc.jpg"));
        kanalListe.add(new Kanal ("PRO7", "PRO7", "Vietnamese", "Vietnam", "Inhalt/pro8.jpg"));
        return kanalListe;
        
    }
}
