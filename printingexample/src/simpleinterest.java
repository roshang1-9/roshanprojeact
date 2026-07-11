
//write a program to calculate simple interest and all the value will be given by user
public class simpleinterest {
	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in) ;
		System.out.println("enter the values of principle , rate and time ");
		int p=sc.nextInt() ,r=sc.nextInt();
		int t=sc.nextInt();
		
		int S= (p*r*t)/100;
		System.out.println("simple interest is = "+S);
		
	}

}
