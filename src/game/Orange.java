package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.io.IOException;


/**
 * Orange extends dynamic body
 * @author abulsyed
 * @version 1.2
 * @since 30/03/19
 */
public class Orange extends DynamicBody {

    private static final float radius = 0.25f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
            new BodyImage("data/ball.png", 20*radius);

    private SoundClip orangeSound;


    /**
     * Construct a Orange.
     * @param world the world in which this body exists.
     */
    public Orange(World world) {
        super(world, ballShape);
        addImage(ballImage);

        try {
            orangeSound = new SoundClip("data/orangeSound.wav");
            System.out.println("Loading orange sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public void playSound(){
        orangeSound.play();
    }
}
