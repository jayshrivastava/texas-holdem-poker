// The DiamondClass Class
// Second in a series of demonstration programs for introducing Java

import hsa.Console;
import java.awt.*;

class HeartClass extends SuitClass
{

    HeartClass ()
    {
    }


    HeartClass (int h)
    {
	setHeight (h);
    }


    public void draw (Console c)
    {
	int iPointsX[] = new int [5];
	int iPointsY[] = new int [5];

	iPointsX [0] = cx - width / 2;
	iPointsY [0] = cy;
	iPointsX [1] = cx + width / 2;
	iPointsY [1] = cy;
	iPointsX [2] = cx;
	iPointsY [2] = cy + height / 2;
	iPointsX [3] = cx - width / 2;
	iPointsY [3] = cy - height / 4;
	iPointsX [4] = cx;
	iPointsY [4] = cy - height / 4;

	c.setColor (iColor);

	c.fillArc (iPointsX [3], iPointsY [3], width / 2, height / 2, 0, 180);
	c.fillArc (iPointsX [4], iPointsY [4], width / 2, height / 2, 0, 180);
	c.fillPolygon (iPointsX, iPointsY, 3);
    }


    public void draw (Graphics g)
    {
	int iPointsX[] = new int [5];
	int iPointsY[] = new int [5];

	iPointsX [0] = cx - width / 2;
	iPointsY [0] = cy;
	iPointsX [1] = cx + width / 2;
	iPointsY [1] = cy;
	iPointsX [2] = cx;
	iPointsY [2] = cy + height / 2;
	iPointsX [3] = cx - width / 2;
	iPointsY [3] = cy - height / 4;
	iPointsX [4] = cx;
	iPointsY [4] = cy - height / 4;

	g.setColor (iColor);

	g.fillArc (iPointsX [3], iPointsY [3], width / 2, height / 2, 0, 180);
	g.fillArc (iPointsX [4], iPointsY [4], width / 2, height / 2, 0, 180);
	g.fillPolygon (iPointsX, iPointsY, 3);
    }
}
