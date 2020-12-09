package sample;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Sample;
import net.beadsproject.beads.data.SampleAudioFormat;
import net.beadsproject.beads.data.audiofile.AudioFileReader;
import net.beadsproject.beads.data.audiofile.AudioFileType;
import net.beadsproject.beads.data.audiofile.FileFormatException;
import net.beadsproject.beads.data.audiofile.OperationUnsupportedException;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.SamplePlayer;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class SoundPlayer {

    String samplePath;
    private Glide gainValue;
    Gain g;

    public FileChooser loadSample() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.acac")
        );
        return fileChooser;
    }
    public String setSample (File file){
        String path = null;
        try {
            path = file.getCanonicalPath();
            samplePath = path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path);
        return path;
    }
    public String getSample() {
        return samplePath;
    }

    public void playSample()
    {
        AudioContext ac = new AudioContext();
        Sample sourceSample = null;
        boolean sampleReady = false;
        try {
            sourceSample = new Sample(this.getSample());
            sampleReady = true;
            SamplePlayer sp = new SamplePlayer(ac, sourceSample);
            gainValue = new Glide(ac, (float) 30.0, 20);
            g = new Gain(ac, 1, gainValue);
            g.addInput(sp); // connect the SamplePlayer to the Gain
            ac.out.addInput(g); // connect the Gain to the AudioContext 
            ac.start();g = new Gain(ac, 1, gainValue);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

    }
}
