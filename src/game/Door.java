package game;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level. 
 */
public class Door extends StaticBody {

    /**
     * Initialise a new door.
     * @param world The world.
     */
    private static final float radius = 0.85f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
            new BodyImage("data/portal1.gif", 2*radius);

    public Door(World world) {
        super(world, ballShape);
        addImage(ballImage);
    }}


