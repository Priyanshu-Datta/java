class runthread extends Thread{
	
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

class thread2{
	public static void main(String[] args){	
	
        runthread t1 = new runthread();
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


	