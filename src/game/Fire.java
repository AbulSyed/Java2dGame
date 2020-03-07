package game;

import city.cs.engine.*;

/**
 * Fire extends dynamic body: walker
 * @author abulsyed
 * @version 1.2
 * @since 30/03/19
 */
public class Fire extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.553f,-1.003f, 0.554f,-0.985f, 0.788f,0.743f, 0.351f,1.076f, -0.598f,0.896f, -0.805f,-0.855f);

    private static final BodyImage image =
            new BodyImage("data/fire2.gif", 2.25f);


    public Fire(World world) {
        super(world, shape);
        addImage(image);
    }
}
