// The DiamondClass Class
// Second in a series of demonstration programs for introducing Java

import hsa.Console;
import java.awt.*;

class ClubClass extends SuitClass
{

    ClubClass ()
    {
    }


    ClubClass (int h)
    {
	super.setHeight (h);
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
	iPointsY [2] = cy - height / 2;
	iPointsX [3] = cx - width / 2;
	iPointsY [3] = cy - height / 4;
	iPointsX [4] = cx;
	iPointsY [4] = cy - height / 4;

	int triPointsX[] = new int [3];
	int triPointsY[] = new int [3];

	triPointsX [0] = cx;
	triPointsY [0] = cy - height / 4;
	triPointsX [1] = cx - width / 8;
	triPointsY [1] = cy + height / 2;
	triPointsX [2] = cx + width / 8;
	triPointsY [2] = cy + height / 2;

	c.setColor (iColor);

	c.fillOval (iPointsX [3], iPointsY [3], width / 2, height / 2);
	c.fillOval (iPointsX [4], iPointsY [4], width / 2, height / 2);
	c.fillOval (cx - width / 4, cy - 4 * (height / 7), width / 2, height / 2);
	c.fillPolygon (triPointsX, triPointsY, 3);
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
	iPointsY [2] = cy - height / 2;
	iPointsX [3] = cx - width / 2;
	iPointsY [3] = cy - height / 4;
	iPointsX [4] = cx;
	iPointsY [4] = cy - height / 4;

	int triPointsX[] = new int [3];
	int triPointsY[] = new int [3];

	triPointsX [0] = cx;
	triPointsY [0] = cy - height / 4;
	triPointsX [1] = cx - width / 8;
	triPointsY [1] = cy + height / 2;
	triPointsX [2] = cx + width / 8;
	triPointsY [2] = cy + height / 2;

	g.setColor (iColor);

	g.fillOval (iPointsX [3], iPointsY [3], width / 2, height / 2);
	g.fillOval (iPointsX [4], iPointsY [4], width / 2, height / 2);
	g.fillOval (cx - width / 4, cy - 4 * (height / 7), width / 2, height / 2);
	g.fillPolygon (triPointsX, triPointsY, 3);
    }
}
