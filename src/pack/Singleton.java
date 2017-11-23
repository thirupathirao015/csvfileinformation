package pack;

class Abc{
	
	static Abc obj; //static instance created.
	
	private Abc(){
		System.out.println("hi thirupathi");
	}
	
	public static Abc getConnection(){
		if(obj==null){
		obj=new Abc();
		}
		return obj;	
	}
}
public class Singleton {

	public static void main(String[] args) {
		Thread t1=new Thread(
				new Runnable(){
			   public void run(){
				Abc obj=Abc.getConnection();
			}
		});
		Thread t2=new Thread(
				new Runnable(){
			   public void run(){
				Abc obj1=Abc.getConnection();
			}
		});
		t1.start();
		t2.start();
		
	}

}
