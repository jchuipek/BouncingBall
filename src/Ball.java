import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Color;
import java.lang.Runnable;
import java.util.Random;
/**
 * Creates a GUI that allows a Ball to be bounced off the side of a JFrame
 * Implements a runnable and extends a JComponent
 * @author Jordan Chuipek
 */
public class Ball extends JComponent implements Runnable
{ 
	/**
	 * Stores the ball's position relative to the x-axis as an integer
	 */
	private int xcord;
	/**
	 * Stores the ball's position relative to the y-axis as an integer
	 */
	private int ycord;
	/**
	 * Stores a randomly generated number for the color red as an integer
	 */
	private int red;
	/**
	 * Stores a randomly generated number for the color green as an integer
	 */
	private int green;
	/**
	 * Stores a randomly generated number for the color blue as an integer
	 */
	private int blue;
	/**
	 * Stores the speed of the ball relative to the x-axis as an integer 
	 */
	private int changex = 2;
	/**
	 * Stores the speed of the ball relative to the y-axis as an integer
	 */
	private int changey = 2;
	/**
	 * Stores a randomly generated number between 0 and 7 as an integer
	 */
	private int random;
	/**
	 * Stores the radius of the ball as an integer
	 */
	private int radius = 15;
	
	/**
	 * Ball Constructor 
	 * Generates random ball colors
	 * Sets the initial position of the ball
	 * Generates a random direction for the ball
	 * @param x, the initial x-coordinate position
	 * @param y, the initial y-coordinate position
	 */
	public Ball(int x,int y)
	{
		//Sets the coordinates of the ball
		xcord = x;
	    ycord = y;
	    
	    //Generates a number from 0 to 7
	    /**
	     * Object of Random class
	     */
	    Random rand = new Random();
	    random = rand.nextInt(8-0);
	    
	    //Generates a random direction
	    if(random == 0)
	    {
	    	changey = -changey;
	    	changex = -changex;
	    }
	    else if(random == 1)
	    {
	    	changex = -changex;
	    }
	    else if(random == 2)
	    {
	    	changey = -changey;
	    }
	    else if(random == 3)
	    {
	    	changex = 0;
	    	changey = -changey;
	    }
	    else if(random == 4)
	    {
	    	changey = 0;
	    	changex = -changex;
	    }
	    else if(random == 5)
	    {
	    	changex = 0;
	    }
	    else if(random == 6)
	    {
	    	changey = 0;
	    }
	    
	    //Generates random colors
	    red = (int)Math.round((Math.random()*255));
	    green = (int)Math.round((Math.random()*255));
	    blue = (int)Math.round((Math.random()*255));
	}
	
	//Paints the Ball and the Shadows
	/**
	 * Paints the ball and the shadows on the GUI
	 * @param ball, Object from Graphics class
	 */
	public void paintComponent(Graphics ball)
	{
		//Paints the ball
		super.paintComponent(ball);
    	ball.setColor(new Color(red,green,blue));
		ball.fillOval(xcord,ycord,radius,radius);
		
		//Paints the shadow
		super.paintComponent(ball);
		ball.setColor(Color.lightGray);
		ball.fillOval(xcord,565,ycord/20,ycord/20);
		setOpaque(false);
	}
	
	/**
	 * Creates a thread and makes the ball move
	 */
	public void run()
	{
		while(true)
		{
			try
			{
				//Calls the move method
				move();
				//Makes the thread sleep
				Thread.sleep(8);
			}
			catch(InterruptedException exception)
			{
				exception.printStackTrace();
			}
		}
	}
	
	//Moves the ball
	/**
	 * Moves the ball at a certain speed
	 */
	public void move()
	{	
		//Moves the ball
		xcord = xcord + changex;
		ycord = ycord + changey;
		
		//Checks if the ball hits the boundary
		if((xcord > 574)||(xcord < 0))
		{
			//Redirects the ball in the opposite x direction
			changex= -changex;
		}
		else if((ycord > 555)||(ycord < 0))
		{
			//Redirects the ball in the opposite y direction
			changey=-changey;
		}
		//Repaints the ball
		repaint();
	}
}