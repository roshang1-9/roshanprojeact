
public class nestedif {

	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("enter a no. : ");
		int n=sc.nextInt();
		if(n>0) {
			System.out.println("positive");
			if(n%2==0) {
				System.out.println("even");
			}else {
				System.out.println("odd");
			}
		}else if(n<0) {
			System.out.println("negative");
		}else {
			System.out.println("zero");
		}
		System.out.println("thank you");
	}

}
