//Class writen by Nawaf ALsufiani
// Component the leaf and the component
package Composite;

 import java.util.*;
 public class Group implements User{
      private String name;
      private int id;
      //Store the Component the leaf and the component
      private List <User> child;
	
      
      public Group(String name,int id) {
             this.name = name;
             this.id = id;
             child = new ArrayList<User>();
	  }
	
      
  public int getId(){
		 return id;
  }
	
  
  public String getName(){
		 return name;
  }
	
  public void add(User e){
		child.add(e);
  }
	
  
  public void display(){
	     System.out.println("Group Name: "+this.name+ "Group Id"+this.id);
	     for (User users : child)
	     {    
	    	 users.display();
	     }
		
   }
	
}
