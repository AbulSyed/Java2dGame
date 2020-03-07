package game;

import city.cs.engine.*;

/**
 * Bane extends dynamic body: walker
 * @author abulsyed
 * @version 1.2
 * @since 30/03/19
 */

public class Bane extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.288f,1.044f, 0.725f,-0.342f, 0.432f,-1.125f, -0.427f,-1.125f, -0.715f,-0.364f, -0.297f,1.08f);

    private static final BodyImage image =
            new BodyImage("data/bane.png", 2.25f);


    public Bane(World world) {
        super(world, shape);
        addImage(image);
    }

}
