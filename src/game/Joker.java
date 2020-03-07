package game;

import city.cs.engine.*;


/**
 * Joker extends dynamic body: walker
 * @author abulsyed
 * @version 1.2
 * @since 30/03/19
 */
public class Joker extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.364f,0.932f, -0.706f,-0.391f, -0.409f,-1.12f, 0.414f,-1.129f, 0.702f,-0.364f, 0.392f,0.959f);

    private static final BodyImage image =
            new BodyImage("data/joker.png", 2.25f);


    public Joker(World world) {
        super(world, shape);
        addImage(image);
    }

}
