// Texas Holdem Applet v 0.2
// Proposed Patches for v 0.3
// - Fully implement AIClass
// - Stop numbers from flickering
// - Show which stage the round is at : river, flop etc.
// - Show exactly who won the pot
// - Implement Music
// - Give Ability to look at AI Cards to see who really won the pot
// - Title Text
// - FIX WHAT HAPPENS WHEN YOU LOSE
// Developers:
// Jay Shrivastava
// Hanshen Wang

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//MAIN IS AT THE BOTTOM

public class TexasHoldemApplet extends Applet implements ActionListener, MouseListener, MouseMotionListener
{

    // =========================GAME VARS (gamevars)=========================

    //Integers
    public int Jackpot = 0; //Total sum of all bets made in a round
    public int CurrentBet = 0; //Raises must be higher than the current bet
    public int PlayerBet = 0; //Player raise amount
    public int currentPlayer = 0; //currentPlayer move
    public int NumberofPlayers = 10;
    //Arrays
    VectorDeckClass PlayingDeck = new VectorDeckClass ('s', 450, 400);
    VectorDeckClass[] PlayerHands = new VectorDeckClass [NumberofPlayers];  // This holds the 2 cards dealt to the player
    AIClass[] AI = new AIClass [NumberofPlayers];  // Temporary Hardcode
    CardClass PotDeck[] = new CardClass [5]; // this is the array of community cards
    public int[] PlayerMoney = new int [NumberofPlayers]; //tracks the money that each player has
    public int[] PlayerBets = new int [NumberofPlayers];
    //OBJECTS VARS
    GameBoardClass G = new GameBoardClass ();
    ChipClass PotChip = new ChipClass (200, 365, 65, 65, Jackpot);
    ChipClass PlayerMoneyChip;
    ChipClass PlayerCallandBetChip;
    //Boolean
    boolean gameActive = true; //IMPORTANT FLAG FOR START AND ENDGAME
    boolean[] PlayerBlinds = new boolean [NumberofPlayers];
    boolean[] PlayersFolded = new boolean [NumberofPlayers];
    boolean[] PlayersInGame = new boolean [NumberofPlayers];
    boolean[] PlayersCalled = new boolean [NumberofPlayers];
    boolean[] CardsClicked = new boolean [NumberofPlayers];
    boolean drawFlag = true;
    boolean OKtoMove = false;
    boolean river = false;
    boolean flop = false;
    boolean turn = false;
    boolean gamereset = true;
    boolean playerMoved = false;
    boolean areCallsEven = true;
    boolean beingMoved = false;
    boolean showAIHands = false;

    TextField PlayerBetAmount = new TextField (10);
    TextArea answers = new TextArea (
	    "Enter Bet Amount",
	    8,
	    60,
	    TextArea.SCROLLBARS_NONE
	    );
    //Background image
    Image background;


    //Music vars
    AudioClip backgroundMusic;


    // =========================CLICK TO REVEAL CARDS VARS=========================

    // The X-coordinate and Y-coordinate of the last click.
    int xpos;
    int ypos;
    // Stores the x and y center of Player and AI cards
    int CardLocationsX[] = new int [NumberofPlayers];
    int CardLocationsY[] = new int [NumberofPlayers];

    // Stores the x and y center of Player and AI chips
    int ChipLocationsX[] = new int [NumberofPlayers];
    int ChipLocationsY[] = new int [NumberofPlayers];

    int playerCardClicked = 0;
    int CardWidth = 52;
    int CardHeight = 65;

    boolean mouseEntered;
    boolean cardClicked;

    // =========================POKER HAND RANKINGS VARS=========================

    //Stores the type of hand in the first int, and the ordered values in the rest
    int HandValue1[] = new int [6];
    int HandValue2[] = new int [6];
    //The best possible hand that the player can have
    int BestHandPlayer0[] = new int [6];
    int BestHandPlayer1[] = new int [6];
    int BestHandPlayer2[] = new int [6];
    int BestHandPlayer3[] = new int [6];
    int BestHandPlayer4[] = new int [6];
    int BestHandPlayer5[] = new int [6];
    int BestHandPlayer6[] = new int [6];
    int BestHandPlayer7[] = new int [6];
    int BestHandPlayer8[] = new int [6];
    int BestHandPlayer9[] = new int [6];
    int[] [] BestPlayerHands = new int[] []
    {
	BestHandPlayer0, BestHandPlayer1, BestHandPlayer2, BestHandPlayer3,
	    BestHandPlayer4, BestHandPlayer5, BestHandPlayer6, BestHandPlayer7,
	    BestHandPlayer8, BestHandPlayer9
    }


    ;


    Graphics g;   // declares a graphics canvas for drawing

    // =========================APPLET BUTTON VARS=========================
    Button buttonFold = new Button ("Fold");
    Button buttonCall = new Button ("Call/Check");
    Button buttonBet = new Button ("Bet/Raise");
    Button buttonReset = new Button ("Quit Game");
    Button buttonReveal = new Button ("Reveal AI Cards");
    GridBagLayout lm = new GridBagLayout ();
    GridBagConstraints gbc = new GridBagConstraints ();
    Panel pde = new Panel ();


    // =========================GAME METHODS (gamemethods)=========================


    public void startGame ()
    {
    }


    int betText (String s)
    {
	int answer;

	if (s == "")
	{
	    return 0;
	}
	else
	{
	    answer = Integer.parseInt (s);
	}
	return answer;
    }


    // =========================PLAYER METHODS (playermethods)=========================

    public void setNumberofPlayers (int n)
    {
	if (n < 11)
	{
	    NumberofPlayers = n;
	}
    }


    // =========================CARD METHODS (cardmethods)=========================

    public void dealCards ()
    {

	for (int i = 0 ; i < NumberofPlayers ; i++)
	{
	    for (int j = 0 ; j < 2 ; j++)
	    {
		CardClass C = new CardClass ();
		C = PlayingDeck.dealCard (0);
		PlayingDeck.deleteCard (0);

		if (PlayersInGame [i] == true)
		{

		    PlayerHands [i].addCard (C, j);


		    if (i == 0)
		    {
			C.setisUp (true);
		    }

		    if (j == 0)
		    {

			C.setCentre (CardLocationsX [i], CardLocationsY [i]);
		    }
		    else
		    {

			if (i == 0)
			{
			    C.setCentre (CardLocationsX [i] + 55, CardLocationsY [i] + 5);
			}
			else
			{
			    C.setCentre (CardLocationsX [i] + 5, CardLocationsY [i] + 5);
			}
		    }
		}
	    }
	}
    }


    public void drawDealtCards ()
    {

	for (int i = 0 ; i < NumberofPlayers ; i++)
	{

	    for (int j = 0 ; j < 2 ; j++)
	    {

		CardClass C = new CardClass ();
		C = PlayerHands [i].dealCard (j);
		if (showAIHands == false)
		{
		    C.setisUp (false);
		}
		else
		{
		    C.setisUp (true);
		}

		if (PlayersInGame [i] == true)
		{

		    if (PlayersFolded [i] == false)
		    {

			if (cardClicked == true && i == playerCardClicked)
			{
			    C.setisUp (true);
			}

			if (j == 0)
			{

			    C.setCentre (CardLocationsX [i], CardLocationsY [i]);
			}
			else
			{

			    if (i == 0)
			    {
				C.setCentre (CardLocationsX [i] + 55, CardLocationsY [i] + 5);
			    }
			    else
			    {
				C.setCentre (CardLocationsX [i] + 35, CardLocationsY [i] + 5);
			    }
			}
			C.draw (g);

		    }
		}

	    }
	}
    }


    public void setCardLocation (int cardNum, int newX, int newY)
    {
	CardLocationsX [cardNum] = newX;
	CardLocationsY [cardNum] = newY;
    }


    public void setAIChipLocations (int player, int newX, int newY)
    {
	ChipLocationsX [player] = newX;
	ChipLocationsY [player] = newY;
    }


    public void setPotDeck ()
    {
	CardClass C = new CardClass ();
	for (int i = 0 ; i < 5 ; i++)
	{
	    C = PlayingDeck.dealCard (0);
	    PotDeck [i] = C;
	}
    }


    public void setCommunityCards (String s)
    {

	int startX = 340;
	CardClass C = new CardClass ();
	if (s == "flop")
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {
		C = PlayingDeck.dealCard (0);
		PlayingDeck.deleteCard (0);
		PotDeck [i] = C;

		C.setisUp (true);
		if (i == 0)
		{
		    C.setCentre (startX, 400);
		}
		if (i == 1)
		{
		    C.setCentre (startX + 85, 400);
		}
		if (i == 2)
		{
		    C.setCentre (startX + 170, 400);
		}

		C.draw (g);
	    }

	    flop = true;
	}


	if (s == "turn")
	{

	    C = PlayingDeck.dealCard (0);
	    PlayingDeck.deleteCard (0);
	    PotDeck [3] = C;

	    C.setisUp (true);

	    C.setCentre (startX + 3 * 85, 400);

	    C.draw (g);
	    turn = true;
	}


	if (s == "river")
	{
	    C = PlayingDeck.dealCard (0);
	    PlayingDeck.deleteCard (0);
	    PotDeck [4] = C;

	    C.setisUp (true);

	    C.setCentre (startX + 4 * 85, 400);

	    C.draw (g);
	    river = true;
	}
    }


    public void displayCommunityCards ()
    {

	int startX = 340;
	CardClass C = new CardClass ();
	if (flop == true)
	{
	    for (int i = 0 ; i < 3 ; i++)
	    {

		C = PotDeck [i];
		C.draw (g);
	    }
	}


	if (turn == true)
	{


	    C = PotDeck [3];
	    C.draw (g);
	}


	if (river == true)
	{




	    C = PotDeck [4];
	    C.draw (g);
	}
    }


    public void drawChips ()
    {

	PotChip.setChipValue (Jackpot);
	PotChip.draw (g);
	PlayerMoneyChip.setChipValue (PlayerMoney [0]);
	if (beingMoved == false)
	{
	    PlayerCallandBetChip.setCentre (1024 / 2 + 55, 550);
	}


	PlayerMoneyChip.draw (g);

	if (PlayersFolded [0] == false)
	{

	    PlayerCallandBetChip.setChipValue (PlayerBet);

	}

	PlayerCallandBetChip.draw (g);


	ChipClass C1 = new ChipClass (40, 40);
	for (int i = 1 ; i < NumberofPlayers ; i++)
	{

	    if (PlayersInGame [0] == true)
	    {

		C1.setChipValue (PlayerMoney [i]);
		C1.setCentre (ChipLocationsX [i], ChipLocationsY [i]);
		C1.draw (g);

	    }
	}
    }


    // =========================RESETS(resets)=========================

    public void resetGame ()
    {
	PlayingDeck.reconstruct ();
	PlayingDeck.setCentre (150, 400);
	//Reset
	resetBet ();
	resetRiver ();
	resetDealtCards ();
	resetFolded ();
	resetDeck ();
	CurrentBet = 0;
	Jackpot = 0;
	setCallsEven (false);
	dealCards ();
	setFalse ();

	//array initializations
	for (int k = 0 ; k < NumberofPlayers ; k++)
	{
	    PlayerHands [k] = new VectorDeckClass ();
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayerBlinds [n] = false;
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayerBets [n] = 0;
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayerMoney [n] = 10000;
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayersCalled [n] = false;

	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayersFolded [n] = false;

	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayersInGame [n] = true;

	}


	for (int n = 1 ; n < NumberofPlayers ; n++)
	{
	    AI [n] = new AIClass ();

	}

	for (int i = 0 ; i < 6 ; i++)
	{
	    HandValue1 [i] = 0;
	}

	for (int i = 0 ; i < 6 ; i++)
	{
	    HandValue2 [i] = 0;

	}

    }


    public void resetBet ()
    {
	CurrentBet = 0;
	PlayerBet = 0;
    }


    public void setFalse ()
    {
	river = false;
	flop = false;
	turn = false;
    }


    public void resetDeck ()
    {
	PlayingDeck.reconstruct ();
	PlayingDeck.shuffle ();
    }


    public void resetFolded ()
    {
	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayersFolded [n] = false;

	}
    }


    public void resetRiver ()
    {
	CardClass C = new CardClass ();
	C.setisUp (false);
	for (int i = 0 ; i < 5 ; i++)
	{
	    PotDeck [i] = C;
	}
    }


    public void resetDealtCards ()
    {
	for (int i = 0 ; i < NumberofPlayers ; i++)
	{
	    PlayerHands [i].clearDeck ();
	}
    }



    // =========================BUTTON METHODS(buttonmethods)=========================
    public void turnOver ()
    {
	showAIHands = false;
	drawDealtCards ();
    }


    public void Fold (int PlayerNumber)
    {

	PlayersFolded [PlayerNumber] = true;

    }


    public void Call (int PlayerNumber)
    {
	PlayerMoney [PlayerNumber] = PlayerMoney [PlayerNumber] - CurrentBet;
	Jackpot = Jackpot + CurrentBet;
	PlayersCalled [PlayerNumber] = true;
    }


    public void BetRaise (int PlayerNumber, int bet)
    {

	PlayerMoney [PlayerNumber] = PlayerMoney [PlayerNumber] - bet;
	PlayerBet = bet;
	if (PlayerNumber == 0)
	{
	    PlayerBet = bet;

	    g.drawString ("Please Drag the betting chip", 50, 50);
	}
	else
	{
	    Jackpot = Jackpot + bet;
	}
	bet = bet - CurrentBet;
	CurrentBet += bet;

	drawChips ();
    }


    public void setCallsEven (boolean n)
    {
	areCallsEven = n;
    }


    public boolean checkCallsEven ()
    {
	return areCallsEven;
    }


    public void dealBlinds ()
    {
	//change the array of bets too
	setCallsEven (false);
    }


    public void deleteBrokePlayers ()
    {
	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    if (PlayerMoney [n] < 0)
	    {

		PlayersInGame [n] = false;
	    }
	}
    }


    public void cpusMove ()
    {
	int decision = 0;
	int AIbet = 0;
	for (int i = 1 ; i < NumberofPlayers ; i++)
	{

	    if (PlayersFolded [i] == false)
	    {
		AI [i].setRanking (BestPlayerHands [i]);
		decision = AI [i].Move (i, CurrentBet, PlayerMoney);
	    }


	    if (decision == 1)
	    {
		Fold (i);
	    }

	    if (decision == 2)
	    {
		Call (i);
	    }

	    if (decision == 3)
	    {
		AIbet = AI [i].AIBetAmount (i, PlayerMoney);
		BetRaise (i, AIbet);
	    }
	}
    }


    public void pickBestHand ()
    {
	for (int i = 0 ; i < NumberofPlayers ; i++)
	{

	    HandEvaluator HandE = new HandEvaluator ();
	    HandE.setAIDeck (PlayerHands [i]);
	    for (int q = 0 ; q < 5 ; q++)
	    {
		HandE.setAIPotDeck (PotDeck [q], q);
	    }
	    HandE.setCards ();


	    for (int j = 1 ; j < 12 ; j++)
	    {
		HandValue2 = HandE.Hand (j);

		if (CompareTo (HandValue1, HandValue2) == 1)
		{
		    HandValue1 = HandValue2;

		}

	    }

	    for (int k = 0 ; k < 6 ; k++)
	    {
		HandValue2 [k] = 0;

	    }

	    //Save Dem

	    BestPlayerHands [i] = HandValue1;

	}

	for (int i = 0 ; i < 6 ; i++)
	{
	    HandValue1 [i] = 0;
	}

	for (int i = 0 ; i < 6 ; i++)
	{
	    HandValue2 [i] = 0;

	}
    }


    public int CompareTo (int[] oldHandValue, int[] newHandValue)
    {
	for (int i = 0 ; i < 6 ; i++)
	{
	    if (newHandValue [i] > oldHandValue [i])
	    {
		return 1;
	    }
	    else if (newHandValue [i] != oldHandValue [i])
	    {
		return -1;
	    }
	}
	return 0; // if Hands are equal
    }


    public int pickWinner ()
    {
	int winner = BestPlayerHands [0] [0];
	pickBestHand ();
	for (int i = 0 ; i < 10 ; i++)
	{
	    for (int j = 1 + 1 ; j < 9 ; j++)
	    {
		if (CompareTo (BestPlayerHands [i], BestPlayerHands [j]) == 1)
		{
		    winner = j;
		}
	    }
	}

	return winner;
    }


    public boolean playerWins ()
    {
	for (int n = 1 ; n < NumberofPlayers ; n++)
	{
	    if (PlayersInGame [n] == false)
	    {
		return true;
	    }
	}


	return false;
    }


    public boolean playerLoses ()
    {

	if (PlayersInGame [0] == false)
	{
	    return true;
	}


	return false;

    }


    public void EndGame ()
    {

	if (playerWins ())
	{

	}


	if (playerLoses ())
	{

	}
    }


    public void drawDeck ()
    {

	PlayingDeck.setCentre (125, 400);
	PlayingDeck.setUp (false);
	PlayingDeck.drawTopCard (g);
    }


    public void mouseClicked (MouseEvent e)
    {
	// Save the coordinates of the click lke this.
	xpos = e.getX ();
	ypos = e.getY ();


	CardClass C = new CardClass ();
	C = PlayerHands [0].dealCard (0);
	if (C.isPointInside (e.getX (), e.getY ()) == true)
	{
	    PlayerHands [0].dealCard (0).setisUp (true);
	    cardClicked = true;

	}


	C = PlayerHands [0].dealCard (1);
	if (C.isPointInside (e.getX (), e.getY ()) == true)
	{
	    PlayerHands [0].dealCard (1).setisUp (true);
	    cardClicked = true;

	}


	else
	{
	    cardClicked = false;
	}


	repaint ();

    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
    }


    public void mousePressed (MouseEvent e)
    {
	if (PlayerCallandBetChip.isPointInside (e.getX (), e.getY ()) == true)
	{
	    OKtoMove = true;
	    PlayerCallandBetChip.setCentre (e.getX (), e.getY ());
	    PlayerCallandBetChip.draw (g);
	    repaint ();
	    beingMoved = true;
	}
    }


    public void mouseReleased (MouseEvent e)
    {
	OKtoMove = false;
	if (PotChip.isPointInside (e.getX (), e.getY ()) == true)
	{
	    Jackpot = Jackpot + PlayerBet;
	    beingMoved = false;
	    drawChips ();

	}
    }


    public void mouseDragged (MouseEvent e)
    {

	if (OKtoMove == true)
	{
	    PlayerCallandBetChip.setCentre (e.getX (), e.getY ());
	    PlayerCallandBetChip.draw (g);
	    repaint ();
	}
    }


    public void mouseMoved (MouseEvent e)
    {
    }


    // =========================INIT(init)=========================
    public void init ()
    {
	//BG
	background = getImage (getDocumentBase (), "BackgroundImage.jpg");
	backgroundMusic = getAudioClip (getDocumentBase (), "Witcher_3_Gwent_Soundtrack_3.mp3");

	PlayerCallandBetChip = new ChipClass (1024 / 2 + 55, 550, 30, 30, CurrentBet + PlayerBet);
	PlayerMoneyChip = new ChipClass (1024 / 2 - 20, 550, 30, 30, PlayerMoney [0]);
	g = getGraphics ();

	pde.setLayout (new BorderLayout ());

	//array initializations
	for (int k = 0 ; k < NumberofPlayers ; k++)
	{
	    PlayerHands [k] = new VectorDeckClass ();
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayerBlinds [n] = false;
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayerBets [n] = 0;
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayerMoney [n] = 10000;
	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayersCalled [n] = false;

	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayersFolded [n] = false;

	}


	for (int n = 0 ; n < NumberofPlayers ; n++)
	{
	    PlayersInGame [n] = true;

	}


	for (int n = 1 ; n < NumberofPlayers ; n++)
	{
	    AI [n] = new AIClass ();

	}

	for (int i = 0 ; i < 6 ; i++)
	{
	    HandValue1 [i] = 0;
	}

	for (int i = 0 ; i < 6 ; i++)
	{
	    HandValue2 [i] = 0;

	}

	//Set Card Locations

	setCardLocation (0, 1024 / 2, 510);
	setCardLocation (1, 1024 / 2 - 150, 510);
	setCardLocation (2, 1024 / 2 - 285, 510);
	setCardLocation (3, 1024 / 2 - 285, 270);
	setCardLocation (4, 1024 / 2 - 150, 270);
	setCardLocation (5, 1024 / 2, 270);
	setCardLocation (6, 1024 / 2 + 200, 270);
	setCardLocation (7, 1024 / 2 + 350, 340);
	setCardLocation (8, 1024 / 2 + 350, 480);
	setCardLocation (9, 1024 / 2 + 200, 510);

	//setAIChipLocations

	setAIChipLocations (1, 1024 / 2 - 150, 550);
	setAIChipLocations (2, 1024 / 2 - 285, 550);
	setAIChipLocations (3, 1024 / 2 - 285 + 60, 230);
	setAIChipLocations (4, 1024 / 2 - 150 + 60, 230);
	setAIChipLocations (5, 1024 / 2 + 60, 230);
	setAIChipLocations (6, 1024 / 2 + 200 + 60, 230);
	setAIChipLocations (7, 1024 / 2 + 350, 380);
	setAIChipLocations (8, 1024 / 2 + 320, 520);
	setAIChipLocations (9, 1024 / 2 + 200, 550);

	//Shuffle Deck
	PlayingDeck.shuffle ();
	dealCards ();

	this.setLayout (null);
	g = getGraphics (); // gets canvas created by browser-replaces new stmt

	this.add (this.buttonFold);

	this.add (this.buttonCall);

	this.add (this.buttonBet);

	this.add (this.buttonReset);

	this.add (this.buttonReveal);


	this.add (this.PlayerBetAmount);
	this.add (new Label ("Distance of trip in light years"));

	// A text area for printing the answers:
	answers.setEditable (false);
	add (answers);
	buttonFold.addActionListener (this);
	buttonCall.addActionListener (this);
	buttonBet.addActionListener (this); //This is why we lost half our hair
	buttonReset.addActionListener (this); //This is why we lost half our hair
	buttonReveal.addActionListener (this);
	addMouseListener (this);
	addMouseMotionListener (this);
    }


    // =========================PAINT(paint)=========================

    public void paint (Graphics g)
    {
	if (drawFlag == true)
	{
	    // Start Background Music
	    backgroundMusic.loop ();

	    // G.draw (g);
	    g.drawImage (background, 0, 0, this);

	    displayCommunityCards ();


	    if (flop == false && turn == false && river == false)
	    {
		g.drawImage (background, 0, 0, this);
	    }

	    drawDeck ();
	    drawDealtCards ();

	    drawDeck ();
	    drawDealtCards ();
	    drawChips ();

	    this.buttonCall.setLocation (775, 680);
	    this.buttonCall.setSize (75, 50);

	    this.buttonBet.setLocation (675, 680);
	    this.buttonBet.setSize (75, 50);

	    this.buttonFold.setLocation (575, 680);
	    this.buttonFold.setSize (75, 50);

	    this.buttonReveal.setLocation (450, 680);
	    this.buttonReveal.setSize (100, 50);



	    this.buttonReset.setLocation (900, 60);
	    this.buttonReset.setSize (75, 50);

	    this.PlayerBetAmount.setLocation (675, 740);
	    this.PlayerBetAmount.setSize (75, 20);

	    this.answers.setLocation (675, 780);
	    this.answers.setSize (75, 20);
	}
    }


    public void actionPerformed (ActionEvent e)

    {

	Object objSource = e.getSource ();

	int BetAmount = CurrentBet + 200;


	if (objSource == buttonCall)
	{
	    Call (currentPlayer);
	    playerMoved = true;
	    repaint ();
	}


	if (objSource == buttonBet)
	{
	    BetAmount = betText (PlayerBetAmount.getText ());

	    if (BetAmount <= 0 || BetAmount > PlayerMoney [0] || BetAmount <= CurrentBet)
	    {
		answers.setText ("Enter a proper amount");
		PlayerBetAmount.requestFocus ();
		PlayerBetAmount.selectAll ();
		return;
	    }


	    BetRaise (currentPlayer, BetAmount);

	    drawChips ();

	    playerMoved = true;
	    repaint ();

	}


	if (objSource == buttonFold)
	{
	    Fold (currentPlayer);
	    playerMoved = true;
	    repaint ();
	}

	if (objSource == buttonReveal)
	{
	    showAIHands = true;
	    drawDealtCards ();
	    repaint ();
	}


	if (objSource == buttonReset)
	{
	    System.exit (0);
	    // resetGame ();
	    // playerMoved = true;
	    // repaint ();
	}




    }


    public void start ()
    { //TEXAS HOLDEM GAME
	startGame ();

	while (gameActive)
	{
	    if (playerWins () || playerLoses ())
	    {
		EndGame ();
		break;
	    }

	    drawDeck ();
	    dealCards ();
	    dealBlinds ();
	    deleteBrokePlayers ();

	    setPotDeck ();
	    pickBestHand ();

	    while (checkCallsEven () == false)
	    {


		if (PlayersFolded [0] == false)
		{
		    playerMoved = false;
		    while (playerMoved == false) //wait for variable to be true
		    {

		    }
		}


		cpusMove (); //all cpus move
		setCallsEven (true);
	    }
	    turnOver ();
	    deleteBrokePlayers ();
	    resetFolded ();
	    setCommunityCards ("flop");


	    setCallsEven (false);

	    for (int x = 1 ; x < 3 ; x++) // 2 times
	    {

		while (checkCallsEven () == false)
		{

		    if (PlayersFolded [0] == false)
		    {
			playerMoved = false;
			while (playerMoved == false) //wait for variable to be true
			{

			}
		    }
		    cpusMove (); //all cpus move
		    setCallsEven (true);
		}

		turnOver ();

		deleteBrokePlayers ();

		if (x == 1)
		{

		    setCommunityCards ("turn");

		}

		else
		{

		    setCommunityCards ("river");

		}
		setCallsEven (false);
		resetBet ();
	    }

	    resetBet ();
	    setCallsEven (false);
	    while (checkCallsEven () == false)
	    {

		if (PlayersFolded [0] == false)
		{
		    playerMoved = false;
		    while (playerMoved == false) //wait for variable to be true
		    {

		    }
		}

		cpusMove (); //all cpus move
		setCallsEven (true);
	    }
	    turnOver ();

	    deleteBrokePlayers ();

	    PlayerMoney [pickWinner ()] = PlayerMoney [pickWinner ()] + Jackpot;

	    //Reset
	    resetBet ();
	    resetRiver ();
	    resetDealtCards ();
	    resetFolded ();
	    resetDeck ();
	    CurrentBet = 0;
	    Jackpot = 0;
	    setCallsEven (false);
	    dealCards ();
	    setFalse ();
	}
    }
}


