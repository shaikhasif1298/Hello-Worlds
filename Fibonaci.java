import java.util.*;
import java.lang.*;

class Fibonaci
{
  public static void main(String args[]){
    Scanner in =new Scanner(System.in);
    System.out.println("Enter The no of terms");
    int no=in.nextInt();
    int a=0,b=1,c=0;
    System.out.println("\n"+a+"\n"+b);
    for(int i=1;i<no;i++)
    {
       c=a+b;
       a=b;
       b=c;
       System.out.println("\n"+c);
    }
}
}