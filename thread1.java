package java;
class runthread implements Runnable{
	
	public void run(){
		try{
			for( int i=10;i>=1;i--){
			System.out.println(i);
			Thread.sleep(500);}
		}catch(InterruptedException e){
			System.out.println(e);
		}
	
	}
}

class thread1{
	public static void main(String[] args){	
	
	Thread t1 = new Thread(new runthread());
	t1.start();
	
	try{
		for(int i=10;i>=1;i--){
		System.out.println(i);
		Thread.sleep(500);}
		}catch(InterruptedException e){
		System.out.println(e);
	}
}
}


	