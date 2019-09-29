package werkzeug;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import materialien.Kanal;
 
public class JListRenderer extends JLabel implements ListCellRenderer<Kanal> {
	
	/**
	 * Konstruktor
	 */
	public JListRenderer() {
		setOpaque(true);
	}
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Kanal> list, Kanal kanal, int index,
			boolean isSelected, boolean cellHasFocus) {
          
    	// Die Farbe von Items in der Liste
    	if (isSelected) {
    	    setBackground(list.getSelectionBackground());
    	    setForeground(list.getSelectionForeground());
    	} else {
    	    setBackground(list.getBackground());
    	    setForeground(list.getForeground());
    	}
    	
    	//Hinzufüge Icons und Texte
        String code = kanal.get_verkürzung();
        	//Resize das Bild
		int hoehe = 30;
		int breite = 60;
		ImageIcon imageIcon = new ImageIcon("logos/"+code+ ".png"); // Photo Datei -> ImageIcon -> Image, damit man Resize machen kann
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(breite, hoehe,  java.awt.Image.SCALE_SMOOTH); 	// scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // Image -> ImageIcon damit man in JLabel hinzufügen kann
         
        setIcon(imageIcon);
        setText(kanal.toString());
        return this;
    }
}
