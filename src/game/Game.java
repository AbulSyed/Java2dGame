package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    private int level;

    private Controller controller;

    private SoundClip gameMusic;
    private SoundClip gameMusic2;
    private SoundClip gameMusic3;
    private SoundClip gameMusic4;



    /** Initialise a new Game. */
    public Game() {

       //make the World
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, world.getPlayer(), world.getBackground().getImage(), 500,500);


        try {
            HighScoreReader reader = new HighScoreReader("data/save.txt");
            reader.readScores();
        }
        catch (IOException e){
            e.printStackTrace();
        }


        try {
            gameMusic = new SoundClip("data/rain.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }



        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");




        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);


        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        DropBox db = new DropBox(view);
        view.addMouseListener(db);
        
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        // uncomment to make the view track the bird
       world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
         //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    /** The player in the current level. */
    public Batman getPlayer() {
        return world.getPlayer();

    }

    //world is paused if pause button pressed
    public void pause(){
        world.stop();
    }
    //world is resumed if start button pressed
    public void start(){
        world.start();
    }

    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();

        try {
            HighScoreWriter writer = new HighScoreWriter("data/save.txt");
            writer.writeHighScore("Syed", getPlayer().getOrangeCount());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Batman oldbatman = world.getPlayer();

        if (level == 4) {
            System.exit(0);
        } else if (level == 1){
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            MyView.background = world.getBackground().getImage();
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //load previous score
            view.batman=world.getPlayer();
            world.getPlayer().setOrangeCount(oldbatman.getOrangeCount());
            world.getPlayer().setLiveCount(oldbatman.getliveCount());
            // show the new world in the view
            // uncomment to make the view track the bird
            world.addStepListener(new Tracker(view, world.getPlayer()));
            view.setWorld(world);
            gameMusic.stop();
            try {
                gameMusic2 = new SoundClip("data/wind.wav");   // Open an audio input stream
                gameMusic2.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

            world.start();
        }else if (level == 2) {
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            MyView.background = world.getBackground().getImage();
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //load previous score
            view.batman = world.getPlayer();
            world.getPlayer().setOrangeCount(oldbatman.getOrangeCount());
            world.getPlayer().setLiveCount(oldbatman.getliveCount());
            // show the new world in the view
            // uncomment to make the view track the bird
            world.addStepListener(new Tracker(view, world.getPlayer()));
            view.setWorld(world);
            gameMusic2.stop();
            try {
                gameMusic3 = new SoundClip("data/ice.wav");   // Open an audio input stream
                gameMusic3.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }


            world.start();
        }else if (level == 3){
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            MyView.background = world.getBackground().getImage();
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //load previous score
            view.batman=world.getPlayer();
            world.getPlayer().setOrangeCount(oldbatman.getOrangeCount());
            world.getPlayer().setLiveCount(oldbatman.getliveCount());
            // show the new world in the view
            // uncomment to make the view track the bird
            world.addStepListener(new Tracker(view, world.getPlayer()));
            view.setWorld(world);
            gameMusic3.stop();
            try {
                gameMusic4 = new SoundClip("data/thunder.wav");   // Open an audio input stream
                gameMusic4.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

            world.start();


        }
    }

    /** Run the game. */
    public static void main(String[] args) {
       MainMenu.main();

    }
}
