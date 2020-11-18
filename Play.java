import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
public class Play{
    String path;
    //MediaPlayer Player;
    Play(String Path){
        path=Path;
        //
    }
    void p(){
        File f=new File(path);
        Media _media = new Media(f.toURI().toString());
        //        必须有这一行，并且要在MediaPlayer创建之前
        final JFXPanel fxPanel= new JFXPanel();
        MediaPlayer _mediaPlayer= new MediaPlayer(_media);
        _mediaPlayer.play();
        //Player=_mediaPlayer;
    }
}