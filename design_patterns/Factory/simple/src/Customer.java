/*public class Customer{			//raw method,customer base
	public static void main(String args[])
	{
		BMW320 bmw320 = new BMW320();
		BMW532 bmw532 = new BMW532();
	}
}*/

public class Customer{
	public static void main(String args[]){
		Factory factory = new Factory();
		BMW bmw320 = factory.createBMW(320);
		BMW bmw532 = factory.createBMW(532);	
		
		bmw320.Show();
		bmw532.Show();
	}
}