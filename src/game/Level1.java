package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {


    private Bane bane;

    private static final int NUM_ORANGES = 11;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Enemy character will spawn in level 1
        bane = new Bane(this);
        bane.setPosition(new Vec2(3,-2));
        bane.addCollisionListener(new Pickup(getPlayer()));

        //Enemy character will spawn in level 1
        bane = new Bane(this);
        bane.setPosition(new Vec2(-4,6));
        bane.addCollisionListener(new Pickup(getPlayer()));


        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.WHITE);



        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);

        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 11f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -3f));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(-1, 5f));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(3, 15f));

        //Set color of platforms
        platform1.setFillColor(Color.WHITE);
        platform2.setFillColor(Color.WHITE);
        platform3.setFillColor(Color.WHITE);
        platform4.setFillColor(Color.WHITE);




        for (int i = 0; i < 11; i++) {
            Body orange = new Orange(this);
            orange.setPosition(new Vec2(i*2-10, 12));
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(5f, 16.5f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() == 11;
    }

    @Override
    public ImageIcon getBackground(){
        ImageIcon icon = new ImageIcon("data/rain.gif");

        return icon;
    }
}
