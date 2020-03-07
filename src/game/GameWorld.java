package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author abul syed
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Batman batman;
    private Joker joker;
    private Bane bane;
    private Fire fire;
    private Twoface twoface;
    
    public GameWorld() {
        super();
        
        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        

        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -2.5f));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(-4, 1.5f));


        // make a character
        batman = new Batman(this);
        batman.setPosition(new Vec2(8, -10));

        joker = new Joker(this);
        joker.setPosition(new Vec2(-5, 6));
        joker.addCollisionListener(new Pickup(batman));

        bane = new Bane(this);
        bane.setPosition(new Vec2(4, -10));
        bane.addCollisionListener(new Pickup(batman));

        twoface = new Twoface(this);
        twoface.setPosition(new Vec2(4, -10));
        twoface.addCollisionListener(new Pickup(batman));

        fire = new Fire(this);
        fire.setPosition(new Vec2(4, -10));
        fire.addCollisionListener(new Pickup(batman));

        
        for (int i = 0; i < 11; i++) {
            Body football = new Orange(this);
            football.setPosition(new Vec2(i*2-10, 10));
            football.addCollisionListener(new Pickup(batman));
        }
    }

    /**
     * The method returns the player
     * @return The player
     */
    public Batman getPlayer() {
        return batman;
    }
}
