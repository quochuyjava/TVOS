package werkzeug;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;

import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import materialien.Kanal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 *
 * @author Quoc Huy Nguyen
 */
public class HomeScreenUI extends javax.swing.JFrame {
	
	// Komponenten von GUI     

    private JLabel _aktuelleChanelJLabel;
    private JPanel _bildschirmJPanel;
    private JList<Kanal> _kanalJList;
    private JLabel _statusJLabel;
    private JScrollPane _listeJScrollPane
    ;

    	//Buttons
    private JButton _homeButton;
    private JButton _backButton;
    private JButton _nextButton;
    
    	//Größe der Komponenten
    final private int _hoeheVonBildschirm = 316;
	final private int _breiteVonBildschirm = 433;
	final private int _breiteDerListe = 250;
    
    

    /**
     * Konstruktor
     */
    public HomeScreenUI() {
    	//Größe der Frame
        setPreferredSize(new Dimension(800, 500));
        setResizable(true);
        
        //Erzeugen die Komponenten
        erzeugeKomponenten();
        
        //Die Positionen der Komponenten
        erzeugeLayout();
    }

    /**
     * Die Komponenten werden erzeugen
     */
    
    private void erzeugeKomponenten() {
    	// Label des aktuellen Kanals
    	_aktuelleChanelJLabel = new javax.swing.JLabel();
    	_aktuelleChanelJLabel.setText("aktuelle Kanal ist:");

    	// Bilschirm JPanel
    	_bildschirmJPanel = new javax.swing.JPanel();

        //Liste von Kanälen wird in jScroll reingesezt
        _kanalJList = new javax.swing.JList<>();
        _listeJScrollPane = new javax.swing.JScrollPane();
        _listeJScrollPane.setViewportView(_kanalJList);
        _kanalJList.setModel(new DefaultListModel<Kanal>());
        
        //Status Label
        _statusJLabel = new javax.swing.JLabel();
        _statusJLabel.setText("Status:");
        
        //Die Buttons
        _homeButton = new JButton("Home");
        _backButton = new JButton("back");
        _nextButton = new JButton("Next");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    /**
     * Erzeugt das Layout
     */
    public void erzeugeLayout()
    {
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      // Horizontal
      layout.setHorizontalGroup(
          layout.createParallelGroup(Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(28)								// Linke Grenze von der ganzen JFrame
                  .addGroup(layout.createParallelGroup(Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(_homeButton)
                          .addGap(25)						//Abstand zu dem näschten Button
                          .addComponent(_backButton)
                          .addPreferredGap(ComponentPlacement.RELATED)
                          .addComponent(_nextButton))
                      .addComponent(_aktuelleChanelJLabel)
                      .addGroup(layout.createSequentialGroup()
                          .addGap(6)
                          .addGroup(layout.createParallelGroup(Alignment.LEADING)
                              .addComponent(_statusJLabel)
                              .addGroup(layout.createSequentialGroup()
                                  .addComponent(_bildschirmJPanel, GroupLayout.DEFAULT_SIZE, _breiteVonBildschirm, Short.MAX_VALUE)
                                  .addGap(18)
                                  .addComponent(_listeJScrollPane, GroupLayout.PREFERRED_SIZE, _breiteDerListe, GroupLayout.PREFERRED_SIZE)))))
                  .addContainerGap())
      );
      // Vertikal
      layout.setVerticalGroup(
          layout.createParallelGroup(Alignment.TRAILING)
              .addGroup(Alignment.LEADING, layout.createSequentialGroup()
                  .addGap(19)
                  .addComponent(_aktuelleChanelJLabel)
                  .addGap(14)
                  .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                      .addComponent(_listeJScrollPane, Alignment.LEADING)
                      .addComponent(_bildschirmJPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, _hoeheVonBildschirm, Short.MAX_VALUE))
                  .addGap(18)
                  .addComponent(_statusJLabel)
                  .addGap(18)
                  .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                      .addComponent(_homeButton)
                      .addComponent(_nextButton)
                      .addComponent(_backButton))
                  .addContainerGap(32, Short.MAX_VALUE))
      );
      getContentPane().setLayout(layout);

      pack();
    }    
    
    public javax.swing.JList<Kanal> get_kanalListe()
    {
        return _kanalJList;
    }
    
    public javax.swing.JPanel get_bildSchirmJPanel() {
		return _bildschirmJPanel;
	}

	public void set_bildschirmJPanel(javax.swing.JPanel _aktuelleInhalt) {
		this._bildschirmJPanel = _aktuelleInhalt;
	}

	/** 
	 * Gibt die Höhe des Bildschirm zurück
	 * @return _hoeheVonBildschirm
	 */
	public int get_hoeheVon_aktuelleInhalt() {
		return _hoeheVonBildschirm;
	}

	/**
	 * Gibt die Breite des Bildschirm zurück
	 * @return _breiteVonBildschirm
	 */
	public int get_breiteVon_aktuelleInhalt() {
		return _breiteVonBildschirm;
	}
}

