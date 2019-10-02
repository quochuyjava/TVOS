package werkzeug;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VideoPlayer.JFXVideoPanel;
import javafx.embed.swing.JFXPanel;
import materialien.Kanal;

import javax.swing.JLabel;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class HomeScreenUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Komponenten von GUI
	private JPanel _hauptPanel;
	private JFXVideoPanel _bildschirmVideoPanel;
	private JPanel _bildschirmPhotoJPanel;
	private JScrollPane _listeJScrollPane;
	private JList<Kanal> _kanalJList;
	private JButton _homeButton;
	private JButton _nextButton;
	private JButton _backButton;
	private JLabel _statusJLabel;
	private JLabel _aktuelleChanelJLabel;
	
    final private int _hoeheVonBildschirm = 400;	//goc 385
	final private int _breiteVonBildschirm = 800;	//goc 500

	/**
	 * Create the frame.
	 */
	public HomeScreenUI() {
		erzeugeKomponenten();
		setResizable(false);
		

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
	}
	
	private void erzeugeKomponenten() 
	{
		int breiteVonJFrame = 273+_breiteVonBildschirm;
		int hoeheVonJFrame = 169+_hoeheVonBildschirm;
		setBounds(100, 100, breiteVonJFrame,hoeheVonJFrame);
		
		//_hauptPanel
		_hauptPanel = new JPanel();
		_hauptPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(_hauptPanel);
		_hauptPanel.setLayout(null);
		
		//_aktuelleChanelJLabel
		_aktuelleChanelJLabel = new JLabel("aktuelle Kanal ist:");
		_aktuelleChanelJLabel.setBounds(5, 5, 763, 16);
		_hauptPanel.add(_aktuelleChanelJLabel);
		
		//_bildschirmVideoPanel
		_bildschirmVideoPanel = new JFXVideoPanel(null);
		_bildschirmVideoPanel.setAlignmentX(5.0f);
		_bildschirmVideoPanel.setBounds(6, 33, _breiteVonBildschirm, _hoeheVonBildschirm);
		_bildschirmVideoPanel.setAlignmentY(50.0f);
		_bildschirmVideoPanel.setMinimumSize(new Dimension(400, 200));
		_bildschirmVideoPanel.setMaximumSize(new Dimension(1024, 768));
		_hauptPanel.add(_bildschirmVideoPanel);
		
		//_listeJScrollPane
		_listeJScrollPane = new JScrollPane();
		//_listeJScrollPane.setBounds(528, 33, 240, 385);
		int breieVom_listeJScrollPane = 240;
		_listeJScrollPane.setBounds(breiteVonJFrame - breieVom_listeJScrollPane - 5, 33, breieVom_listeJScrollPane, _hoeheVonBildschirm);
		_hauptPanel.add(_listeJScrollPane);
		
		//_kanalJList
		_kanalJList = new JList<Kanal>();
		_listeJScrollPane.setViewportView(_kanalJList);
		_kanalJList.setModel(new DefaultListModel<Kanal>());	//Renderer für icon und text in der JList
        _kanalJList.setCellRenderer(new JListRenderer());
        
		//Buttons
        int YPositionVonButtons = hoeheVonJFrame-60;
			//_homeButton
		_homeButton = new JButton("Home");
		_homeButton.setBounds(26, YPositionVonButtons, 117, 29);
		_hauptPanel.add(_homeButton);
		
			//_backButton
		_backButton = new JButton("Back");
		_backButton.setBounds(184, YPositionVonButtons, 117, 29);
		_hauptPanel.add(_backButton);
		_backButton.setEnabled(false);
		
			//_nextButton
		_nextButton = new JButton("Next");
		_nextButton.setBounds(313, YPositionVonButtons, 117, 29);
		_hauptPanel.add(_nextButton);
		_nextButton.setEnabled(false);
		
		//_statusJLabel
		int YPositionVon_statusJLabel = hoeheVonJFrame-120;
		_statusJLabel = new JLabel("Status:");
		_statusJLabel.setBounds(35, YPositionVon_statusJLabel, 61, 16);
		_hauptPanel.add(_statusJLabel);
		
		//_bildschirmPhotoJPanel
		_bildschirmPhotoJPanel = new JPanel();
		_bildschirmPhotoJPanel.setBounds(454, 431, 285, 75);
		_hauptPanel.add(_bildschirmPhotoJPanel);
	}
	
    public javax.swing.JList<Kanal> get_kanalListe()
    {
        return _kanalJList;
    }
    
    public int get_hoeheVon_aktuelleInhalt() {
		return _hoeheVonBildschirm;
	}

	public int get_breiteVon_aktuelleInhalt() {
		return _breiteVonBildschirm;
	}

	public JButton get_backButton() {
		return _backButton;
	}

	public JButton get_nextButton() {
		return _nextButton;
	}

	public JLabel get_aktuelleChanelJLabel() {
		return _aktuelleChanelJLabel;
	}

	public void set_bildschirmVideoPanel(JFXVideoPanel bildschirmJFXPanel) {
		_bildschirmVideoPanel = bildschirmJFXPanel;
	}

	public JFXPanel get_bildschirmVideoPanel() {
		return _bildschirmVideoPanel;
	}

	public javax.swing.JPanel get_bildSchirmPhotoJPanel() {
		return _bildschirmPhotoJPanel;
	}

	public void set_bildschirmPhotoJPanel(javax.swing.JPanel _aktuelleInhalt) {
		this._bildschirmPhotoJPanel = _aktuelleInhalt;
	}

	public JPanel getHauptPane() {
		return _hauptPanel;
	}
	
	/**
	 * erzeugt ein VideoPanel und füge in _hauptPanel hinzu
	 * @param panel JFXVideoPanel
	 */
	public void addVideoPanel(JFXVideoPanel panel)
	{
		_bildschirmVideoPanel = panel;
		_bildschirmVideoPanel.setBounds(6, 33, _breiteVonBildschirm, _hoeheVonBildschirm);
		_bildschirmVideoPanel.setAlignmentY(50.0f);
		_bildschirmVideoPanel.setMinimumSize(new Dimension(600, 400));
		_bildschirmVideoPanel.setMaximumSize(new Dimension(800, 600));
		_hauptPanel.add(_bildschirmVideoPanel, 1);
	}
}
