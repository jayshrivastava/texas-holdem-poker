// File: Voyage.java
// This applet is a small example to illustrate how to write an interactive 
// Applet. This particular applet gets some information about a long voyage
// on a relativistic rocket, and prints the time of the voyage and other data.
// -- Michael Main (main@colorado.edu)

//import edu.colorado.collections.IntArrayBag;
import java.applet.Applet;
import java.awt.*;          // Imports Button, Canvas, TextArea, TextField
import java.awt.event.*;    // Imports ActionEvent, ActionListener


public class Voyage extends Applet
{  
   // Applet components
   // These cannot be private because some browsers won't allow an inner
   // class to access private members.
   TextField distanceText           = new TextField(10);
   TextField accelerationText       = new TextField(10);
   Button    launch                 = new Button("LAUNCH!");
   TextArea  answers                = new TextArea(
                                            "I am ready for your first trip.",
                                            8,
                                            60,
                                            TextArea.SCROLLBARS_NONE
                                          );
      
   public void init( )
   {      
      // Some messages for the top of the Applet:  
      addHorizontalLine(Color.orange);
      addNewLine( );
       
      // The two text fields and the launch button:
      add(distanceText);
      add(new Label("Distance of trip in light years"));
      addNewLine( );
      add(accelerationText);
      add(new Label("Acceleration of rocket in g's"));
      addNewLine( );
      add(launch);
      addNewLine( );
      
      // A text area for printing the answers:
      answers.setEditable(false);
      add(answers);
      addNewLine( );
      addHorizontalLine(Color.orange);
      
      // Tell the button what it should do when clicked:
      launch.addActionListener(new LaunchListener( ));
   }

   class LaunchListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         double distance;     // Distance of the trip in light years.
         double acceleration; // Acceleration of the trip in g's.
         
         distance = atod(distanceText.getText( ));
         if (Double.isNaN(distance) || distance < 0)
         {
            answers.setText("Type a non-negative distance before launching.");
            distanceText.requestFocus( );
            distanceText.selectAll( );
            return;
         }
 
         acceleration = atod(accelerationText.getText( ));
         if (acceleration == Double.NaN || acceleration <= 0)
         {
            answers.setText("Type a positive acceleration before launching.");
            accelerationText.requestFocus( );
            accelerationText.selectAll( );
            return;
         }
         
         makeTrip(distance, acceleration);
      }                   
   }


   // The inverse hyperbolic sine function:
   double asinh(double x)
   {
      return Math.log(x + Math.sqrt(x*x + 1));
   }
   
   double atod(String s)
   {
      double answer;
      Double d;
      
      try
      {
         d = new Double(s);
         answer = d.doubleValue( );
      }
      catch (NumberFormatException e)
      {
         answer = Double.NaN;
      }
      return answer;
   }
   
   // Method to compute information about the trip. The parameters are
   // the total trip distance (in light years) and the acceleration (in
   // g's). The computation methods come from
   // http://www.desy.de/user/projects/Physics/rocket.html
   // The makeTrip method is not private because some browsers won't allow
   // an inner class to access a private method.
   void makeTrip(double distance, double acceleration)
   {
      final double LIGHT_YEAR       = 9.47e15; // meters per light year
      final double c                = 3.00e8;  // speed of light in meters/sec
      final double g                = 9.81;    // gravity in meters/sec^2
      final double SECONDS_PER_YEAR = 60.0 * 60.0 * 24.0 * 365.25; 
      
      double d;            // Half of trip in meters
      double a;            // Acceleration in meters/sec^2
      double time_earth;   // Time for trip as viewed from Earth (seconds)
      double time_ship;    // Time for trip as viewed from rocket(seconds)
      double years_earth;  // Time for trip as viewed from Earth (years)
      double years_ship;   // Time for trip as viewed from rocket(years)
      
      // Computations:
      d = LIGHT_YEAR * distance / 2;
      a = g * acceleration;
      time_earth = 2*Math.sqrt( (d*d)/(c*c) + 2*d/a );
      time_ship = 2*(c/a) * asinh(a*time_earth/c);
      years_earth = time_earth / SECONDS_PER_YEAR;
      years_ship = time_ship / SECONDS_PER_YEAR;
      
      // Print the answers:
      answers.setText("");
      answers.append("Trip length:   ");
      answers.append((new Double(distance)).toString( ) + " light years.\n");
      answers.append("Acceleration:  ");
      answers.append((new Double(acceleration)).toString( ) + " g.\n");
      answers.append("Time on earth: ");
      answers.append((new Double(years_earth)).toString( ) + " years.\n");
      answers.append("Time on ship:  ");
      answers.append((new Double(years_ship)).toString( ) + " years.\n");
      answers.append("Bon Voyage!\n");
      answers.append("\nI am ready for your next trip.");
   }

   private void addHorizontalLine(Color c)
   {  
      // Add a Canvas 10000 pixels wide but only 1 pixel high, which acts as
      // a horizontal line to separate one group of components from the next.
      Canvas line = new Canvas( );
      line.setSize(10000,1);
      line.setBackground(c);
      add(line);
   }

   
   private void addNewLine( ) 
   {  
      // Add a horizontal line in the background color. The line itself is
      // invisible, but it serves to force the next Component onto a new line.
      addHorizontalLine(getBackground( ));
   }

      
}

