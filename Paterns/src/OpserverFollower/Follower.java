package OpserverFollower;

import javax.swing.JTextArea;

public class Follower  implements Observer{

	   @Override
	   public void update(Single single) {
		
		      if(single instanceof PublisherUser)
		       {
		         System.out.println("The Current Message is:"+ ((PublisherUser) single).getMessage());
		         
		       }
		     
	    }

}
