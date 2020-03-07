package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 2 of the game
 */
public class Level3 extends GameLevel {

    private Joker joker;

    private static final int NUM_ORANGES = 11;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Enemy character will spawn in level 3
        joker = new Joker(this);
        joker.setPosition(new Vec2(5,-2));
        joker.addCollisionListener(new Pickup(getPlayer()));

        //Enemy character will spawn in level 3
        joker = new Joker(this);
        joker.setPosition(new Vec2(5,-10));
        joker.addCollisionListener(new Pickup(getPlayer()));


        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.BLUE);


        // make some platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-6, 5.5f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(5, -2.5f));
        //Set color of platforms
        platform1.setFillColor(Color.BLUE);
        platform2.setFillColor(Color.BLUE);
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-15.5f, 5.5f));
        //Set color of platforms
        platform3.setFillColor(Color.BLUE);

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
        return new Vec2(-10.5f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() >=NUM_ORANGES;
    }

    @Override
    public ImageIcon getBackground(){
        ImageIcon icon = new ImageIcon("data/snow.gif");
        return icon;
    }
}
