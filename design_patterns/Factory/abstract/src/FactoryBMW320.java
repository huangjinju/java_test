
public class FactoryBMW320 extends AbstractFactory{
	public Engine createEngine(){
		return new EngineA();
	}
	
	public Aircondition createAircondition(){
		return new AirconditionA();
	}
}