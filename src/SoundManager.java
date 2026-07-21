import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundManager {

    private static Clip musicClip;

    // Plays looping background music
    public static void playMusic(String path) {
        try {

            if (musicClip != null && musicClip.isRunning()) {
                musicClip.stop();
                musicClip.close();
            }

            URL url = SoundManager.class.getResource(path);

            if (url == null) {
                System.out.println("MISSING SOUND FILE: " + path);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);


            musicClip = AudioSystem.getClip();
            musicClip.open(audio);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Stops the current music
    public static void stopMusic() {
        if (musicClip != null) {
            musicClip.stop();
            musicClip.close();
        }
    }



    // Plays a sound effect
    public static void playSFX(String path) {
        try {

            URL url = SoundManager.class.getResource(path);

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}