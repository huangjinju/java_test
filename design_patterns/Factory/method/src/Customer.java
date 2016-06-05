public class Customer {
	public static void main(String[] args){
		FactoryBMW320 factory320 = new FactoryBMW320();
		FactoryBMW523 factory523 = new FactoryBMW523();
		factory320.createBMW();
		factory523.createBMW();
	}
	
}