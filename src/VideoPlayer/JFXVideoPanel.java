package VideoPlayer;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.*;


import javafx.application.Platform;
import javafx.embed.swing.*;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.media.*;

public class JFXVideoPanel extends JFXPanel {
    private Scene _scene;
    private StackPane _stack;
    private MediaView _view;
    private MediaPlayer _player;
    //private boolean _wait = true;
    String _videoLink;

    public JFXVideoPanel(String videoLink){
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
            	erzeugeVideoView(videoLink);
            	erzeugeScene();
                 
            	//Add Scene to Panel
                setScene(_scene);
                 
                //_wait = false;
            }
        });
        
    }
    
    /**
     * Erzeuge das MediaView _view
     * @param videoLink
     */
    private void erzeugeVideoView (String videoLink)
    {
    	_videoLink = videoLink;
	   	File file;
	   	if (videoLink == null)
	   	{
	   		file = new File("Videos/no signal.mp4");
	   	}
	   	else file = new File(videoLink);
	    	String source = file.toURI().toString();
	    	Media media = new Media(source);
	    	
	    	_player = new MediaPlayer(media);
	        _view = new MediaView(_player);
	        _view.setPreserveRatio(true);
	        _view.setFitWidth(800);
    }
    
    /**
     * Erzeuge die Scene
     */
    private void erzeugeScene ()
    {
        _stack = new StackPane();
        _stack.getChildren().add(_view);
        _player.play();
        _scene = new Scene(_stack, 1920, 1080);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new JFXVideoPanel(null);
            }
        });
    }
    
    public void stop()
    {
    	_player.pause();
    }
    
} 