import javax.swing.JFrame;

/**
 * Creates and displays the GUI
 * @author Jordan Chuipek
 */
public class BallTest 
{
	public static void main(String[] args)
	{
		//Creates an object from the BallJFrame class
		/**
		 * Object of BallJFrame class
		 */
		BallJFrame ball = new BallJFrame();
			
		//Sets the size of GUI and displays it
		ball.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ball.setSize(600,600);
		ball.setResizable(false);
		ball.setVisible(true);
				
	}
}