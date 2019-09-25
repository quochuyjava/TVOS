package werkzeug;

import java.awt.Dimension;
import javax.swing.*;
import javax.media.bean.playerbean.MediaPlayer;
 
class VideoPlayer extends JFrame{
MediaPlayer player;//our player
 
public VideoPlayer(String path){
super("Simple video player");
 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
setSize(new Dimension(640,480));//set the window size
 
player = new MediaPlayer();
//path – path to the file
player.setMediaLocation("file:///" + path); 
player.setPlaybackLoop(false);//repeat the video
player.prefetch ();//preliminary processing of the player (without it the player will not appear)
//add to the frame 
add(player);
//player.start (); - start the player immediately
 
setVisible(true);
}
 
public static void main(String []args){
    VideoPlayer ve = new VideoPlayer("/Users/quochuy/Downloads/drop.avi");
}
}