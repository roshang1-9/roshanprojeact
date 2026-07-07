
public class IFex {
	public static void main(String[] args) {
		System.out.println("Enter age");
		int age=sc.nextInt();
		if (age<0||age>120) {
			System.out.println("invalid age");
		}else if(age<=4) {
			System.out.println("you're infant");
		}else if(age<=13) {
			System.out.println("youre child");
		}else if(age<=19) {
			System.out.println("teenager");
		}else if(age<=50) {
			System.out.println("you're adult");
		}else if(age<=80) {
			System.out.println("you are oldage");
		}else {
			System.out.println("are jaldi bol kal subah panwel nikalna hai");
		}
	}


}
