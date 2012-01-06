// CPR 2.0
// Josh Drummond
// (c) 1999

import java.awt.*;

public class CPRPen
{
   int intX, intY, intSize;
   Color color;

   public CPRPen(int x, int y, int s, Color c)
   {
      intX = x;
      intY = y;
      intSize = s;
      color = c;
   }

   public void draw(Graphics g)
   {
      g.setColor(color);
      g.fillOval(intX, intY, intSize, intSize);
   }
}
