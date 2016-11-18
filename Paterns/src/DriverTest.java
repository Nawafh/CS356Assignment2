import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.soap.Text;

import Composite.*;
import Observer_Pattern.NewsPaper;
import Observer_Pattern.Reporter;
import Observer_Pattern.Subject;
import Singleton.Window;
import Visitor.*;


public class DriverTest   {

	
	
	public static void main(String[] args) 

	{
      demo();
      
    }

	 
    public static void demo()
   {    //array list to store the users
    	List <SingleUser> listUser = new ArrayList<SingleUser>();
    	//Instanse of element to use visitor patern
    	Element messageCount = new MessageCount();
		Element groupCount = new GroupCount();
		Element userCount = new  UserCount();
		CountVisitor visitor = new CountVisitor();
		//Using singleton pattern for the admin controller
		Window window = Window.getInstance();
		//sub tree from the Jtree
		DefaultMutableTreeNode treeNode01 = new DefaultMutableTreeNode("Group");
		DefaultMutableTreeNode treeNode0 = new DefaultMutableTreeNode("Root"); 
		DefaultMutableTreeNode treeNode02 = new DefaultMutableTreeNode("User");
		treeNode0.insert(treeNode01, 0);
		treeNode0.insert(treeNode02, 1);
		DefaultTreeModel model = new DefaultTreeModel(treeNode0);
		//Jtree defines
		JTree tree = new JTree(model);
		//JTextArea
		JTextArea text1 = new JTextArea("User ID");
		JTextArea text2 = new JTextArea("Group ID");
		//JButton
		JButton button1  =new JButton("add User");
		JButton button2  =new JButton("Add Group");
		JButton button3  =new JButton("Open User View");
		JButton button4  =new JButton("show User Total");
		JButton button5  =new JButton("Show Group Total");
		JButton button6  =new JButton("Show Message Total");
		//JPanel
		JPanel addminMenu= new JPanel();
        JPanel PanelTree = new JPanel();
		//button implementation methods
        button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
           
			String  userName = JOptionPane.showInputDialog("Please enter the User name");
			int  userId = Integer.parseInt(JOptionPane.showInputDialog("Please enter the User ID"));
			SingleUser newSingleUser = new SingleUser(userName, userId);
			listUser.add(newSingleUser);
			userCount.count();
			DefaultMutableTreeNode newDefaultMutableTreeNode = new DefaultMutableTreeNode(userName);
			model.insertNodeInto(newDefaultMutableTreeNode, treeNode02, 0);
			
		}
	});
		button2.addActionListener(new ActionListener() {


			
			@Override
			public void actionPerformed(ActionEvent e) {

			
				String  groupName = JOptionPane.showInputDialog("Please enter the group name");
				int  groupId = Integer.parseInt(JOptionPane.showInputDialog("Please enter the group ID"));
				Group newGroup = new Group(groupName, groupId);
				groupCount.count();
				DefaultMutableTreeNode newDefaultMutableTreeNode = new DefaultMutableTreeNode(groupName);
				model.insertNodeInto(newDefaultMutableTreeNode, treeNode01, 0);
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                  String message;
				  JPanel panel1 = new JPanel();
				  JPanel panel2 = new JPanel();
				  JPanel panel3 = new JPanel();
				  JPanel panel4 = new JPanel();
				  JPanel panelMain = new JPanel();
		          JFrame userWindow = new JFrame();
		          JTree tree = new JTree(treeNode02);
		          
		          JButton button1 =new JButton("Follow User");
		          JButton button2 =new JButton("Post Tweet");
		          JTextArea textArea1 = new JTextArea("UserID");
		          JTextArea textArea2= new JTextArea("Message",5,20);
		           
		          JTextArea textArea3= new JTextArea("tweet",1,20);
		          JTextArea textArea4= new JTextArea("Folowers",50,4);
		           
		          panel1.add(textArea1);
		          panel1.add(button1);
		          panel3.add(button2);
		           panel2.add(textArea2);
		          panel3.add(textArea3);
		          panel4.add(textArea4);
		         button2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						textArea2.setText(textArea2.getText()+"\n"+textArea3.getText());
						
						messageCount.count();
					}
				});
		         
		          
		         userWindow.add(tree,BorderLayout.WEST);
		         userWindow.add(panel1,BorderLayout.NORTH);
		         userWindow.add(panel2,BorderLayout.CENTER);
		         userWindow.add(panel3,BorderLayout.SOUTH);
		         userWindow.add(panel4,BorderLayout.EAST);
		         
		        textArea2.setText("Send Message\n"); 
		        String h = textArea2.getText();
		      
		        userWindow.setLocation(500,200);
		        userWindow.setSize(500,500);
		        userWindow.setVisible(true);
			}
		});
		
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				userCount.accept(visitor);
			}
		});
		
		
		
button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				groupCount.accept(visitor);
			}
		});



button6.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		messageCount.accept(visitor);
	}
});

		//Tree Methods
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) 
			{
				
				
				{ 
				
				if(e.getPath().getLastPathComponent().toString().equals("User"))
				{
					
					System.out.println("it works");
				}
					
				
				}
			}
		});
		
		addminMenu.add(text1);
		addminMenu.add(button1);
		addminMenu.add(text2);
		addminMenu.add(button2);
		addminMenu.add(button3);
		addminMenu.add(button4);
		addminMenu.add(button5);
		addminMenu.add(button6);
		 
		PanelTree.add(tree);
		// JFrame methods
		
		
		
		window.add(tree,BorderLayout.WEST);
		
		
		window.add(addminMenu);
		window.setSize(500, 233);
		 
		window.setVisible(true);
		window.setLocation(500, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
   }
}
