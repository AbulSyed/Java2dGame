package game;

import java.awt.*;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class MyView extends UserView {
    Batman batman;

    
    static Image background;
    
    public MyView(World world, Batman batman, Image background, int width, int height) {
        super(world, width, height);
        this.batman=batman;
        MyView.background = background;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Font myFont = new Font ("Helvetica", Font.BOLD, 17);
        g.setFont(myFont);
        g.drawString("Score:" + batman.getOrangeCount(), 100,90);
        g.drawString("Lives:" + batman.getliveCount(), 100, 110);

    }

}
