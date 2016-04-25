// The AI Class
// Implements Vectors and Array lists
// Acts as a human player
// have to make sure to run PICK BEST HAND TO GET A RANKING VALUE
import hsa.Console;
import java.awt.*;
import java.util.*;

public class AIClass
{
    //Encapsulated Data
    protected int ranking = 1;

    public int randomNumber (int min, int max)
    {
	int range = (max - min) + 1;
	return (int) (Math.random () * range) + min;
    }


    public void setRanking (int[] pBestHand)
    {
	ranking = pBestHand [0];
    }


    public int Move (int playernum, int nCurrentBet, int[] nPlayerMoney)
    {
	// 1 = fold
	// 2 = call
	// 3 = bet/raise
	int RNGESUS = randomNumber (1, 100);
	int RNGRyanVansickle = randomNumber (1, 100);
	//Commemorating Ryan V of Markville SS, 2013-2017 "the second coming of our lord and savior"

	if (ranking == 9)
	{
	    RNGESUS = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (nPlayerMoney [playernum] > nCurrentBet)
	    {
		return 3;
	    }

	}
	if (ranking == 8)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 15)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 15)
	    {
		return 1;
	    }
	}
	if (ranking == 7)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 20)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 20)
	    {
		return 1;
	    }

	}
	if (ranking == 6)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 25)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 25)
	    {
		return 1;
	    }

	}
	if (ranking == 5)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 30)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 30)
	    {
		return 1;
	    }

	}
	if (ranking == 4)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 40)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 40)
	    {
		return 1;
	    }

	}
	if (ranking == 3)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 50)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 50)
	    {
		return 1;
	    }


	}
	if (ranking == 2)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 60)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 60)
	    {
		return 1;
	    }

	}
	if (ranking == 1)
	{
	    RNGESUS = randomNumber (1, 100);
	    RNGRyanVansickle = randomNumber (1, 100);
	    if (nCurrentBet > nPlayerMoney [playernum])
	    {
		return 1;
	    }
	    if (RNGESUS == 69)
	    {
		return 1;
	    }
	    if (RNGESUS > 80)
	    {
		if (RNGRyanVansickle % 2 == 0)
		{
		    return 2;
		}
		else
		{
		    return 3;
		}
	    }
	    if (RNGESUS < 80)
	    {
		return 1;
	    }
	}

	int tempN = randomNumber (1, 3);
	return tempN;
    }


    public int AIBetAmount (int playernum, int[] nPlayerMoney)
    {
	int RNgesus = randomNumber (1, 5);
	int finalBet = 0;

	if (ranking == 10)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum];
		return finalBet;

	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 50;
		return finalBet;

	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 40;
		return finalBet;

	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 30;
		return finalBet;

	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 20;
		return finalBet;

	    }

	}
	if (ranking == 9)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 40;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 30;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 20;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }

	}
	if (ranking == 8)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 30;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 20;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }

	}
	if (ranking == 7)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 20;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 15;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }

	}
	if (ranking == 6)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 20;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }

	}
	if (ranking == 5)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }

	}
	if (ranking == 4)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }

	}
	if (ranking == 3)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }

	}
	if (ranking == 2)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 10;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }

	}
	if (ranking == 1)
	{
	    RNgesus = randomNumber (1, 5);
	    if (RNgesus == 1)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 5;
		return finalBet;
	    }
	    else if (RNgesus == 2)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }
	    else if (RNgesus == 3)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }
	    else if (RNgesus == 4)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }
	    else if (RNgesus == 5)
	    {
		finalBet = nPlayerMoney [playernum] / 100 * 2;
		return finalBet;
	    }

	}
	int tempN = randomNumber (10, 100);
	return tempN;
    }
}


