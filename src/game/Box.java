package game;

import city.cs.engine.*;

/**
 * Box that can be drop by clicking which extends dynamic body: walker
 * @author abulsyed
 * @version 1.2
 * @since 30/03/19
 */
public class Box extends Walker {

    private static final float radius = 0.5f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
        new BodyImage("data/box.jpg", 2*radius);

    /**
     * Construct a box.
     * @param world the world in which this body exists.
     */
    public Box(World world) {
        super(world, ballShape);
        addImage(ballImage);
    }
}
