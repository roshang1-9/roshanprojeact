class AA{
	int x=90;
	void m() {
		System.out.println("Hello A");
	}
}
public class ArrayEx8 {
	public static void main(String[] args) {
		//Normal way of creating objects
//		A a=new A();
//		A b=new A();
//		A c=new A();
//		A d=new A();
		
		//creating objects via Array
		AA a[]=new AA[4];
		a[0]=new AA();
		a[1]=new AA();
		a[2]=new AA();
		a[3]=new AA();
		//or
		AA aa[]={new AA(), new AA(), new AA(), new AA()};
		//or
		AA aaa[]=new AA[4];
		for(int i=0;i<aaa.length;i++) {
			aaa[i]=new AA();
		}
		
		//accessing one of the object
		aaa[2].m();
		aaa[2].x=900000;
		System.out.println(aaa[2].x);
		
		for(AA k:aaa) {
			System.out.println(k.x);
		}
	}
}