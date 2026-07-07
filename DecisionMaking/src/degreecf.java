//wap to calculate celcius to fahrenheit and vice versa
public class degreecf {
	public static void main(String[] args) {
		System.out.println("enter d for degree and f for fahrenhiet");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		char ch = sc.next().charAt(0);
		if (ch == 'd') {
			System.out.println("enter the degree");
			double d = sc.nextDouble();
			double f = (d * 9 / 5) + 32;
			System.out.println("fahrenheit is " + f);
		} else if (ch == 'f') {
			System.out.println("enter the fahrenheit");
			double f = sc.nextDouble();
			double d = (f - 32) * 5 / 9;
			System.out.println("degree is " + d);
			sc.close();
		}
	}

}
