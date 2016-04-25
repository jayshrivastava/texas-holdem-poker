// The "HomeScreenApplet" class.
import java.awt.*;
import java.applet.*;
import java.awt.Image;

public class HomeScreenApplet extends Applet
{

    //Variables

    // A Button to click
    Button bSinglePlayer;
    Button bMultiPlayer;
    
    // A textField to get text input
    TextField moneyField;
    int startMoney; // Stores the amount of starting cash
    // A group of radio buttons
    // necessary to only allow one radio button to be selected at the same time.
    CheckboxGroup radioGroup;
    // The radio buttons to be selected
    Checkbox radio1;
    Checkbox radio2;
    // An independant selection box
    Checkbox option;

    //Background image
    Image background;
    
  
    
    Graphics g;

    public void init ()
    {
	// Tell the applet not to use a layout manager.
	setLayout (null);
	// initialze the button and give it a text.
	bSinglePlayer = new Button ("Single Player");
	bMultiPlayer = new Button ("Multi Player");
	// text and length of the field
	moneyField = new TextField ("Starting Cash", 10);
	// initialize the radio buttons group
	radioGroup = new CheckboxGroup ();
	// first radio button. Gives the label text, tells to which
	// group it belongs and sets the default state (unselected)
	radio1 = new Checkbox ("Radio1", radioGroup, false);
	// same but selected
	radio2 = new Checkbox ("Radio2", radioGroup, true);
	// Label and state of the checkbox
	option = new Checkbox ("Option", false);


	bSinglePlayer.setBounds (20, 20, 100, 30);
	bMultiPlayer.setBounds (20,220, 100, 30);
	moneyField.setBounds (20, 70, 100, 40);
	radio1.setBounds (20, 120, 100, 30);
	radio2.setBounds (140, 120, 100, 30);
	option.setBounds (20, 170, 100, 30);


	add (bSinglePlayer);
	add (bMultiPlayer);
	add (moneyField);
	add (radio1);
	add (radio2);
	add (option);

	background = getImage (getDocumentBase(), "IntroScreenBackground.jpg");

    }


    public void paint (Graphics g)
    {
	g.drawImage (background, 0, 0, this);
    }
}



