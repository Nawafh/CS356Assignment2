package Visitor;
public class MessageCount implements Element {
       private int x=0;
       
       
	   @Override
	   public void accept(Visitor v){
		// TODO Auto-generated method stub
		      v.visit(this);
	   }
	   
	   
	   @Override
	   public void count(){
		      x++;
	   }
	   
	   
	   public int getMessageCount(){  
	          return x;
	   }
}
