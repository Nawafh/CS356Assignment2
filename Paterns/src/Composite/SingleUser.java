
//Class writen by Nawaf ALsufiani
//  leaf
package Composite;
import java.util.Hashtable;

public class SingleUser implements User
{
       private int id;
	   private String name;
   
	   public SingleUser(String name,int id) {
		      this.name = name;
		      this.id = id;
	   }
	
	   public int getId(){
		      return id;
	   }
	
	   public String getName(){
		      return name;
	   }
	
	public void setId(int id){
		   this.id= id;
	}
	
	public void setName(String name){
		   this.name= name;
	}

	@Override
	public void display(){
		   System.out.println("name: "+ name+" id: "+id);
		
	}

	

	
}
