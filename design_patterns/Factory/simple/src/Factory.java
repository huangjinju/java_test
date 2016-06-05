
public class Factory {
	
	public Factory()
	{
		System.out.print("创建工厂\n");
	}
		
	public BMW createBMW(int type){
		switch(type){
		case 320:
			return new BMW320();
		case 532:
			return new BMW532();
		default:
			break;
		}
		return null;
	}
}
