package game;

import city.cs.engine.*;

/**
 * Twoface extends dynamic body: walker
 * @author abulsyed
 * @version 1.2
 * @since 30/03/19
 */

public class Twoface extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.388f,1.049f, 0.499f,1.049f, 0.661f,-0.184f, 0.503f,-1.089f, -0.419f,-1.129f, -0.689f,-0.328f, -0.487f,0.968f);

    private static final BodyImage image =
            new BodyImage("data/twoface.png", 2.25f);


    public Twoface(World world) {
        super(world, shape);
        addImage(image);
    }
}
