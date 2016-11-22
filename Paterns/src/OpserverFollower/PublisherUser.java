package OpserverFollower;


public class PublisherUser extends Single{

       private String message;
	
       public void setMessage(String message){
              this.message=message;		
              notifyObservers();
	   }
	
	   public String getMessage() {
		      return message;
		
	    }
	
	
}
