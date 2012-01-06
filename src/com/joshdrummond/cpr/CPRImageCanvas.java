package com.joshdrummond.cpr;
// Chinese Polar Races v1.0
//  By Josh Drummond
//  Sets a space for the animation images and characters in the game

import java.awt.*;

public class CPRImageCanvas
    extends Canvas
{
    Image image;

    public CPRImageCanvas(Image IMAGE, int x, int y)
    {
	image = IMAGE;
	this.setSize(x, y);
    }

    public void setImage(Image IMAGE)
    {
        image = IMAGE;
        repaint();
    }

    public void paint(Graphics g)
    {
      int w = image.getWidth(this);
      int h = image.getHeight(this);
      g.drawImage(image, (this.getSize().width-w)/2, (this.getSize().height-h)/2, this);
//	g.drawImage(image, 0, 0, this);
    }
}
