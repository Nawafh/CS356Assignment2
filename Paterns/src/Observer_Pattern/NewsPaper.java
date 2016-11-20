package Observer_Pattern;

public class NewsPaper extends Subject {

       private String name;
       private String message;
	
       public String getWriterName(){
	          return name;
      }
       
       
	public void setWriterName(String name){
		   this.name = name;
		   notifyObservers();
	}
	
	
	public String getMessage() {
		   return message;
	}
	
	
	public void setMessage(String message) {
		   this.message = message;
		   notifyObservers();
	}
	
}