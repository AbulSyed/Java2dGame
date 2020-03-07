package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level4 extends GameLevel{

    private Bane bane;
    private Fire fire;
    private Twoface twoface;
    private Joker joker;

    private static final int NUM_ORANGES = 11;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Enemy character will spawn in level 4
        joker = new Joker(this);
        joker.setPosition(new Vec2(5,-11));
        joker.addCollisionListener(new Pickup(getPlayer()));

        //Enemy character will spawn in level 4
        twoface = new Twoface(this);
        twoface.setPosition(new Vec2(-7,7));
        twoface.addCollisionListener(new Pickup(getPlayer()));

        //Enemy character will spawn in level 4
        fire = new Fire(this);
        fire.setPosition(new Vec2(-5,-11));
        fire.addCollisionListener(new Pickup(getPlayer()));



        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.WHITE);

        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);

        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 6.5f));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-6, 23f));
        platform1.setFillColor(Color.WHITE);
        platform4.setFillColor(Color.WHITE);



        Shape boxShape3 = new BoxShape(1, 0.5f);
        Body platforma = new StaticBody(this, boxShape3);
        platforma.setPosition(new Vec2(12, -5f));
        platforma.setFillColor(Color.WHITE);

        Body platformb = new StaticBody(this, boxShape3);
        platformb.setPosition(new Vec2(2, -2f));
        platformb.setFillColor(Color.WHITE);

        Body platformc = new StaticBody(this, boxShape3);
        platformc.setPosition(new Vec2(7, 4f));
        platformc.setFillColor(Color.WHITE);


        Shape boxShape2 = new BoxShape(0.5f, 15f);
        Body platform5 = new StaticBody(this, boxShape2);
        platform5.setPosition(new Vec2(12.5f, 5f));
        platform5.setFillColor(Color.WHITE);

        Body platform6 = new StaticBody(this, boxShape2);
        platform6.setPosition(new Vec2(-12.5f, 5f));
        platform6.setFillColor(Color.WHITE);


        Body platform7 = new StaticBody(this, boxShape3);
        platform7.setPosition(new Vec2(1f, 14f));
        platform7.setFillColor(Color.WHITE);







        for (int i = 0; i < 11; i++) {
            Body orange = new Orange(this);
            orange.setPosition(new Vec2(i*2-10, 12));
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(1, 15);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-4f, 24.5f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() >=NUM_ORANGES;
    }

    @Override
    public ImageIcon getBackground(){
        ImageIcon icon = new ImageIcon("data/thunder.gif");
        return icon;
    }
}
