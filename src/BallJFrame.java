//import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;

//import Boundary.MouseHandler;

public class BallJFrame extends JFrame
{
	/**
	 * Object of the Ball class
	 */
	private Ball ball;
	/**
	 * x-coordinate position of the ball as an integer
	 */
	private int xcord;
	/**
	 * y-coordinate position of the ball as an integer
	 */
	private int ycord;
	/**
	 * Object of ExecutorService
	 */
	private ExecutorService threadExecutor;
	
	/**
	 * Constructor of BallJFrame
	 * Adds a mouse listener to the JFrame
	 */
	public BallJFrame()
	{
		super("Bouncing Ball");
		//Creates a thread pool
		threadExecutor = Executors.newCachedThreadPool();
		
		//Creates a mouse listener for the JFrame
		MouseHandler handler = new MouseHandler();
		getContentPane().addMouseListener(handler);
	
	}
	/**
	 * Mouse Listener
	 * Allows the user to click the JFrame
	 * @author Jordan
	 *
	 */
	private class MouseHandler implements MouseListener
	{	
		//Mouse Listener, determines when the mouse it pressed
		/**
		 * Activates when the user presses the JFrame
		 * @param event, Object of MouseEvent
		 */
		public void mousePressed(MouseEvent event)
		{	
			//Gets the coordinates of the mouse press
			xcord = event.getX();
			ycord = event.getY();
			
			//Creates a new object from ball class
			/**
			 * Object of Ball class that passes the position of the click
			 */
			ball = new Ball(xcord,ycord);
			//Adds the ball to the JFrame
			getContentPane().add(ball);
			
			validate();
			threadExecutor.execute(ball);
		}
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
	}
}