package Visitor;

import javax.swing.JOptionPane;

public class CountVisitor implements Visitor{

	@Override
	public void visit(MessageCount  e) 
	{
		
		JOptionPane.showMessageDialog(null,"The total number of messages is"+ e.getMessageCount());
		
	}

	public void visit(GroupCount  e) 
	{
		
		JOptionPane.showMessageDialog(null,"The total number of Group  is"+ e.getGroupCount());
		
	}

	@Override
	public void visit(UserCount e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,"The total of messages is"+ e.getUserCount());
		
	}

	

	
	
}
