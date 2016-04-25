// The "DeckClass" class.

import java.util.*;
import java.awt.*;

public class VectorDeckClass
{
    int cx = 100;
    int cy = 200;

    // static Console c = new Console ();
    protected Vector deck = new Vector (0, 1);


    public VectorDeckClass ()
    {
    }


    public VectorDeckClass (char deckType, int x, int y)
    {

	cx = x;
	cy = y;
	if (deckType == 's') // std deck
	{
	    for (int i = 1 ; i < 5 ; i++)
	    {
		for (int j = 1 ; j < 14 ; j++)
		{
		    CardClass C = new CardClass (i, j, 40, cx, cy);
		    C.setisUp (false);
		    deck.insertElementAt (C, deck.size ());
		}
	    }
	}
    }


    public VectorDeckClass (int x, int y)
    {

	cx = x;
	cy = y;

    }


    public void addCard (CardClass cardToAdd, int Pos)
    {

	// cardToAdd.setCentre (this.cx, this.cy);

	CardClass C = new CardClass ();
	C = cardToAdd;

	if (Pos == 0 && deck.size () == 0)
	{
	    deck.addElement (cardToAdd);
	}
	else if (Pos > deck.size ())
	{
	    deck.insertElementAt (cardToAdd, deck.size ());
	}
	else
	{
	    deck.insertElementAt (cardToAdd, Pos);
	}
    }


    public void deleteCard (int Pos)
    {



	if (Pos == 0 || deck.size () == 0)
	{
	    deck.removeElementAt (0);
	}
	else if (Pos > deck.size ())
	{
	    deck.removeElementAt (0);
	}
	else
	{
	    deck.removeElementAt (Pos);
	}


    }


    public int getSize ()
    {

	return deck.size ();

    }



    public CardClass dealCard (int Pos)
    {


	if (Pos == 0 && deck.size () == 0)
	{
	    CardClass C = new CardClass (1, 1, 80, cx, cy, 's');

	    return C;
	}
	else
	{
	    CardClass C = new CardClass ();

	    C = (CardClass) deck.elementAt (Pos);

	    return C;
	}

    }


    public void shuffle ()
    {

	//
	// CardClass temp = new CardClass ();
	// int num = 0;
	//
	// CardClass Cards[] = new CardClass [deck.size ()];
	// for (int i = 1 ; i < deck.size () + 1 ; i++)
	// {
	//     Cards [i] = (CardClass) deck.elementAt (i - 1);
	//
	// }
	//
	// for (int i = 1 ; i < deck.size () + 1 ; i++)
	// {
	//     // shuffling
	//     temp = Cards [i];
	//     num = (int) (Math.random () * deck.size () + 1);
	//     Cards [i] = Cards [num];
	//     Cards [num] = temp;
	//
	// }
	//
	// deck.clear ();
	//
	// for (int i = 1 ; i < deck.size () + 1 ; i++)
	// {
	//
	//     addCard (Cards [i], i - 1);
	// }

	Collections.shuffle (deck);



    }
    
	public void reconstruct ()
    {

	deck.clear ();

	for (int i = 1 ; i < 5 ; i++)
	{
	    for (int j = 1 ; j < 14 ; j++)
	    {
		CardClass C = new CardClass (i, j, 40, cx, cy);
		C.setisUp (false);
		deck.insertElementAt (C, deck.size ());
	    }
	}

    }



    protected void setCentre (int x, int y)
    {
	cx = x;
	cy = y;

	for (int i = 0 ; i < deck.size () ; i++)
	{
	    CardClass C = new CardClass ();
	    C = (CardClass) deck.elementAt (i);
	    C.setCentre (cx, cy);
	    deck.removeElementAt (i);
	    deck.insertElementAt (C, i);
	}
    }


    protected void setUp (boolean uperino)
    {

	for (int i = 0 ; i < deck.size () ; i++)
	{
	    CardClass C = new CardClass ();
	    C = (CardClass) deck.elementAt (i);
	    C.setisUp (uperino);
	    deck.removeElementAt (i);
	    deck.insertElementAt (C, i);
	}
    }


    public void drawTopCard (Graphics g)
    {

	for (int i = 0 ; i < deck.size () ; i++)
	{
	    CardClass C = new CardClass ();
	    C = (CardClass) deck.elementAt (i);
	    C.draw (g);

	}
    }




    public void clearDeck ()
    {
	deck.clear ();
    }
}
