package Singleton;
import javax.swing.JFrame;
//Singleton pattern extends jframe for the admin controler
public class Window extends JFrame{

	private static Window instance=null;
	private Window() 
	{
	}
 
	public static Window getInstance()
	{
		if(instance==null)
		{
			instance  = new Window();
		}
		
		return instance;
	}
	
	
	
}
