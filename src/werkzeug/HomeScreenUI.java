package werkzeug;

import javax.swing.DefaultListModel;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quochuy
 */
public class HomeScreenUI extends javax.swing.JFrame {
	
	// Variables declaration - do not modify     

    private javax.swing.JLabel _aktuelleChanelLabel;
    private javax.swing.JPanel _aktuelleInhalt;
    private javax.swing.JList<String> _kanalListe;
    private javax.swing.JLabel _statusLabel;
    private javax.swing.JScrollPane jScrollPane1;

    //Buttons
    private JButton _homeButton;
    private JButton _backButton;
    private JButton _nextButton;
    
    //Größe der Komponenten
    final private int _hoeheVon_aktuelleInhalt = 316;
	final private int _breiteVon_aktuelleInhalt = 433;
    // End of variables declaration   
    
    

    /**
     * Konstruktor
     * Creates new form HomeScreenUI
     */
    public HomeScreenUI() {
        setPreferredSize(new Dimension(700, 500));
        setResizable(false);
        //initComponents();
        erzeugeAktuelleInhalt();
        zeigeAktuelleInhalt();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void erzeugeAktuelleInhalt() {
    	// Aktuelle Chanel
    	_aktuelleChanelLabel = new javax.swing.JLabel();
    	_aktuelleChanelLabel.setText("aktuelle Kanal ist:");

    	// Aktuelle Inhalt
    	_aktuelleInhalt = new javax.swing.JPanel();





        //Chanel Liste
        _kanalListe = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(_kanalListe);
        _kanalListe.setModel(new DefaultListModel());
        
        //Status Label
        _statusLabel = new javax.swing.JLabel();
        _statusLabel.setText("Status:");
        
        //Die Buttons
        _homeButton = new JButton("Home");
        _backButton = new JButton("back");
        _nextButton = new JButton("Next");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        gruppeDieKomponenten();
    }
    
    public void gruppeDieKomponenten()
    {
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      layout.setHorizontalGroup(
          layout.createParallelGroup(Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(28)
                  .addGroup(layout.createParallelGroup(Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(_homeButton)
                          .addGap(18)
                          .addComponent(_backButton)
                          .addPreferredGap(ComponentPlacement.RELATED)
                          .addComponent(_nextButton))
                      .addComponent(_aktuelleChanelLabel)
                      .addGroup(layout.createSequentialGroup()
                          .addGap(6)
                          .addGroup(layout.createParallelGroup(Alignment.LEADING)
                              .addComponent(_statusLabel)
                              .addGroup(layout.createSequentialGroup()
                                  .addComponent(_aktuelleInhalt, GroupLayout.DEFAULT_SIZE, _breiteVon_aktuelleInhalt, Short.MAX_VALUE)
                                  .addGap(18)
                                  .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))))
                  .addContainerGap())
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(Alignment.TRAILING)
              .addGroup(Alignment.LEADING, layout.createSequentialGroup()
                  .addGap(19)
                  .addComponent(_aktuelleChanelLabel)
                  .addGap(14)
                  .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                      .addComponent(jScrollPane1, Alignment.LEADING)
                      .addComponent(_aktuelleInhalt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, _hoeheVon_aktuelleInhalt, Short.MAX_VALUE))
                  .addGap(18)
                  .addComponent(_statusLabel)
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

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HomeScreenUI().setVisible(true);
//            }
//        });
//    }

    
    public javax.swing.JList<String> get_kanalListe()
    {
        return _kanalListe;
    }
    
    public javax.swing.JPanel get_aktuelleInhalt() {
		return _aktuelleInhalt;
	}

	public void set_aktuelleInhalt(javax.swing.JPanel _aktuelleInhalt) {
		this._aktuelleInhalt = _aktuelleInhalt;
	}

	private void zeigeAktuelleInhalt()
	  {
		//resize
		ImageIcon imageIcon = new ImageIcon("Inhalt/vtv.jpg"); // transform it 
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(_breiteVon_aktuelleInhalt, _hoeheVon_aktuelleInhalt,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		JLabel label = new JLabel(imageIcon);
		_aktuelleInhalt.add(label);
		_aktuelleInhalt.revalidate();
		_aktuelleInhalt.repaint();
	  }

	public int get_hoeheVon_aktuelleInhalt() {
		return _hoeheVon_aktuelleInhalt;
	}

	public int get_breiteVon_aktuelleInhalt() {
		return _breiteVon_aktuelleInhalt;
	}
}

