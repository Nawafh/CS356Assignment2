package Visitor;

public class GroupCount  implements Element
{
	
    private int x=0;
	
    @Override
	public void accept(Visitor v){
		   // TODO Auto-generated method stub
	       v.visit(this);
	}
    
    
    public int getGroupCount() {  
	       return x;
	}

	@Override
	public void count(){
		   x++;
		
	}
}