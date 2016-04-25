// The ChipClass Class
// Second in a series of demonstration programs for introducing Java

import hsa.Console;
import java.awt.*;

public class ChipClass extends ShapeClass
{
    // global variables for this class
    // encapsulated data
    protected int cValue = 5000;
    Font fc = new Font ("SanSerif", Font.PLAIN, 14);

    // constructor methods
    ChipClass ()
    {
	height = width;
    }


    ChipClass (int w, int h)
    {
	width = w;
	height = h;
    }


    ChipClass (int w, int h, int chipvalue)
    {
	width = w;
	height = h;
	cValue = chipvalue;
    }


    ChipClass (int centerx, int centery, int w, int h, int chipvalue)
    {
	cx = centerx;
	cy = centery;
	width = w;
	height = h;
	cValue = chipvalue;
    }



    // communicator methods
    public void setChipValue (int nValue)
    {
	if (nValue < 0)
	{
	    //TODO
	    //Return error message
	}
	else
	{
	    cValue = nValue;
	}

    }


    public void setChipColor (int nValue)
    {
	if (nValue == 1)
	{
	    setColor (Color.white);
	}
	else if (nValue == 5)
	{
	    setColor (Color.red);
	}
	else if (nValue == 10)
	{
	    setColor (Color.blue);
	}
	else if (nValue == 25)
	{
	    setColor (Color.green);
	}
	else if (nValue == 100)
	{
	    setColor (Color.black);
	}
	else if (nValue == 250)
	{
	    setColor (Color.pink);
	}
	else if (nValue == 1000)
	{
	    setColor (Color.yellow);
	}
	else if (nValue == 5000)
	{
	    setColor (Color.orange);
	}

    }


    public int getChipValue ()
    {
	return cValue;
    }


    public Color getChipColor ()
    {
	return iColor;
    }



    public void drawChipValue (Graphics g, int nValue)
    {
	g.setFont (fc);
	if (nValue == 1)
	{
	    g.setColor (Color.black);
	}
	else
	{
	    g.setColor (Color.white);
	}

	g.drawString (Integer.toString (cValue), cx + width / 2 - 5, cy + width / 2 + 5);
	g.setColor (iColor);

    }


    public void draw (Console c)
    {

    }


    public void draw (Graphics g)
    {

	setChipColor (cValue);
	g.setColor (iColor);
	g.fillOval (cx, cy, width, height);
	drawChipValue (g, cValue);

    }
}


