package game;

import city.cs.engine.*;

/**
 * Batman extends dynamic body: walker
 * @author abulsyed
 * @version 1.2
 * @since 30/03/19
 */

public class Batman extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.373f,1.098f, -0.562f,0.108f, -0.513f,-1.035f, 0.446f,-1.102f, 0.572f,-0.265f, 0.189f,1.098f);

    private static final BodyImage image =
            new BodyImage("data/batman.png", 2.25f);

    private int orangeCount;
    private int liveCount;

    public Batman(World world) {
        super(world, shape);
        addImage(image);
        orangeCount = 0;
        liveCount=5;
    }

    /**
     * The method returns the score
     * @return The orangeCount
     */
    public int getOrangeCount() {
        return orangeCount;
    }

    public void setOrangeCount(int orangeCount){
        this.orangeCount=orangeCount;
    }
    //increment the score each time you collect a orange
    public void incrementOrangeCount() {
        orangeCount++;
        System.out.println("Nice!  Power points = " + orangeCount);
    }


    /**
     * The method returns the live
     * @return The liveCount
     */
    public int getliveCount() {
        return liveCount;
    }

    public void setLiveCount(int liveCount) {
        this.liveCount = liveCount;
    }

    /*decrements the live count each time you make contact with enemy
    In console will print out a message that you've lost a life
    If life count=0, the game ends
    */
    public void decrementliveCount() {
        liveCount--;
        System.out.println("You have lost a life. Lives = " + liveCount);
        if (liveCount==0){
            System.exit(0);
        }
    }


}
