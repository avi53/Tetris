package controller;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Sound class that is responsible for storing and playing
 * audio clips.
 *
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public class Sound {
    /**
     * size of sound array.
     */
    private static final int ARRAY_SIZE = 5;
    /**
     * Final index of mySoundURL array.
     */
    private static final int FINAL_INDEX = 3;
    /**
     * Stores a short audio clip that can be played, repeated,
     * or stopped at any time.
     */
    private Clip myClip;
    /**
     * An array that stores the address of sound files.
     */
    private final URL[] mySoundURL = new URL[ARRAY_SIZE];
    /**
     * Sound constructor that adds all the audio files into the array.
     */
    public Sound() {
        mySoundURL[0] = getClass().getResource("/Sound/main_music.wav");
        mySoundURL[1] = getClass().getResource
                ("/Sound/mixkit-bonus-earned-in-video-game-2058.wav");
        mySoundURL[2] = getClass().getResource
                ("/Sound/mixkit-electronic-retro-block-hit-2185.wav");
        mySoundURL[FINAL_INDEX] = getClass().getResource
                ("/Sound/mixkit-game-bonus-reached-2065.wav");

    }

    /**
     * Method that assigns the clip with the audio data in the "AudioInputStream".
     *
     * @param theIndex specifies the index of the audio file in the "mySoundURL".
     */
    public void setFile(final int theIndex) {
        try (AudioInputStream audio =
                     AudioSystem.getAudioInputStream(mySoundURL[theIndex])) {
            myClip = AudioSystem.getClip();
            myClip.open(audio);
        } catch (final IOException | UnsupportedAudioFileException
                       | LineUnavailableException ignored) {

        }
    }

    /**
     * Method that plays the audio clip.
     */
    public void play() {
        myClip.start();
    }

    /**
     * Method that loops the audio clip.
     */
    public void loop() {
        myClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
