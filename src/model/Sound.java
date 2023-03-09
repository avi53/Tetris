package model;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL mySoundURL[] = new URL[5];

    public Sound() {

        mySoundURL[0] = getClass().getResource("/Sound/main_music.wav");

    }

    public void setFile(final int theIndex) {
        try {
            final AudioInputStream audio = AudioSystem.getAudioInputStream(mySoundURL[theIndex]);
            clip = AudioSystem.getClip();
            clip.open(audio);

        } catch (final Exception e) { }

    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
