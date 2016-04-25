import hsa.Console;
import java.awt.*;

public class HandEvaluator
{
    VectorDeckClass AIDeck = new VectorDeckClass (); // AIDeck consists of 2 cards dealt by dealer
    CardClass AIPotDeck[] = new CardClass [5];  // Potdeck has the 5 community cards
    public CardClass globalHand[] = new CardClass [7];
    // Get all Values
    int[] AIValue = new int [7];
    // Get all Suits
    int[] AISuit = new int [7];

    HandEvaluator ()
    {

	for (int i = 0 ; i < 7 ; i++)
	{
	    globalHand [i] = new CardClass ();
	}

	for (int i = 0 ; i < 7 ; i++)
	{
	    AIValue [i] = 0;
	}

	for (int i = 0 ; i < 7 ; i++)
	{
	    AISuit [i] = 0;
	}
    }


    public void setAIDeck (VectorDeckClass nAIDeck)
    {
	AIDeck = nAIDeck;
    }


    public void setAIPotDeck (CardClass nCard, int position)
    {
	AIPotDeck [position] = nCard;
    }


    public void setCards ()
    {

	// Dealt Cards
	for (int i = 0 ; i < 2 ; i++)
	{
	    globalHand [i] = AIDeck.dealCard (i);
	    // Store in Array
	    AISuit [i] = globalHand [i].getSuit ();
	    AIValue [i] = globalHand [i].getValue ();
	}

	for (int j = 0 ; j < 5 ; j++)
	{
	    globalHand [(j + 2)] = AIPotDeck [j];
	    // Store in Array
	    AISuit [(j + 2)] = globalHand [(j + 2)].getSuit ();
	    AIValue [(j + 2)] = globalHand [(j + 2)].getValue ();
	}

    }


    //OK
    public int[] Hand (int Combination)
    {
	int HandValue[] = new int [10];
	CardClass currentHand[] = new CardClass [5]; // 5 taken from the 7 in the globalhand array
	int[] currentHandValue = new int [14]; // 1 for Ace, 0 always empty, increment by 1 everytime a card appears
	int sameCards = 1; // to record how many of the cards are of the same value
	int sameCards2 = 1; // to record how many of the cards are of the same value
	int largeGroupValue = 0; // to hold the value of the largest pair that is found
	int smallGroupValue = 0; // to hold the value of the smaller pair that is found
	int index = 0;
	int topStraightValue = 0; // Value of straight is calculated from the topmost card
	boolean isFlush = true; // Assume there is a flush until proven otherwise
	boolean isStraight = false; //Flag for striaghts
	//int HandValue[] = new int [6];
	int orderedValues[] = new int [6];


	//FILL THE HAND WITH A SPECIFIC COMBO
	//ALL COMBOS
	// 12345
	// 13456
	// 14567
	// 23456
	// 24567
	// 34567
	//12456
	//12567
	//12356
	//12367
	//23567

	if (Combination == 1) //12345
	{
	    for (int i = 0 ; i < 5 ; i++)
	    {
		currentHand [i] = globalHand [i]; //fill up cards array with cards from global
	    }
	}
	if (Combination == 2) //23456
	{
	    for (int i = 1 ; i < 6 ; i++)
	    {
		currentHand [i - 1] = globalHand [i]; //fill up cards array with cards from global
	    }
	}
	if (Combination == 3) //34567
	{
	    for (int i = 2 ; i < 7 ; i++)
	    {
		currentHand [i - 2] = globalHand [i]; //fill up cards array with cards from global
	    }
	}
	if (Combination == 4) //13456
	{
	    currentHand [0] = globalHand [0];

	    for (int i = 2 ; i < 6 ; i++)
	    {
		currentHand [i - 1] = globalHand [i]; //fill up cards array with cards from global
	    }
	}
	if (Combination == 5) //14567
	{
	    currentHand [0] = globalHand [0];

	    for (int i = 3 ; i < 7 ; i++)
	    {
		currentHand [i - 2] = globalHand [i]; //fill up cards array with cards from global
	    }
	}
	if (Combination == 6) //24567
	{

	    currentHand [0] = globalHand [1];

	    for (int i = 3 ; i < 7 ; i++)
	    {
		currentHand [i - 2] = globalHand [i]; //fill up cards array with cards from global
	    }
	}
	if (Combination == 7) //12456
	{
	    currentHand [0] = globalHand [0];
	    currentHand [1] = globalHand [1];
	    for (int i = 3 ; i < 6 ; i++)
	    {
		currentHand [i - 1] = globalHand [i]; //fill up cards array with cards from global
	    }
	}
	if (Combination == 8)   //12567
	{
	    currentHand [0] = globalHand [0];
	    currentHand [1] = globalHand [1];
	    for (int i = 4 ; i < 7 ; i++)
	    {
		currentHand [i - 2] = globalHand [i]; //fill up cards array with cards from global
	    }
	}

	if (Combination == 9) //12356
	{
	    currentHand [0] = globalHand [0];
	    currentHand [1] = globalHand [1];
	    currentHand [2] = globalHand [2];
	    currentHand [3] = globalHand [4];
	    currentHand [4] = globalHand [5];
	}

	if (Combination == 10)  //12367
	{
	    currentHand [0] = globalHand [0];
	    currentHand [1] = globalHand [1];
	    currentHand [2] = globalHand [2];
	    currentHand [3] = globalHand [5];
	    currentHand [4] = globalHand [6];
	}

	if (Combination == 11)    //23567
	{
	    currentHand [0] = globalHand [1];
	    currentHand [1] = globalHand [2];
	    currentHand [2] = globalHand [4];
	    currentHand [3] = globalHand [5];
	    currentHand [4] = globalHand [6];
	}

	//Array of 13 values to count the number of occurances

	for (int i = 0 ; i <= 13 ; i++)
	{
	    currentHandValue [i] = 0;
	}

	for (int i = 0 ; i <= 4 ; i++)
	{
	    currentHandValue [currentHand [i].getValue ()]++;
	}

	//===============CHECK FOR POKER HANDS HERE

	//Confirm that there is a flush
	for (int i = 0 ; i < 4 ; i++)
	{
	    if (currentHand [i].getSuit () != currentHand [i + 1].getSuit ())
	    {
		isFlush = false;
	    }
	}

	//Check for doubles, triples and quads

	for (int i = 13 ; i >= 1 ; i--) //Loop startng at 13 (king) to 1 (Ace)
	{
	    if (currentHandValue [i] > sameCards)
	    {
		if (sameCards != 1) // if sameCards's default value has changed
		{
		    sameCards2 = sameCards;
		    smallGroupValue = largeGroupValue;
		}

		sameCards = currentHandValue [i];
		largeGroupValue = i;
	    }
	    else if (currentHandValue [i] > sameCards2)
	    {
		sameCards2 = currentHandValue [i];
		smallGroupValue = i;
	    }

	}

	if (currentHandValue [1] == 1)
	{
	    orderedValues [index] = 14;
	    index++;
	}

	for (int i = 13 ; i >= 2 ; i--)
	{
	    if (currentHandValue [i] == 1)
	    {
		orderedValues [index] = i; //if ace
		index++;
	    }
	}

	//Figure out if there is a straight



	for (int i = 1 ; i <= 9 ; i++)
	{
	    if (currentHandValue [i] == 1 &&
		    currentHandValue [i + 1] == 1 &&
		    currentHandValue [i + 2] == 1 &&
		    currentHandValue [i + 3] == 1 &&
		    currentHandValue [i + 4] == 1)
	    {
		isStraight = true;
		topStraightValue = i + 4;
		break;
	    }
	}

	// Special case for 10, Jack, Queen, King, Ace

	if (currentHandValue [10] == 1 &&
		currentHandValue [11] == 1 &&
		currentHandValue [12] == 1 &&
		currentHandValue [13] == 1 &&
		currentHandValue [1] == 1)
	{
	    isStraight = true;
	    topStraightValue = 14; //ranked higher than king
	}

	//===================Rank Hands=============================


	if (currentHandValue [1] == 1) //if ace, run this before because ace is highest card
	{
	    //record an ace as 14 instead of one, as its the highest card
	    orderedValues [index] = 14;
	    index++; //increment position
	}

	for (int i = 13 ; i >= 2 ; i--)
	{
	    if (currentHandValue [i] == 1)
		//we have already written code to handle the case
		//of their being two cards of the same rank
		{
		    // orderedVes [index] = i;
		    index++;
		}
	}

	// currentHandValue
	for (int i = 0 ; i <= 5 ; i++)
	{
	    HandValue [i] = 0;
	}


	//START HAND EVALUATION

	if (sameCards == 1)
	{ //if we have no pair...
	    HandValue [0] = 1;       //this is the lowest type of hand, so it gets the lowest value
	    HandValue [1] = orderedValues [0]; //the first determining factor is the highest card,
	    HandValue [2] = orderedValues [1]; //then the next highest card,
	    HandValue [3] = orderedValues [2]; //and so on
	    HandValue [4] = orderedValues [3];
	    HandValue [5] = orderedValues [4];
	}

	if (sameCards == 2 && sameCards2 == 1) //if 1 pair
	{
	    HandValue [0] = 2;             //pair ranked higher than high card
	    HandValue [1] = largeGroupValue; //rank of pair
	    HandValue [2] = orderedValues [0]; //next highest cards.
	    HandValue [3] = orderedValues [1];
	    HandValue [4] = orderedValues [2];
	}

	if (sameCards == 2 && sameCards2 == 2) //two pair
	{
	    HandValue [0] = 3;
	    //rank of greater pair
	    HandValue [1] = largeGroupValue > smallGroupValue ? largeGroupValue:
	    smallGroupValue;
	    //rank of smaller pair
	    HandValue [2] = largeGroupValue < smallGroupValue ? largeGroupValue:
	    smallGroupValue;
	    HandValue [3] = orderedValues [0]; //extra card
	}

	if (sameCards == 3 && sameCards2 != 2)
	    //three of a kind (not full house)
	    {
		HandValue [0] = 4;
		HandValue [1] = largeGroupValue;
		HandValue [2] = orderedValues [0];
		HandValue [3] = orderedValues [1];
	    }

	if (isStraight == true)
	{
	    HandValue [0] = 5;
	    HandValue [1] = topStraightValue;
	    //if we have two straights,
	    //the one with the highest top cards wins
	}

	if (isFlush == true)
	{
	    HandValue [0] = 6;
	    HandValue [1] = orderedValues [0]; //tie determined by ranks of cards
	    HandValue [2] = orderedValues [1];
	    HandValue [3] = orderedValues [2];
	    HandValue [4] = orderedValues [3];
	    HandValue [5] = orderedValues [4];
	}

	if (sameCards == 3 && sameCards2 == 2) //full house
	{
	    HandValue [0] = 7;
	    HandValue [1] = largeGroupValue;
	    HandValue [2] = smallGroupValue;
	}

	if (sameCards == 4) //four of a kind
	{
	    HandValue [0] = 8;
	    HandValue [1] = largeGroupValue;
	    HandValue [2] = orderedValues [0];

	}

	if (isFlush == true && isFlush == true)  //straight flush
	{
	    HandValue [0] = 9;
	    HandValue [1] = orderedValues [0];
	    HandValue [2] = orderedValues [1];
	    HandValue [3] = orderedValues [2];
	    HandValue [4] = orderedValues [3];
	    HandValue [5] = orderedValues [4];
	}

	return HandValue;

    }
}
