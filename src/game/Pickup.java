package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Batman batman;

    public Pickup(Batman batman) {
        this.batman = batman;
    }

    @Override
    public void collide(CollisionEvent e) {
        System.out.println("collision!");

        /*
        Increase Score if you collect a orange
        Then destroy the orange
         */
        if (e.getReportingBody() instanceof Orange && e.getOtherBody() == batman) {
            batman.incrementOrangeCount();
            e.getReportingBody().destroy();
            ((Orange) e.getReportingBody()).playSound();
        }
        /*
        Decrease lives if you make contact with Joker(Enemy)
        Then destroy the Joker
         */
        else if (e.getReportingBody() instanceof Joker && e.getOtherBody() == batman) {
            batman.decrementliveCount();
            e.getReportingBody().destroy();
        }
        /*
        Decrease lives if you make contact with Bane(Enemy)
        Then destroy the Bane
         */
        else if (e.getReportingBody() instanceof Bane && e.getOtherBody() == batman){
            batman.decrementliveCount();
            e.getReportingBody().destroy();
        }
        /*
        Decrease lives if you make contact with Twoface(Enemy)
        Then destroy the Twoface
         */
        else if (e.getReportingBody() instanceof Twoface && e.getOtherBody() == batman){
            batman.decrementliveCount();
            e.getReportingBody().destroy();
        }
        /*
        If you make contact with fire then the game ends
         */
        else if (e.getReportingBody() instanceof Fire && e.getOtherBody() == batman){
            System.exit(0);
            e.getReportingBody().destroy();



        }
}
}