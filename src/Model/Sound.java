package Model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    private Clip clip;

   public Sound(String filename){
       try {
           AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filename));
           clip = AudioSystem.getClip();
           clip.open(ais);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    public void play() {
        if (!clip.isRunning()) {
        } else {
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
    }
   }

