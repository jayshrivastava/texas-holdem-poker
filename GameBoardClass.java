// The DiamondClass Class
// Second in a series of demonstration programs for introducing Java

import hsa.Console;
import java.awt.*;

class GameBoardClass extends ShapeClass
{

    protected void draw (Console c)
    {

	c.setColor (Color.black);
	c.fillOval (450, 400, 400, 400);
	c.fillOval (1024 - 450, 400, 400, 400);
	c.fillRect (450, 400 - 200, 1024 - 450 * 2, 400);

	c.setColor (Color.white);
	c.fillOval (450, 400, 375, 375);
	c.fillOval (1024 - 450, 400, 375, 375);
	c.fillRect (450, 400 - 175, 1024 - 450 * 2, 375);

	c.setColor (Color.green);
	c.fillOval (450, 400, 360, 360);
	c.fillOval (1024 - 450, 400, 360, 360);
	c.fillRect (450, 400 - 150, 1024 - 450 * 2, 360);
    }


    protected void draw (Graphics g)
    {

	g.setColor (Color.black);
	g.fillOval (20, 175, 450, 450);
	g.fillOval (1024 - 465, 175, 450, 450);
	g.fillRect (235, 177, 1024 - 235 * 2, 447);

	g.setColor (Color.white);
	g.fillOval (35 + 9, 190 + 9, 400, 400);
	g.fillOval (1024 - 450 + 9, 200, 400, 400);
	g.fillRect (235, 200, 1024 - 235 * 2, 398);

	g.setColor (Color.green);
	g.fillOval (35 + 20, 190 + 18, 375, 375);
	g.fillOval (1024 - 450 + 20, 190 + 18, 375, 375);
	g.fillRect (235, 210, 1024 - 235 * 2, 373);
    }
}

