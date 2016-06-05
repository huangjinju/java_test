public class FactoryBMW523 extends AbstractFactory{
	public Engine createEngine(){
		return new EngineB();
	}
	
	public Aircondition createAircondition(){
		return new AirconditionB();
	}
}