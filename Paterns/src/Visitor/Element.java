package Visitor;

public interface Element 
{
   public void accept(Visitor v);
   public void count();
}

