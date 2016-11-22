import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import Composite.*;
import Singleton.Window;
import Visitor.*;


public class DriverTest   {

	private static Element messageCount = new MessageCount();
	
	
       public static void main(String[] args){
		      demo();
		      
		      
		      
	   }

       public static void getTextArea(JTextArea area)
   	{
   		JTextArea e = area;
   		e.setText("hello");
   	}
       
	   //Method to hand the window of the User
	   public static void userGui(String currentUser,List<SingleUser> users){
		      List<SingleUser> newUsers =new ArrayList<SingleUser>();
	          List<String> followers =new ArrayList<String>();
	          newUsers.addAll(users);
	          newUsers.remove(currentUser);
	          System.out.println("Main"+users);
	          String userName = currentUser;
		      JFrame frame = new JFrame(userName);
		      JPanel panel1 = new JPanel();
		      JPanel panel2= new JPanel();
		      JPanel panel3 = new JPanel();
		      JPanel panel4 = new JPanel();
		      JPanel panel5 = new JPanel();
		      JButton  post = new JButton("Post");
		      JButton  follow = new JButton("Follow");
		      JTextArea userId = new JTextArea("User ID");
		      JTextArea tweet = new JTextArea(1,15);
		      JTextArea message = new JTextArea(15,15);
		      //folowers tree
		      DefaultMutableTreeNode subTree1 = new DefaultMutableTreeNode("Followers");
	 	      DefaultTreeModel mode1 = new DefaultTreeModel(subTree1);
		      JTree followersTree = new JTree(mode1);
		      DefaultMutableTreeNode subTree2 = new DefaultMutableTreeNode("Users");
		      
		      for(int i=0;i<newUsers.size();i++)
		      {  
			      DefaultMutableTreeNode x = new DefaultMutableTreeNode(users.get(i).getName());
			      subTree2.insert(x, 0);
		      }
		      DefaultTreeModel mode2 = new DefaultTreeModel(subTree2);
		      JTree usersTree = new JTree(mode2);
		      panel1.add(userId);
		      panel1.add(follow);
		      panel2.add(message);
		      panel3.add(tweet);
		      panel3.add(post);
		      panel4.add(usersTree);
		      panel5.add(followersTree);
		
		      frame.add(panel1,BorderLayout.NORTH);
		      frame.add(panel2,BorderLayout.CENTER);
		      frame.add(panel3,BorderLayout.SOUTH);
		      frame.add(panel4,BorderLayout.WEST);
		      frame.add(panel5,BorderLayout.EAST);
		      frame.setSize(500, 500);
		      frame.setVisible(true);
		      
		      usersTree.addTreeSelectionListener(new TreeSelectionListener() {
			  @Override
			   public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
			   if(e.getPath().getLastPathComponent().toString()!="Users"){
				  userId.setText(e.getPath().getLastPathComponent().toString());
				}
				
			   }
		       });
		
		      followersTree.addTreeSelectionListener(new TreeSelectionListener() {
			
			  @Override
			  public void valueChanged(TreeSelectionEvent e) {
			         if(e.getPath().getLastPathComponent().toString()=="User ID"){
				        JOptionPane.showMessageDialog(null, "Please select user"); 
				  
				      }
			  }
		      });
		      
		      post.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
				     String m = message.getText();
				     String twitt = m+tweet.getText();
				     message.setText(m+"\n"+currentUser+": "+tweet.getText());
				     tweet.setText(null);
				     messageCount.count();
			  }
		      });
            
		      follow.addActionListener(new ActionListener() {
			
			  @Override
			  public void actionPerformed(ActionEvent e) {
			         if(!userId.getText().equals(currentUser)){
					if(!userId.getText().equals("User ID"))
					{ 
						if(!followers.contains(userId.getText()))	
						{   followers.add(userId.getText());
						    DefaultMutableTreeNode defaultMutableTreeNode=new DefaultMutableTreeNode(userId.getText());
						    mode1.insertNodeInto(defaultMutableTreeNode, subTree1, 0);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"The list already contain the user");
						}
					 }
			    }
			         else{
				          JOptionPane.showMessageDialog(null,"You can't follow youself");
			         }
			 }
		     });
	    }
				
				
		 
	 
       public static void demo(){
              //array list to store the users
              List <SingleUser> listUser = new ArrayList<SingleUser>();
              //Instanse of element to use visitor patern
              
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
		public void actionPerformed(ActionEvent e){ 
		            String  userName = JOptionPane.showInputDialog("Please enter the User name");
			        int userId = Integer.parseInt(JOptionPane.showInputDialog("Please enter the User ID"));
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
			    	
				if(text1.getText().equals("User ID")){
				   JOptionPane.showMessageDialog(null, "Please Select a User from the tree");
				}
				
				else{
					userGui(text1.getText(), listUser);
				}
				
			}
		});
        
        
		        button4.addActionListener(new ActionListener() {
			
		 @Override
		 public void actionPerformed(ActionEvent e) 
			{
				   userCount.accept(visitor);
			}
		});
        button5.addActionListener(new ActionListener() 
        {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				groupCount.accept(visitor);
			}
		});

        button6.addActionListener(new ActionListener(){
	        @Override
	         public void actionPerformed(ActionEvent e){
	        	messageCount.accept(visitor);
         	}
            });

		     //Tree Methods
		     tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			 public void valueChanged(TreeSelectionEvent e){
				    String h = e.getPath().getLastPathComponent().toString();
				    if(e.getPath().getLastPathComponent().toString()!="Root"&&e.getPath().getLastPathComponent().toString()!="User"&&e.getPath().getLastPathComponent().toString()!="Group"){
						 if(e.getPath().getParentPath().getLastPathComponent().toString()=="User"){
								System.out.println("User child");
								text1.setText(e.getPath().getLastPathComponent().toString());
						   }
							
						 else if(e.getPath().getParentPath().getLastPathComponent().toString()=="Group"){
								text2.setText(e.getPath().getLastPathComponent().toString());
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
