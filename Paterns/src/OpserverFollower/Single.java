package OpserverFollower;
import java.util.ArrayList;
import java.util.List;

public abstract class Single {

       private List <Observer>Observer = new ArrayList<Observer>();
       
       public Single() {
	         // TODO Auto-generated constructor stub
       }
      
       public void addObserver(Observer newObserver){
	          Observer.add(newObserver);
       }


       public void notifyObservers(){
	          for(int i=0;i<Observer.size();i++)
	             {
		          Observer.get(i).update(this);
	             }
	
       }

}
