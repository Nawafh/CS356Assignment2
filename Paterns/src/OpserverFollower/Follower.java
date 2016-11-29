package OpserverFollower;

import javax.swing.JTextArea;

public class Follower    implements Observer{
       private JTextArea  jText;
       
       public Follower(JTextArea jText ){
    	   this.jText=jText;
       }
      
      
	   @Override
	   public void update(Single single) {
		
		      if(single instanceof PublisherUser)
		       {
		   
		          jText.setText(jText.getText()+"\n"+((PublisherUser) single).getMessage());
		         
		       }
		     
	    }

}
