import hsa.Console;
import java.awt.*;

abstract class ShapeClass

{
    protected boolean filled = true;
    protected int height = 70;
    protected int width = 50;
    protected int cx = 250;
    protected int cy = 250;
    protected Color iColor = Color.red;


    protected abstract void draw (Graphics g);
    protected abstract void draw (Console c);


    protected void delay (int iDelayTime)
    {
	long lFinalTime = System.currentTimeMillis () + iDelayTime;
	do
	{
	}


	while (lFinalTime >= System.currentTimeMillis ());
    }


    protected void setCentre (int x, int y)
    {
	cx = x;
	cy = y;
    }


    protected void erase (Graphics g)
    {
	Color temp = iColor;
	iColor = Color.white;
	draw (g);
	iColor = temp;
    }



    protected void setColor (Color cColor)
    {

	iColor = cColor;
    }


    protected void setWidth (int iNewWidth)
    {
	width = iNewWidth;
    }


    protected void setHeight (int iNewHeight)
    {
	height = iNewHeight;
    }


    protected int getCenterX ()
    {
	return cx;
    }


    protected int getCenterY ()
    {
	return cy;
    }


    public void setIsFilled (boolean newfilled)
    {
	filled = newfilled;
    }


    public boolean getIsFilled ()
    {
	return filled;
    }


    protected boolean isPointInside (int x, int y)

    {

	if (x < (cx + width / 2) && x > (cx - width / 2) && y > (cy - height / 2) && y < (cy + height / 2))
	{

	    return true;

	}

	return false;
    }
    
     protected boolean isPointInsideCircle (int x, int y)

    {

	if (x < (cx + width / 2) && x > (cx - width / 2) && y > (cy - height / 2) && y < (cy + height / 2))
	{

	    return true;

	}

	return false;
    }
}
