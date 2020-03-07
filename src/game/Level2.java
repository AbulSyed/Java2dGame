package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private Twoface twoface;

    private static final int NUM_ORANGES = 6;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Enemy character will spawn in level 2
        twoface = new Twoface(this);
        twoface.setPosition(new Vec2(-5,3));
        twoface.addCollisionListener(new Pickup(getPlayer()));


        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.BLACK);
        

        

        // make some platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-7, -0.5f));
        //Set color of platforms
        platform1.setFillColor(Color.BLACK);

        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(0, 8.5f));
        //Set color of platforms
        platform2.setFillColor(Color.BLACK);

        for (int i = 0; i < NUM_ORANGES; i++) {
            Body orange = new Orange(this);
            orange.setPosition(new Vec2(i * 2 - 10, 10));
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(3f, 10f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() >=NUM_ORANGES;
    }

    @Override
    public ImageIcon getBackground(){
        ImageIcon icon = new ImageIcon("data/wind.gif");
        return icon;
    }
}
