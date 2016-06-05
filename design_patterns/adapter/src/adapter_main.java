
class adaptee {
	public void specrequest(){
		System.out.print("特殊功能的请求\n");	
	}
}

interface target {
	void request();
	
};

class ConcreteTarget implements target
{
	public void request()
	{
		System.out.print("普通功能的请求\n");
	}
};
/*
class Adapter extends adaptee implements target{
	public void request()
	{
		super.specrequest();
	}
}





public class adapter_main{
	public static void main(String[] args){
		//使用普通功能
		target comm_target = new ConcreteTarget();
		comm_target.request();
		
		//使用特殊功能
		target spe_adapter = new Adapter();
		spe_adapter.request();
		
		return ;
	}
}

*/


class Adapter implements target {
	private adaptee m_adaptee ;
	
	public Adapter(adaptee my_adaptee){
		m_adaptee = my_adaptee;
	}
	
	public void request(){
		m_adaptee.specrequest();
	}
	
}



public class adapter_main{
	public static void main(String[] args){
		target com_target = new ConcreteTarget();
		com_target.request();
		
		target  spe_target = new Adapter(new adaptee());
		spe_target.request();
		
		
	}
	
}





