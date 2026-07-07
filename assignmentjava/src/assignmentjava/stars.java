package assignmentjava;

public class stars {
	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("enter the numbers of stars");
		int n=sc.nextInt();
		int h=1;
		for (int i=n;i>=1;i--) {
			for (int j=1;j<=i;j++){
			System.out.println("*");
		}
			System.out.println();
			h--;
			
		}
	}

}
