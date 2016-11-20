package Observer_Pattern;

public class Reporter implements Observer 
{

	@Override
	public void update(Subject subject) 
	{

         if(subject instanceof NewsPaper)
         {
        	System.out.println(((NewsPaper) subject).getMessage());
         }
		
	}

}
