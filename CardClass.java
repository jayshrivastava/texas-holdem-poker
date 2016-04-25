import hsa.Console;
import java.awt.*;

class CardClass extends ShapeClass

{
    int value = 2;
    // int size = 3;
    int suit = 1;
    boolean isUp = true;

    CardClass ()
    {
	width = 80;
	height = 100;
    }


    CardClass (int w, int h)
    {
	width = w;
	height = h;
    }





    CardClass (String s, int su, int v)
    {
	value = v;
	suit = su;
    }


    CardClass (int su, int v, int h, int x, int y)
    {
	value = v;
	suit = su;
	setSize (h);
	cx = x;
	cy = y;
    }


    CardClass (int su, int v, int h, int x, int y, char s)
    {
	value = v;
	suit = su;
	setSize (h);
	cx = x;
	cy = y;
	isUp = false;
    }




    public void draw (Graphics g)
    {



	if (isUp == true)
	{

	    g.setColor (Color.white);
	    g.fillRect (cx - width / 2, cy - height / 2, width, height);
	    g.setColor (this.iColor);

	    if (iColor == Color.white)
	    {
	    }
	    else
	    {
		if (suit % 2 == 0)
		{
		    setColor (Color.black);
		}
		else
		{
		    setColor (Color.red);
		}
	    }


	    Font f1 = new Font ("SanSerif", Font.PLAIN, 20);


	    if (value == 1)
	    {
		g.setFont (f1);
		g.drawString ("A", cx - width / 4, cy - width / 4);
	    }
	    else if (value == 11)
	    {
		g.setFont (f1);
		g.drawString ("J", cx - width / 4, cy - width / 4);
	    }
	    else if (value == 13)
	    {
		g.setFont (f1);
		g.drawString ("K", cx - width / 4, cy - width / 4);
	    }
	    else if (value == 12)
	    {
		g.setFont (f1);
		g.drawString ("Q", cx - width / 4, cy - width / 4);
	    }
	    else
	    {
		g.setFont (f1);
		g.drawString (Integer.toString (value), cx - width / 4, cy - width / 4);
	    }


	    g.drawRect (cx - width / 2, cy - height / 2, width, height);

	    if (suit == 1)
	    {
		DiamondClass D1 = new DiamondClass (height / 5);
		D1.setCentre (cx, cy);
		D1.setColor (iColor);
		D1.draw (g);
	    }
	    else if (suit == 2)
	    {
		ClubClass C1 = new ClubClass (height / 5);
		C1.setCentre (cx, cy);
		C1.setColor (iColor);
		C1.draw (g);
	    }
	    else if (suit == 3)
	    {
		HeartClass H1 = new HeartClass (height / 5);
		H1.setCentre (cx, cy);
		H1.setColor (iColor);
		H1.draw (g);
	    }
	    else if (suit == 4)
	    {
		SpadeClass S1 = new SpadeClass (height / 5);
		S1.setCentre (cx, cy);
		S1.setColor (iColor);
		S1.draw (g);
	    }

	}
	else
	{
	    Color temp = iColor;
	    g.setColor (Color.red);
	    g.fillRect (cx - width / 2, cy - height / 2, width, height);
	    iColor = temp;
	}


    }


    public void draw (Console c)
    {

	if (isUp == true)
	{

	    if (iColor == Color.white)
	    {
	    }
	    else
	    {
		if (suit % 2 == 0)
		{
		    setColor (Color.black);
		}
		else
		{
		    setColor (Color.red);
		}
	    }

	    c.setColor (iColor);

	    Font f1 = new Font ("SanSerif", Font.PLAIN, 20);


	    if (value == 1)
	    {
		c.setFont (f1);
		c.drawString ("A", cx - width / 4, cy - width / 4);
	    }
	    else if (value == 11)
	    {
		c.setFont (f1);
		c.drawString ("J", cx - width / 4, cy - width / 4);
	    }
	    else if (value == 13)
	    {
		c.setFont (f1);
		c.drawString ("K", cx - width / 4, cy - width / 4);
	    }
	    else if (value == 12)
	    {
		c.setFont (f1);
		c.drawString ("Q", cx - width / 4, cy - width / 4);
	    }
	    else
	    {
		c.setFont (f1);
		c.drawString (Integer.toString (value), cx - width / 4, cy - width / 4);
	    }


	    c.drawRect (cx - width / 2, cy - height / 2, width, height);

	    if (suit == 1)
	    {
		DiamondClass D1 = new DiamondClass (height / 5);
		D1.setCentre (cx, cy);
		D1.setColor (iColor);
		D1.draw (c);
	    }
	    else if (suit == 2)
	    {
		ClubClass C1 = new ClubClass (height / 5);
		C1.setCentre (cx, cy);
		C1.setColor (iColor);
		C1.draw (c);
	    }
	    else if (suit == 3)
	    {
		HeartClass H1 = new HeartClass (height / 5);
		H1.setCentre (cx, cy);
		H1.setColor (iColor);
		H1.draw (c);
	    }
	    else if (suit == 4)
	    {
		SpadeClass S1 = new SpadeClass (height / 5);
		S1.setCentre (cx, cy);
		S1.setColor (iColor);
		S1.draw (c);
	    }

	}
	else
	{
	    c.setColor (Color.red);
	    c.fillRect (cx - width / 2, cy - height / 2, width, height);

	}


    }


    public void setisUp (boolean uperino)
    {
	isUp = uperino;
    }


    public void setValue (int uperino)
    {
	value = uperino;
    }


    public void setSuit (int uperino)
    {
	suit = uperino;
    }


    protected void setHeight (int h)
    {
	height = h;
	width = h / 5 * 4;
    }


    protected void setWidth (int w)
    {
	width = w;
	height = w * 5 / 4;
    }


    public int getSuit ()
    {
	return suit;
    }


    public int getValue ()
    {
	return value;
    }


    public void setSize (int uperino)
    {
	if (uperino > 150)
	{
	    setHeight (200);
	}
	else if (uperino > 100)
	{
	    setHeight (150);
	}

	else if (uperino < 100)
	{
	    setHeight (60);
	}

    }
}
