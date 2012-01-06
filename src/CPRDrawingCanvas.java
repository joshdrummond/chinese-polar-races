// Chinese Polar Races v2.0
//  By Josh Drummond
//  Sets a space for drawing of chinese characters

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CPRDrawingCanvas
    extends Canvas
    implements MouseMotionListener, MouseListener
{
    private Color colBackground, colForeground;
    private boolean isDrag;
    private int oldx, oldy;

    public CPRDrawingCanvas(Color colBackground, Color colForeground,
       int x, int y)
    {
        this.colBackground = colBackground;
        this.colForeground = colForeground;
	this.setSize(x, y);
        isDrag = false;
        oldx = oldy = 0;
	this.addMouseMotionListener(this);
	this.addMouseListener(this);
    }

    public void clear()
    {
       repaint();
    }

    public void setForeground(Color colForeground)
    {
       this.colForeground = colForeground;
    }

    public Color getForeground()
    {
       return this.colForeground;
    }

    public void setBackground(Color colBackground)
    {
       this.colBackground = colBackground;
    }

    public Color getBackground()
    {
       return this.colBackground;
    }

    public void paint(Graphics g)
    {
       g.setColor(colBackground);
       g.fillRect(0, 0, getSize().width - 1, getSize().height - 1);
       g.setColor(colForeground);
       g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
       g.drawString("Draw Here", 10, 15);
    }


    // *** Implementation methods
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }

    public void mousePressed(MouseEvent e)
    {
       isDrag = false;
       Graphics g = getGraphics();
       g.setColor(colForeground);
       g.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
       oldx = e.getX();
       oldy = e.getY();
    }

    public void mouseReleased(MouseEvent e)
    {
       Graphics g = getGraphics();
       g.setColor(colForeground);
       if (isDrag)
         g.drawLine(oldx, oldy, e.getX(), e.getY());
       else
         g.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
       oldx = e.getX();
       oldy = e.getY();
       isDrag = false;
    }

    public void mouseDragged(MouseEvent e)
    {
       Graphics g = getGraphics();
       g.setColor(colForeground);
       g.drawLine(oldx, oldy, e.getX(), e.getY());
       isDrag = true;
       oldx = e.getX();
       oldy = e.getY();
    }
}
