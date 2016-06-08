class TestSingleton {
	String name = null;

    private TestSingleton(){
		
	}
	
    private static volatile TestSingleton instance = null;
    public static TestSingleton getInstance(){
    	if(instance==null)
    	{
    		synchronized (TestSingleton.class){
    			if(instance == null){
    				instance = new TestSingleton();
    			}
    		}
    	}
    	return instance;
    }
    
    public void setName(String Name) {
    	name = Name;
    }
    public String getName(){
    	return name;
    }
    public void printInfo(){
    	System.out.print("name = "+ name + "\n");
    }
}

public class singleton_test{
	public static void main(String[] args){
		TestSingleton ts1 = TestSingleton.getInstance();
		TestSingleton ts2 = TestSingleton.getInstance();
		ts1.setName("wujianxia");
		ts2.setName("huangjinju");
		ts1.printInfo();
		ts2.printInfo();
		if(ts1==ts2){
			System.out.print("创建的是同一实例\n");
		}
		else{
			System.out.print("创建的不是同一实例\n");
		}
	}
}


