
package game;

import city.cs.engine.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A MouseListener that drops a box on each mouse press.
 */
public class DropBox implements MouseListener {

    private WorldView view;

    /**
     * Construct a listener.
     * @param view the view the mouse will be clicked on
     */
    public DropBox(WorldView view) {
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Create a box at the current mouse position.
     * @param e event object containing the mouse position
     */
    @Override
    public void mousePressed(MouseEvent e) {
        DynamicBody ball = new Box(view.getWorld());
        ball.setPosition(view.viewToWorld(e.getPoint()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
