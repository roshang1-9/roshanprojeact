class M1{
	int x=10;
	M1(int a){
		System.out.println("Hi M");
		x=a;
	}
}
class N extends M1{
	int y=20;
	N(){ super(7);
		System.out.println("Hi N");
	}
}
public class InheritanceExConstructor2 {
	public static void main(String[] args) {
		N n=new N();
		System.out.println(n.x+" "+n.y);
		
	}
}