package Visitor;

public interface Visitor {

       public void visit(MessageCount  e);
	   public void visit(UserCount  e);
	   public void visit(GroupCount  e);
}
