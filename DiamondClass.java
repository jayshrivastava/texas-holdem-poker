// The DiamondClass Class
// Second in a series of demonstration programs for introducing Java

import hsa.Console;
import java.awt.*;

class DiamondClass extends SuitClass
{

    DiamondClass ()
    {
    }


    DiamondClass (int h)
    {
	setHeight (h);
    }


    public void draw (Console c)
    {
	// declare two arrays for X & Y coordinates of Diamond
	int iPointsX[] = new int [4];
	int iPointsY[] = new int [4];

	// calculate points on diamond & store in the arrays
	iPointsX [0] = cx - width / 2;
	iPointsY [0] = cy;
	iPointsX [1] = cx;
	iPointsY [1] = cy - height / 2;
	iPointsX [2] = cx + width / 2;
	iPointsY [2] = cy;
	iPointsX [3] = cx;
	iPointsY [3] = cy + height / 2;

	// draw the diamond using methods available from the Console object (c)
	c.setColor (iColor);
	if (isFilled)
	{
	    c.fillPolygon (iPointsX, iPointsY, 4);
	}
	else
	{
	    c.drawPolygon (iPointsX, iPointsY, 4);
	}
    }


    public void draw (Graphics g)
    {
	// declare two arrays for X & Y coordinates of Diamond
	int iPointsX[] = new int [4];
	int iPointsY[] = new int [4];

	// calculate points on diamond & store in the arrays
	iPointsX [0] = cx - width / 2;
	iPointsY [0] = cy;
	iPointsX [1] = cx;
	iPointsY [1] = cy - height / 2;
	iPointsX [2] = cx + width / 2;
	iPointsY [2] = cy;
	iPointsX [3] = cx;
	iPointsY [3] = cy + height / 2;

	// draw the diamond using methods available from the Console object (c)
	g.setColor (iColor);
	if (isFilled)
	{
	    g.fillPolygon (iPointsX, iPointsY, 4);
	}
	else
	{
	    g.drawPolygon (iPointsX, iPointsY, 4);
	}
    }
}
