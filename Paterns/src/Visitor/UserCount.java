package Visitor;

public class UserCount implements Element  {
       private int x=0;
		
     
       @Override
       public void accept(Visitor v) {
			// TODO Auto-generated method stub
		      v.visit(this);
       }
		
		
       @Override
	   public void count() {
			 x++;
       }
     
     
	   public int getUserCount(){  
		      return x;
	   }
}
